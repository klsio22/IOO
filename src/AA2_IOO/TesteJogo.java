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
        jogo.rodada(5, 10, 2);

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
        jogo.rodada(20, 10, 35);//1 = 10


        assertEquals(0, jogo.getpontuacao3());
        assertEquals(30, jogo.getpontuacao2());
        assertEquals(10, jogo.getpontuacao1());

        assertEquals("Jogador 2", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());
    }

    @Test
    public void deveSerPossivelReiniciarOJogo() {
        // Escreve um m??todo chamado reiniciar na classe Jogo,
        // este n??o deve ter retorno nem par??metros. Deve zerar a pontua????o
        // de cada jogador e manter a ordem inicial da classifica????o.

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
        // Escreve um m??todo, na classe Jogo, chamado getClassificacao,
        // este n??o deve ter par??metros e deve retornar a classifica????o no
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


    @Test
    public void deveRetornarTodasAsPosibilidadesDeClassificacao() {
        // 3 2 1 - 1 2 3 - 2 3 1 - 3 1 2 - 1 3 2 - 2 1 3

        //3 2 1
        jogo.rodada(29, 38, 34);//3=10
        jogo.rodada(5, 42, 40);//3=10
        jogo.rodada(4, 8, 26);//2=10

        assertEquals(20, jogo.getpontuacao3());
        assertEquals(10, jogo.getpontuacao2());
        assertEquals(0, jogo.getpontuacao1());

        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 1", jogo.getTerceiroColocado());


        jogo.reiniciar();
        /// 1 2 3
        jogo.rodada(5, 10, 2);//1 = 10
        jogo.rodada(15, 30, 12);//1 = 10
        jogo.rodada(19, 21, 15);//1 = 10
        jogo.rodada(9, 8, 7);//2 = 10

        assertEquals(30, jogo.getpontuacao1());
        assertEquals(10, jogo.getpontuacao2());
        assertEquals(0, jogo.getpontuacao3());

        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 2", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());

        jogo.reiniciar();
        //2 3 1
        jogo.rodada(10, 20, 22);//2=10
        jogo.rodada(23, 22, 21);//2=10
        jogo.rodada(9, 16, 26);//2=10
        jogo.rodada(10, 18, 34);//2=10
        jogo.rodada(33, 4, 21);//3=10

        assertEquals(40, jogo.getpontuacao2());
        assertEquals(10, jogo.getpontuacao3());
        assertEquals(0, jogo.getpontuacao1());

        assertEquals("Jogador 2", jogo.getPrimeiroColocado());
        assertEquals("Jogador 3", jogo.getSegundoColocado());
        assertEquals("Jogador 1", jogo.getTerceiroColocado());

        jogo.reiniciar();
        //3 1 2
        jogo.rodada(25, 10, 20);//3=10
        jogo.rodada(23, 2, 21);//3=10
        jogo.rodada(9, 6, 26);//1=10
        jogo.rodada(10, 8, 34);//1=10
        jogo.rodada(33, 4, 21);//3=10

        assertEquals(30, jogo.getpontuacao3());
        assertEquals(20, jogo.getpontuacao1());
        assertEquals(0, jogo.getpontuacao2());

        assertEquals("Jogador 3", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 2", jogo.getTerceiroColocado());


        jogo.reiniciar();
        //1 3 2
        jogo.rodada(25, 10, 34);//1=10
        jogo.rodada(23, 22, 50);//1=10
        jogo.rodada(4, 26, 8);//3=10

        assertEquals(20, jogo.getpontuacao1());
        assertEquals(10, jogo.getpontuacao3());
        assertEquals(0, jogo.getpontuacao2());

        assertEquals("Jogador 1", jogo.getPrimeiroColocado());
        assertEquals("Jogador 3", jogo.getSegundoColocado());
        assertEquals("Jogador 2", jogo.getTerceiroColocado());

        jogo.reiniciar();

        //2 1 3
        jogo.rodada(35, 24, 20);//2=10
        jogo.rodada(23, 22, 21);//2=10
        jogo.rodada(8, 6, 26);//1=10
        jogo.rodada(15, 8, 34);//1=10
        jogo.rodada(33, 26, 21);//2=10
        jogo.rodada(33, 4, 21);//3=10

        assertEquals(30, jogo.getpontuacao2());
        assertEquals(20, jogo.getpontuacao1());
        assertEquals(10, jogo.getpontuacao3());

        assertEquals("Jogador 2", jogo.getPrimeiroColocado());
        assertEquals("Jogador 1", jogo.getSegundoColocado());
        assertEquals("Jogador 3", jogo.getTerceiroColocado());

    }

}