package ExLista_IOO_02.Contra_bancaria_simplificada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteContaBancaria {

    private static final double DELTA = 0.001;
    private ContaBancaria conta;

    @BeforeEach
    public void antesDeCadaTeste() {
        conta = new ContaBancaria();
    }

    @Test
    public void deveTerSaldoInicialZero() {
        assertEquals(0, conta.getSaldo(), DELTA);
    }

    @Test
    public void deveTerSaldoAlteradoQuandoForDepositado() {
        conta.depositar(50);
        assertEquals(50, conta.getSaldo(), DELTA);
    }

    @Test
    public void naoDeveConsiderarValoresNegativosNoDeposito() {
        conta.depositar(500);
        conta.depositar(-100);

        assertEquals(500, conta.getSaldo(), DELTA);
    }

    @Test
    public void devePermitirFazerRetiradaDaConta() {
        conta.depositar(300);

        assertEquals(100, conta.sacar(100), DELTA);
        assertEquals(200, conta.getSaldo(), DELTA);
    }

    @Test
    public void naoDevePermitirRetiradaSeNaoTiverSaldo() {
        conta.depositar(300);

        assertEquals(0, conta.sacar(500), DELTA);
        assertEquals(300, conta.getSaldo(), DELTA);
    }

    @Test
    public void devePagarJuros() {
        conta.depositar(300);
        conta.pagaJuros();

        assertEquals(315, conta.getSaldo(), DELTA);
    }
}
