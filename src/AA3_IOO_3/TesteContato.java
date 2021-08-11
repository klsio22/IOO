package AA3_IOO_3;
//Klésio Antônio do Nascimento

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteContato {

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
	public void contagemDeGols() {
		jogador.setGols(3);
		jogador.setGols(2);

		assertEquals(5,jogador.getGols());
	}

}
