package Simulado02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
	
public class ContaTeste {
	
    // Delta is the maximum difference (delta) between expected and actual
	// for which both numbers are still considered equal.
	private static float DELTA = 0.0f;
	
	private Conta conta;
	private Cliente cliente;
	
	@BeforeEach
	public void setUp() {
		cliente = new Cliente("Ruby da Silva", "433.616.121-60");
		conta = new Conta(cliente);
	}
	
	@Test
	public void deveTerLimiteInicial() {
		assertEquals(500, conta.getLimite(), DELTA);
	}
	
	@Test
	public void deveTerSaldoInicialIgualAZero() {
		assertEquals(0, conta.getSaldo(), DELTA);
	} 
	
	@Test
	public void devePermitirVerOSaldoComOLimite() {
		assertEquals(500, conta.getSaldoComLimite(), DELTA);
	}
	
	@Test
	public void devePermitirRealizarDeposito() {
		assertTrue(conta.depositar(1000));
		assertEquals(1000, conta.getSaldo(), DELTA);
		
		assertTrue(conta.depositar(150));

		assertEquals(1150, conta.getSaldo(), DELTA);
		assertEquals(1650, conta.getSaldoComLimite(), DELTA);
	}
	
	@Test
	public void naoDeveConsiderarValoresNegativosNoDeposito() {
		assertFalse(conta.depositar(-1000));
		
		assertEquals(0, conta.getSaldo(), DELTA);
		assertEquals(500, conta.getSaldoComLimite(), DELTA);
	}
	
	@Test
	public void devePermitirRealizarSaque() {
		conta.depositar(500);
		
		assertEquals(300, conta.sacar(300), DELTA);
		assertEquals(200, conta.getSaldo(), DELTA);
		assertEquals(700, conta.getSaldoComLimite(), DELTA);
	}
	
	@Test
	public void naoDeveConsiderarValoresNegativosNoSaque() {
		conta.depositar(500);
		
		assertEquals(0, conta.sacar(-300), DELTA);
		assertEquals(500, conta.getSaldo(), DELTA);
		assertEquals(1000, conta.getSaldoComLimite(), DELTA);
	}
	
	@Test
	public void devePermitirUsarOLimiteCasoNaoHajaSaldo() {
		assertEquals(300, conta.sacar(300), DELTA);
		assertEquals(-300, conta.getSaldo(), DELTA);
		assertEquals(200, conta.getSaldoComLimite(), DELTA);
	}
	
	@Test
	public void naoDevePermitirSacarCasoNaoExistaSaldoNemLimite() {
		conta.depositar(500);
		
		assertEquals(0, conta.sacar(1300), DELTA);
		assertEquals(500, conta.getSaldo(), DELTA);
		assertEquals(1000, conta.getSaldoComLimite(), DELTA);
		
		assertEquals(1000, conta.sacar(1000), DELTA);
		assertEquals(0, conta.sacar(1), DELTA);
	}
	@Test
	public void devePermitirSacarTudo() {
		conta.depositar(500);
		
		assertEquals(1000, conta.sacar(1000), DELTA);
		assertEquals(-500, conta.getSaldo(), DELTA);
		assertEquals(0, conta.getSaldoComLimite(), DELTA);
	}


	public void deveRetornarOExtratoDaContaBancaria() {
		assertEquals(getPradaoDoExtrato(), conta.getExtrato());
		
		conta.depositar(500);
		assertEquals(getPradaoDoExtrato(), conta.getExtrato());
		
		conta.sacar(1000);
		assertEquals(getPradaoDoExtrato(), conta.getExtrato());
	}

	private String getPradaoDoExtrato() {
		String extrato = "";
		extrato += "-----------------------------\n";
		extrato += "Cliente: " + cliente.getNome() + "\n";
		extrato += "CPF: " + cliente.getCpf() + "\n\n";
		extrato += "-----------------------------\n";
		extrato += "Descrição        | Valor (R$)\n";
		extrato += "-----------------------------\n";
		extrato += "Saldo            | " + conta.getSaldo() +"\n";
		extrato += "Limite           | " + conta.getLimite() +"\n";
		extrato += "Saldo com Limite | " + conta.getSaldoComLimite() +"\n";
		return extrato;
	}
}
