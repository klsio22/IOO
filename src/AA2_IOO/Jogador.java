package AA2_IOO;

public class Jogador {
    private String nome;
    private int escore, numeroDaRodada;

    public Jogador(String nome) {
        setNome(nome);
    }

    public void incrementarEscore(int score) {
        if (score > 0)
            this.escore += score;
    }

    public void setNumeroDaRodada(int numeroDaRodada) {
        this.numeroDaRodada = numeroDaRodada;
    }

    public int getEscore() {
        return escore;
    }

    public int getNumeroDaRodada() {
        return numeroDaRodada;
    }

    public void setNome(String nome) {
        nome = nome.trim();
        if (nome.contains(" "))
            this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

}
