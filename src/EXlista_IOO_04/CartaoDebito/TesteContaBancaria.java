package EXlista_IOO_04.CartaoDebito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteContaBancaria {

	/*private static final double DELTA = 0.001;
	private ContaBancaria conta;

	@Before
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
	public void devePagarJurosAte1000() {
		conta.depositar(300);
		conta.pagaJuros();

		assertEquals(303, conta.getSaldo(), DELTA);
	}
	
	@Test
	public void devePagarJurosAte1000Limite() {
		conta.depositar(1000);
		conta.pagaJuros();

		assertEquals(1010, conta.getSaldo(), DELTA);
	}
	
	@Test
	public void devePagarJurosDe1000A10000() {
		conta.depositar(1100);
		conta.pagaJuros();

		assertEquals(1122, conta.getSaldo(), DELTA);
	}
	
	@Test
	public void devePagarJurosDe1000A10000Limite() {
		conta.depositar(10000);
		conta.pagaJuros();

		assertEquals(10200, conta.getSaldo(), DELTA);
	}
	
	@Test
	public void devePagarJurosAcimaDe10000() {
		conta.depositar(15000);
		conta.pagaJuros();

		assertEquals(15450.0, conta.getSaldo(), DELTA);
	}
	*/

}
