package AA2_IOO;

public class main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Jogador jogador1 = new Jogador("Jogador 1");

        jogo.rodada(5,10,3);
        jogador1.incrementarEscore(10);

        System.out.printf("%s recode %d ", jogador1.getNome(), jogador1.getEscore());


    }
}
