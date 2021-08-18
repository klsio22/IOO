package AA3_IOO_3;
//Klésio Antônio do Nascimento

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

        String nome = "Diego";
        String sobrenome = "Marczal";

        assertTrue(time.existeJogador(nome, sobrenome));
    }

    @Test
    public void naoExisteJogadorComMesmoNomeESobrenomeDiferente() {
        time.adicionaJogador(jogador);

        String nome = "Diego";
        String sobrenome = "Silva";

        assertFalse(time.existeJogador(nome, sobrenome));
    }

    @Test
    public void existeJogadorComMesmoNome() {
        time.adicionaJogador(jogador);

        assertTrue(time.existeJogador("Diego"));
    }

    @Test
    public void adicionarGolsAUmJogador() {
        time.adicionaJogador(jogador);
        time.adicionaJogador(new Jogador("Neymar", "Junior"));

        assertFalse(time.existeJogador("Pedro"));
        assertTrue(time.existeJogador("Diego"));

        assertTrue(time.golsJogador("Diego", 2));
        assertEquals(2, jogador.getGols());

    }

    @Test
    public void artilheiroDotime(){
        assertEquals("",time.getArtilheiro());

        time.adicionaJogador(jogador);
        time.adicionaJogador(new Jogador("Neymar", "Junior"));

        assertTrue(time.golsJogador("Diego", 2));

        assertEquals("Diego Marczal", time.getArtilheiro());
        assertEquals(2, jogador.getGols());

    }


}
