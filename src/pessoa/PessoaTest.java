package pessoa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    private Pessoa p;

    @BeforeEach
    public void executadoAntesDeCadaTeste() {
        p = new Pessoa();
        p.setNome("Rafael");
        p.setSobrenome("Almeida");
    }

    @Test
    public void deveAlterarOAtributoNome() {
        assertEquals("Rafael", p.getNome());
    }

    @Test
    public void deveAlterarOAtributoSobrenome() {
        assertEquals("Almeida", p.getSobrenome());
    }

    @Test
    public void deveRetornarONomeCompleto() {
        assertEquals("Rafael Almeida", p.getNomeCompleto());
    }
}