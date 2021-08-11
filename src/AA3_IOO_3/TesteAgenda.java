package AA3_IOO_3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
    public void naoDeveRigistarJogadorComMesmoNome() {
        String nome = "Marcos";
        String sobrenome = "Marczal";


    }

    @Test
    public void DeveRigistarNovoJogador() {


    }

}
