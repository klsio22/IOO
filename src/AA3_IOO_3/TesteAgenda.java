package AA3_IOO_3;
//Klesi Antonio do Nascimento

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
    public void existeJogadorComMesmoNomeESobrenome() {
        time.adicionaJogador(jogador);
        assertEquals(jogador, time.getJogadores().get(0));

        String nome = "Diego";
        String sobrenome = "Marczal";

        assertTrue(time.existeJogador(nome, sobrenome));

    }

    @Test
    public void existeJogadorComMesmoNome() {
        time.adicionaJogador(jogador);
        assertEquals(jogador, time.getJogadores().get(0));

        String nome = "Diego";
        assertTrue(time.existeJogador(nome));
    }

    @Test
    public void adicionarGolsDoJogador() {
        time.adicionaJogador(jogador);
        assertEquals(jogador, time.getJogadores().get(0));

        String nome = "Diego";
        assertTrue(time.existeJogador(nome));

        int gols = 2;

        assertTrue(time.golsJogador(nome, gols));
        assertEquals(2, jogador.getGols());

    }




}
