package AA2_IOO;

//Klesio Antonio do Nascimento
public class Jogador {
    private String nome;
    private int escore, numeroDaRodada;

    public Jogador(String nome) {
        setNome(nome);
    }

    public void incrementarEscore(int valor) {
        if (valor > 0)
            escore += valor;
    }

    public void setNumeroDaRodada(int numeroDaRodada) {
        this.numeroDaRodada = numeroDaRodada;
    }

    public void setEscore(int escore) {
        this.escore = escore;
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
