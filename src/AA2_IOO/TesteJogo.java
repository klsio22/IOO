package AA2_IOO;
//Klesio Antonio do Nascimento
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteJogo {

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
        jogo.rodada(5, 10, 2);//

        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());

    }

    @Test
    public void deveDeterminarAColocacaoComNRodadas() {
        jogo.rodada(10, 5, 20);//1 = 10
        jogo.rodada(20, 1, 3);//3 =10
        jogo.rodada(20, 50, 30);//3=10

        assertEquals(20, jogo.getpontuacao3());
        assertEquals(0, jogo.getpontuacao2());
        assertEquals(10, jogo.getpontuacao1());

        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 2", jogo.getTerceiroColocado());

    }

    @Test
    public void deveCancelarARodadaCasoDoisOuTresJogadoresEscolhamOMesmoNumero() {
        jogo.rodada(12, 45, 22);//considerada 3=10
        jogo.rodada(10, 5, 10);//cancelada
        jogo.rodada(15, 15, 15);//cancelada
        jogo.rodada(5, 11, 41);//considerada 2 = 10
        jogo.rodada(21, 43, 23);//considerada 3 = 10

        assertEquals(20, jogo.getpontuacao3());
        assertEquals(10, jogo.getpontuacao2());
        assertEquals(0, jogo.getpontuacao1());

        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 1", jogo.getTerceiroColocado());

    }

    @Test
    public void naoDeveAtribuirPontosCasoSejaFornecidoNumerosForaDoIntervalo() {
        jogo.rodada(45, 33, 51);//2 = 10
        jogo.rodada(5, 22, 41); //2 = 10
        jogo.rodada(-1, 40, 42);//2 = 10
        jogo.rodada(20,10,35);//1 = 10


        assertEquals(0, jogo.getpontuacao3());
        assertEquals(30, jogo.getpontuacao2());
        assertEquals(10, jogo.getpontuacao1());

        assertEquals("Jogador 2", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());
    }

    @Test
    public void deveSerPossivelReiniciarOJogo() {
        // Escreve um método chamado reiniciar na classe Jogo,
        // este não deve ter retorno nem parâmetros. Deve zerar a pontuação
        // de cada jogador e manter a ordem inicial da classificação.

        jogo.rodada(39, 33, 34);//3=10
        jogo.rodada(5, 22, 50);//2=10
        jogo.rodada(4, 8, 26);//2=10

        assertEquals(10, jogo.getpontuacao3());
        assertEquals(20, jogo.getpontuacao2());
        assertEquals(0, jogo.getpontuacao1());

        assertEquals("Jogador 2", jogo.getPrimeiroColocado());
        assertEquals("Jogador 3", jogo.getSegundoColocado());
        assertEquals("Jogador 1", jogo.getTerceiroColocado());

        jogo.reiniciar();

        assertEquals(0, jogo.getpontuacao3());
        assertEquals(0, jogo.getpontuacao2());
        assertEquals(0, jogo.getpontuacao1());

        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());

    }
    @Test
    public void deveRetornarAClassifcaoComAPontucaoDeCadaJogador() {
        // Escreve um método, na classe Jogo, chamado getClassificacao,
        // este não deve ter parâmetros e deve retornar a classificação no
        // formato no seguinte formato:
        // Jogador 1 - 10 pontos
        // Jogador 2 - 3 pontos
        // Jogador 3 - 5 pontos

        jogo.rodada(20, 5, 32);//1 = 10
        jogo.rodada(22, 45, -1);// 1 = 10
        jogo.rodada(2, 42, 45);// 2 = 10

        jogo.rodada(-5, 49, 62);//0 + 0 + 0

        jogo.rodada(50, 12, 21);//3 = 10
        jogo.rodada(26, 17, 31);// 1 = 10
        jogo.rodada(15, 30, 45);// 2 = 10


        assertEquals(30, jogo.getpontuacao1());
        assertEquals(20, jogo.getpontuacao2());
        assertEquals(10, jogo.getpontuacao3());


        assertEquals(getClassificacao(), jogo.getClassificacao());

        //System.out.println(jogo.getClassificacao());

    }

    public String getClassificacao() {

        String classificacao = "";
        classificacao += "jogador 1 - " + jogo.getpontuacao1() + " pontos\n";
        classificacao += "jogador 2 - " + jogo.getpontuacao2() + " pontos\n";
        classificacao += "jogador 3 - " + jogo.getpontuacao3() + " pontos\n";

        return classificacao;
    }

}