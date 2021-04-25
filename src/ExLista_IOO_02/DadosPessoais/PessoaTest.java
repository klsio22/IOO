package ExLista_IOO_02.DadosPessoais;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {

    private Pessoa01 p1;

    @BeforeEach
    public void executadoAntesDeCadaTeste() {
        p1 = new Pessoa01();
        p1.setNome("Rafael");
        p1.setSobreNome("Almeida Sousa");
        p1.setAnoNascimento(1997);
    }
    
    @Test
    public void deveAlterarOAtributoNome() {
        assertEquals("Rafael", p1.getNome());
    }

    @Test
    public void deveAlterarOAtributoSobrenome() {
        assertEquals("Almeida Sousa", p1.getSobreNome());
    }

    @Test
    public void deveRetornarONomeCompleto() {
        assertEquals("Rafael Almeida Sousa", p1.getNomeCompleto());
    }

    @Test
    public void deveRetornarIdade(){
        assertEquals(24, p1.getIdade());
    }

    @Test
    public  void IdadeEmMeses(){
        assertEquals(288,p1.getIdadeEmMeses());
    }

}