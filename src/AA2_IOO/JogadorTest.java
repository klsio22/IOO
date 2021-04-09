package AA2_IOO;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogadorTest {

    private Jogador jogador;

    @BeforeEach
    public void antesDeCadaTeste() {
        jogador = new Jogador("Jogador 1");
    }

    @Test
    public void deveInstanciarInformandoONome() {
        assertEquals("Jogador 1", jogador.getNome());
    }

    @Test
    public void deveTerEscoreInicialZero() {
        assertEquals(0, jogador.getEscore());
    }

    @Test
    public void deveIncrementarOEscore() {
        jogador.incrementarEscore(10);
        jogador.incrementarEscore(5);

        assertEquals(15, jogador.getEscore());
    }

    @Test
    public void deveAtribuirONumeroDaRodada() {
        jogador.setNumeroDaRodada(20);
        assertEquals(20, jogador.getNumeroDaRodada());
    }

    @Test
    public void naoDeveAceitarValoresNegativosParaOIncrementoDoEscore() {
        jogador.incrementarEscore(-10);
        assertEquals(0, jogador.getEscore());
    }

    @Test
    public void naoDeveAlterarONomeCasoOArgumentoSejaVazio() {
        jogador.setNome("");

        assertEquals("Jogador 1", jogador.getNome());
    }


}