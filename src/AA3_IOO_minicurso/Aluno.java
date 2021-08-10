package AA3_IOO_minicurso;
//Klesio Antonio do Nascimento

import java.util.ArrayList;

public class Aluno {
    private String nome;

    private ArrayList<String> erros;

    public Aluno() {
        erros = new ArrayList<>();
        nome = "";
    }

    public Aluno(String nome) {
        this();
        setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getErros() {
        return erros;
    }

    public boolean eValida() {
        erros.clear();

        if (nome.isEmpty())
            erros.add("Nome não pode ser vazio.");

        if(!nome.contains(" "))
            erros.add("Deve ser informado o nome e sobrenome.");

        return erros.isEmpty();

    }

}
