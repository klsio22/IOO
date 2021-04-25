package ExLista_IOO_02.DadosPessoais;
import java.util.Calendar;

public class Pessoa01{

    int dataAtual = Calendar.getInstance().get(Calendar.YEAR);

    private String nome , sobreNome;
    private int anoNascimento;
    private int idadeEmMeses;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getNomeCompleto() {
        return nome + " "+ sobreNome;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getIdade() {
        int idade;
        return idade = dataAtual - getAnoNascimento();
    }

    public int getIdadeEmMeses() {
        return getIdade() * 12 ;
    }

}


