package AA2_IOO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogoTest {

    private Jogo jogo;

    @BeforeEach
    public void antesDeCadaTeste() {
        jogo = new Jogo();
    }

    @Test
    public void deveTerJogadoresDevidaMenteNomeados() {
        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());
    }

    @Test
    public void deveDeterminarAColocacaoComUmaRodada() {
        jogo.rodada(5, 10, 2);//10 - 5 - 2  > 1 = 10+ > 2 = 1+ > 3 = 0


        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());

    }

    @Test
    public void deveDeterminarAColocacaoComNRodadas() {
        //3 = 1+ 10 + 10 /  2 = 0 + 0 + 1 / 1 = 10 + 1 + 0
        jogo.rodada(10, 5, 20);
        jogo.rodada(20, 1, 3);
        jogo.rodada(20, 50, 30);

        assertEquals(21, jogo.getpontuacao3());
        assertEquals(1, jogo.getpontuacao2());
        assertEquals(11, jogo.getpontuacao1());

        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 2", jogo.getTerceiroColocado());

    }

    @Test
    public void deveCancelarARodadaCasoDoisOuTresJogadoresEscolhamOMesmoNumero() {
        jogo.rodada(12, 45, 22);//considerada
        jogo.rodada(10, 5, 10);//cancelada
        jogo.rodada(15, 15, 15);//cancelada
        jogo.rodada(5, 11, 41);//considerada
        jogo.rodada(21, 43, 23);//considerada

        assertEquals(21, jogo.getpontuacao3());
        assertEquals(12, jogo.getpontuacao2());
        assertEquals(0, jogo.getpontuacao1());

        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 1", jogo.getTerceiroColocado());

    }

    @Test
    public void naoDeveAtribuirPontosCasoSejaFornecidoNumerosForaDoIntervalo() {
        jogo.rodada(45, 33, 65);
        jogo.rodada(5, 22, 41);
        jogo.rodada(-1, 40, 42);

        assertEquals(2, jogo.getpontuacao3());
        assertEquals(30, jogo.getpontuacao2());
        assertEquals(1, jogo.getpontuacao1());

        assertEquals("Jogador 2", jogo.getPrimeiroColocado());
        assertEquals("Jogador 3", jogo.getSegundoColocado());
        assertEquals("Jogador 1", jogo.getTerceiroColocado());
    }

    @Test
    public void deveSerPossivelReiniciarOJogo() {
        // Escreve um método chamado reiniciar na classe Jogo,
        // este não deve ter retorno nem parâmetros. Deve zerar a pontuação
        // de cada jogador e manter a ordem inicial da classificação.

        fail("Implemente o teste e a solução!");
    }

    @Test
    public void deveRetornarAClassifcaoComAPontucaoDeCadaJogador() {
        // Escreve um método, na classe Jogo, chamado getClassificacao,
        // este não deve ter parâmetros e deve retornar a classificação no
        // formato no seguinte formato:
        // Jogador 1 - 10 pontos
        // Jogador 2 - 3 pontos
        // Jogador 3 - 5 pontos

        fail("Implemente o teste e a solução!");
    }



}