package Exlista_IOO_03.Dados_pessoais;
import java.util.Calendar;

public class Pessoa {
    private String nome = "<Não informado>", sobrenome = "<Não informado>";
    private int anoDeNascimento;

    public Pessoa(String nome, String sobrenome, int anoDeNascimento) {
        setNome(nome);
        setSobrenome(sobrenome);
        setAnoDeNascimento(anoDeNascimento);
    }

    public void setNome(String nome) {
        // String primeiraLetra = nome.substring(0, 1);
        //nome = nome.replace(primeiraLetra, primeiraLetra.toUpperCase());
        nome = nome.trim();
        if (!nome.isEmpty())
            this.nome = (capatalize(nome));
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        // String primeiraLetra = sobrenome.substring(0, 1);
        //sobrenome = sobrenome.replace(primeiraLetra, primeiraLetra.toUpperCase());

        sobrenome = sobrenome.trim();
        if (!sobrenome.isEmpty())
            this.sobrenome = capatalize(sobrenome);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        if (anoDeNascimento <= getAnoAtual())
            this.anoDeNascimento = anoDeNascimento;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public int getIdade() {
        return getAnoAtual() - getAnoDeNascimento();
    }

    public int getIdadeEmMeses() {
        return getIdade() * 12;
    }

    private int getAnoAtual() {
        // Calendar cal = Calendar.getInstance();
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private String capatalize(String letra) {
        letra = letra.trim();
        return letra.substring(0, 1).toUpperCase() + letra.substring(1);
        //return letra.substring(0, 1).toUpperCase() + letra.substring(1, letra.length()).toLowerCase();
    }


}
