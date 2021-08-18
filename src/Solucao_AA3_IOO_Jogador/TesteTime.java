package Solucao_AA3_IOO_Jogador;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteTime {

	private Time time;
	private Jogador jogador;
	
	@BeforeEach
	public void antesDeCadaTeste() {
		time = new Time();
		jogador = new Jogador("Diego", "Marczal");
	}
	
	@Test
	public void deveRegistrarContato() {
		assertTrue(time.adicionaJogador(jogador));
		assertEquals(jogador, time.getJogadores().get(0));
	}
	
	@Test
	public void naoDeveRegistarContatoInvalido() {
		jogador = new Jogador();
		
		assertFalse(time.adicionaJogador(jogador));
		assertEquals(0, time.getQuantidadeDeJogadores());
		assertFalse(jogador.getErros().isEmpty());
	}
	
	@Test
	public void deveRemoverContatoRegistradoPeloIndice() {
		time.adicionaJogador(jogador);
		
		assertEquals(jogador, time.remover(0));
		assertEquals(0, time.getQuantidadeDeJogadores());
	}
	
	@Test
	public void deveAdicionarGolsAUmJogador() {
		time.adicionaJogador(jogador);
		time.adicionaJogador(new Jogador("Neymar", "Junior"));
		
		assertFalse(time.adicionarGol("Jonas"));
		assertTrue(time.adicionarGol("Diego"));
		
		assertEquals(1, jogador.getGols());
	}
	
	@Test
	public void deveRetornarOArtilheiro() {
		assertNull(time.getArtilheiro());
		
		time.adicionaJogador(jogador);
		time.adicionaJogador(new Jogador("Neymar", "Junior"));
		
		assertTrue(time.adicionarGol("Diego"));
		assertEquals(jogador, time.getArtilheiro());
	}

	
}
