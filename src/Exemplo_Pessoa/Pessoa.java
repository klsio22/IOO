package Exemplo_Pessoa;

public class Pessoa {
    private String nome;
    private String sobrenome;

    public Pessoa() {
        // nome="";
        // sobrenome="";
        this("", "");
    }

    public Pessoa(String nome, String sobrenome) {
        setNome(nome);
        setSobrenome(sobrenome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

}
