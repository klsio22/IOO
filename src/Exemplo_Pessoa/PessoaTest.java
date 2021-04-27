package Exemplo_Pessoa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    private Pessoa p;

    @BeforeEach
    public void executadoAntesDeCadaTeste() {
        p = new Pessoa("Klesio","Nascimento");
       // p.setNome("Rafael");
       // p.setSobrenome("Almeida");
    }

    @Test
    public void deveTerOEstadoInicialVazil() {
        p = new Pessoa();
        assertEquals("",p.getNome());
        assertEquals("",p.getSobrenome());
    }

    @Test
    public void deveAlterarOAtributoNome() {
        assertEquals("Klesio", p.getNome());
    }

    @Test
    public void deveAlterarOAtributoSobrenome() {
        assertEquals("Nascimento", p.getSobrenome());
    }

    @Test
    public void deveRetornarONomeCompleto() {
        assertEquals("Klesio Nascimento", p.getNomeCompleto());
    }
}