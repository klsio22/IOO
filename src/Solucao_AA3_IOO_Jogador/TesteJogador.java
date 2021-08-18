package Solucao_AA3_IOO_Jogador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteJogador {

	private Jogador jogador;
	
	@BeforeEach
	public void antesDeCadaTeste() {
		jogador = new Jogador();
	}

	@Test
	public void deveTerNomeVazio() {
		assertEquals("", jogador.getNome());
	}
	
	@Test
	public void deveTerSobrenomeVazio() {
		assertEquals("", jogador.getSobrenome());
	}
	
	@Test
	public void deveSerInvalidoQuandoONomeForVazio() {
		assertFalse(jogador.eValido());
		
		String erro = "Nome não pode ser vazio.";
		assertEquals(erro, jogador.getErros().get(0));
	}

	@Test
	public void deveSerInvalidoQuandoOSobrenomeForVazio() {
		jogador.setNome("Diego");
		assertFalse(jogador.eValido());
		
		String erro = "Sobrenome não pode ser vazio.";
		assertEquals(erro, jogador.getErros().get(0));
	}

	
	@Test
	public void deveSeTornarValido() {
		assertFalse(jogador.eValido());
		
		jogador.setNome("Diego");
		jogador.setSobrenome("Marczal");
		
		assertTrue(jogador.eValido());
		assertEquals(0, jogador.getErros().size());
	}
	
	@Test
	public void deveAlterarONome() {
		jogador.setNome("Diego");
		assertEquals("Diego", jogador.getNome());
	}
	
	@Test
	public void deveAlterarOSobrenome() {
		jogador.setSobrenome("Marczal");
		assertEquals("Marczal", jogador.getSobrenome());
	}
	
	@Test
	public void deveRetornarONomeCompleto() {
		jogador.setNome("Diego");
		jogador.setSobrenome("Marczal");
		assertEquals("Diego Marczal", jogador.getNomeCompleto());
	}
	
	@Test
	public void deveIgnorarEspacosAntesEDepoisDoNomeESobrenome() {
		jogador.setNome("  Diego  ");
		assertEquals("Diego", jogador.getNome());
		
		jogador.setSobrenome("   Marczal  ");
		assertEquals("Marczal", jogador.getSobrenome());
		
		assertEquals("Diego Marczal", jogador.getNomeCompleto());
	}
	
	@Test
	public void deveRegistrarGols() {
		assertEquals(0, jogador.getGols());
		jogador.incrementarGols();
		assertEquals(1, jogador.getGols());
		
		jogador.incrementarGols();
		jogador.incrementarGols();
		assertEquals(3, jogador.getGols());
	}
	
}
