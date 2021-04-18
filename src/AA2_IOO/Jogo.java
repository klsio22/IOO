package AA2_IOO;

//Klesio Antonio do Nascimento
public class Jogo {
    private Jogador jogador1, jogador2, jogador3;
    private int numero1, numero2, numero3;

    public Jogo() {
        jogador1 = new Jogador("Jogador 1");
        jogador2 = new Jogador("Jogador 2");
        jogador3 = new Jogador("Jogador 3");
    }

    public void rodada(int numero1, int numero2, int numero3) {

        if (numero1 < 0 || numero1 > 50)
            numero1 = 0;

        if (numero2 < 0 || numero2 > 50)
            numero2 = 0;

        if (numero3 < 0 || numero3 > 50)
            numero3 = 0;

        if (numero1 != numero2 && numero2 != numero3 && numero1 != numero3) {

            if (numero3 > numero1 && numero1 > numero2) {
                jogador1.incrementarEscore(10);
            }

            if (numero1 > numero2 && numero2 > numero3) {
                jogador2.incrementarEscore(10);
            }

            if (numero2 > numero1 && numero1 > numero3) {
                jogador1.incrementarEscore(10);
            }

            if (numero1 > numero3 && numero3 > numero2) {
                jogador3.incrementarEscore(10);
            }

            if (numero2 > numero3 && numero3 > numero1) {
                jogador3.incrementarEscore(10);
            }

            if (numero3 > numero2 && numero2 > numero1) {
                jogador2.incrementarEscore(10);
            }

        }
    }

    public String getPrimeiroColocado() {
        if (jogador2.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador3.getEscore())
            return jogador2.getNome();

        if (jogador3.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador1.getEscore())
            return jogador3.getNome();

        if (jogador3.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador2.getEscore())
            return jogador3.getNome();

        if (jogador2.getEscore() > jogador3.getEscore()
                && jogador3.getEscore() > jogador1.getEscore())
            return jogador2.getNome();

        return jogador1.getNome();
    }

    public String getSegundoColocado() {
        if (jogador1.getEscore() > jogador3.getEscore()
                && jogador3.getEscore() > jogador2.getEscore())
            return jogador3.getNome();

        if (jogador2.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador3.getEscore())
            return jogador1.getNome();

        if (jogador3.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador2.getEscore())
            return jogador1.getNome();

        if (jogador2.getEscore() > jogador3.getEscore()
                && jogador3.getEscore() > jogador1.getEscore())
            return jogador3.getNome();

        return jogador2.getNome();
    }

    public String getTerceiroColocado() {
        if (jogador1.getEscore() > jogador3.getEscore()
                && jogador3.getEscore() > jogador2.getEscore())
            return jogador2.getNome();

        if (jogador3.getEscore() > jogador2.getEscore()
                && jogador2.getEscore() > jogador1.getEscore())
            return jogador1.getNome();

        if (jogador3.getEscore() > jogador1.getEscore()
                && jogador1.getEscore() > jogador2.getEscore())
            return jogador2.getNome();

        if (jogador2.getEscore() > jogador3.getEscore()
                && jogador3.getEscore() > jogador1.getEscore())
            return jogador1.getNome();

        return jogador3.getNome();
    }

    public void reiniciar() {
        jogador1.setEscore(0);
        jogador2.setEscore(0);
        jogador3.setEscore(0);
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

    public String getClassificacao() {

        String classificacao = "";
        classificacao += "jogador 1 - " + getpontuacao1() + " pontos\n";
        classificacao += "jogador 2 - " + getpontuacao2() + " pontos\n";
        classificacao += "jogador 3 - " + getpontuacao3() + " pontos\n";

        return classificacao;
    }
}
