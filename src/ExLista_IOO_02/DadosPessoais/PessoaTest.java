package ExLista_IOO_02.DadosPessoais;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

class PessoaTest {

    private Pessoa p;

    @BeforeEach
    public void antesDeCadaTeste() {
        p = new Pessoa();
    }

    @Test
    public void deveAlterarOAtributoNome() {
        p.setNome("Paulo");
        assertEquals("Paulo", p.getNome());
    }

    @Test
    public void deveAlterarOAtributoSobrenome() {
        p.setSobrenome("Silva");
        assertEquals("Silva", p.getSobrenome());
    }

    @Test
    public void deveAlterarOAtributoAnoDeNascimento() {
        p.setAnoDeNascimento(2000);
        assertEquals(2000, p.getAnoDeNascimento());
    }

    @Test
    public void deveRetornarONomeCompleto() {
        p.setNome("Paulo");
        p.setSobrenome("Silva");

        assertEquals("Paulo Silva", p.getNomeCompleto());
    }

    @Test
    public void deveRetornarAIdade() {
        p.setAnoDeNascimento(2000);
        int idade = getAnoAtual() - 2000;

        assertEquals(idade, p.getIdade());
    }

    @Test
    public void deveRetornarAIdadeEmMeses() {
        p.setAnoDeNascimento(2000);
        int idadeEmMeses = (getAnoAtual() - 2000) * 12;
        assertEquals(idadeEmMeses, p.getIdadeEmMeses());
    }

    private int getAnoAtual() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }
}