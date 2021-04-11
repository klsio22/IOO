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

        /*assertEquals(21, jogo.getpontuacao3());
        assertEquals(1, jogo.getpontuacao2());
        assertEquals(11, jogo.getpontuacao1());
        */
        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 2", jogo.getTerceiroColocado());


    }





}