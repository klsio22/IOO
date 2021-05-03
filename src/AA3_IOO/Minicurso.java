package AA3_IOO;
//Klesio Antonio do Nascimento

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
		
		matriculados.add(aluno);
		Flash.mensagem("Aluno matriculado com sucesso!");
		
		return true;
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
		Flash.mensagem("Não existe um aluno com o nome '" + nome + "'");
		
		return null;
	}
}
