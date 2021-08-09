package EXlista_IOO_04.CartaoDebito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteCartaoDebito {

    /*private static final double DELTA = 0.001;

    private ContaBancaria conta;
    private CartaoDebito debito;

    @BeforeEach
    public void antesDeCadaTeste() {
        conta = new ContaBancaria();
        conta.depositar(1000);

        debito = new CartaoDebito(conta, 123456, "Diego Marczal", "123456");
    }

    @Test
    public void devePossuirNumeroConformeConstrutor() {
        assertEquals(123456, debito.getNumero());
    }

    @Test
    public void devePossuirNomeConformeConstrutor() {
        assertEquals("Diego Marczal", debito.getNome());
    }

    @Test
    public void devePermitirDebitoInformadoValorESenha() {
        assertTrue(debito.pagar(100, "123456"));

        assertEquals(900, conta.getSaldo(), DELTA);
    }

    @Test
    public void naoDevePermitirDebitoComSenhaIncorreta() {
        assertFalse(debito.pagar(100, "12345"));

        assertEquals(1000, conta.getSaldo(), DELTA);
    }

    @Test
    public void naoDevePermitirDebitoSemSaldo() {
        assertFalse(debito.pagar(1100, "123456"));

        assertEquals(1000, conta.getSaldo(), DELTA);
    }
    */

}