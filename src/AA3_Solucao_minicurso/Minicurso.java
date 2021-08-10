package AA3_Solucao_minicurso;

import java.util.ArrayList;

public class Minicurso {
    private static final int NUMERO_VAGAS_EM_ESPERA = 2;

    private String nome;
    private int numeroDeVagas;

    private ArrayList<Aluno> matriculados;
    private ArrayList<Aluno> listaDeEspera;

    public Minicurso(String nome, int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
        this.nome = nome;

        matriculados  = new ArrayList<>();
        listaDeEspera = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public boolean matricular(Aluno aluno) {
        if (!aluno.eValida()) {
            Flash.mensagem("Existem dados incorretos! Por favor verifique!");
            return false;
        }

        if (estaMatriculado(aluno)) {
            Flash.mensagem("Este aluno já está registrado!");
            return false;
        }

        if (matriculados.size() < numeroDeVagas) {
            matriculados.add(aluno);
            Flash.mensagem("Aluno matriculado com sucesso!");
            return true;
        }

        if (listaDeEspera.size() < NUMERO_VAGAS_EM_ESPERA) {
            listaDeEspera.add(aluno);
            Flash.mensagem("Turma lotada! Aluno adicionado na lista de espera!");
            return true;
        }

        Flash.mensagem("Turma e lista de espera lotadas! Aguarde novas informações");
        return false;
    }

    public ArrayList<Aluno> getMatriculados() {
        return matriculados;
    }

    public int getQuantidadDeMatriculados() {
        return matriculados.size();
    }

    public ArrayList<Aluno> getListaDeEspera() {
        return listaDeEspera;
    }

    public int getQuantidadeEmEspera() {
        return listaDeEspera.size();
    }

    public Aluno removerAlunoMatriculado(String nome) {
        Aluno aluno = encontrarAlunoPeloNome(nome, matriculados);

        if (aluno != null) {
            matriculados.remove(aluno);
            Flash.mensagem("Aluno '" + nome + "' removido com sucesso");

            if (listaDeEspera.size() > 0) {
                matriculados.add(listaDeEspera.remove(0));
            }

            return aluno;
        }

        Flash.mensagem("Não existe um aluno com o nome '" + nome + "'");
        return null;
    }

    private boolean estaMatriculado(Aluno aluno) {
        return (encontrarAlunoPeloNome(aluno.getNome(), matriculados) != null) ||
        (encontrarAlunoPeloNome(aluno.getNome(), listaDeEspera) != null);
    }

    private Aluno encontrarAlunoPeloNome(String nome, ArrayList<Aluno> alunos) {
        for(Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome))
                return aluno;
        }
        return null;
    }   
}