package AA2_IOO;

public class Jogo {
    private Jogador jogador1, jogador2, jogador3;
    private int numero1 = 0, numero2 = 0, numero3 = 0;

    public Jogo() {
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");
        jogador3 = new Jogador("Jogador 3");
    }

    public void rodada(int numero1, int numero2, int numero3) {

        if (numero3 > numero1 && numero1 > numero2) {
            jogador1.incrementarEscore(10);
            jogador2.incrementarEscore(0);
            jogador3.incrementarEscore(1);
        }


        if (numero1 > numero2 && numero2 > numero3) {
            jogador1.incrementarEscore(1);
            jogador2.incrementarEscore(10);
            jogador3.incrementarEscore(0);
        }

        if (numero2 > numero1 && numero1 > numero3) {
            jogador1.incrementarEscore(10);
            jogador2.incrementarEscore(1);
            jogador3.incrementarEscore(0);
        }

        if (numero1 > numero3 && numero3 > numero2) {
            jogador1.incrementarEscore(1);
            jogador2.incrementarEscore(0);
            jogador3.incrementarEscore(10);
        }

        if (numero2 > numero3 && numero3 > numero1) {
            jogador1.incrementarEscore(0);
            jogador2.incrementarEscore(1);
            jogador3.incrementarEscore(10);
        }

    }

    public String getPrimeiroColocado() {
        if (jogador1.getEscore() == 0)
            return jogador1.getNome();
        else
          return getpontuacaoGeral();
    }

    public String getSegundoColocado() {
        if (jogador1.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador3.getEscore())
            return jogador2.getNome();

        if (jogador2.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador3.getEscore())
            return jogador1.getNome();

        if (jogador3.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador1.getEscore())
            return jogador2.getNome();

        if (jogador3.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador2.getEscore())
            return jogador1.getNome();

        return jogador2.getNome();
    }

    public String getTerceiroColocado() {
        if (jogador1.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador3.getEscore())
            return jogador3.getNome();

        if (jogador2.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador3.getEscore())
            return jogador3.getNome();

        if (jogador3.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador1.getEscore())
            return jogador1.getNome();

        if (jogador3.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador2.getEscore())
            return jogador2.getNome();
        return jogador3.getNome();
    }

    private String getpontuacaoGeral() {
        if (jogador1.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador3.getEscore())
            return jogador1.getNome();

        if (jogador2.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador3.getEscore())
            return jogador2.getNome();

        if (jogador3.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador1.getEscore())
            return jogador3.getNome();

        if (jogador3.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador2.getEscore())
            return jogador3.getNome();
        return "";
    }

    public int getpontuacao1() {
        return jogador1.getEscore();
    }

    public int getpontuacao2() {
        return jogador2.getEscore();
    }

    public int getpontuacao3() {
        return jogador3.getEscore();
    }
}
