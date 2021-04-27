package ExLista_IOO_02.DadosPessoais;
import java.util.Calendar;

public class Pessoa {
    private String nome, sobrenome;
    private int anoDeNascimento;

    public Pessoa() {
        nome = "";
        sobrenome = "";
        anoDeNascimento = 0;
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome.trim();
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public int getIdade() {
        //int dataAtual = Calendar.getInstance().get(Calendar.YEAR);
        int idade;
        return idade = getAnoAtual() - getAnoDeNascimento();
    }

    public int getIdadeEmMeses() {
        return getIdade() * 12;
    }

    private int getAnoAtual() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

}


