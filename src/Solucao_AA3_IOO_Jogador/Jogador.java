package Solucao_AA3_IOO_Jogador;

import java.util.ArrayList;

public class Jogador {
	private String nome;
	private String sobrenome;
	private int gols;
	
	private ArrayList<String> erros;

	public Jogador() {
		this("", "");
	}

	public Jogador(String nome, String sobrenome) {
		erros = new ArrayList<>();

		setNome(nome);
		setSobrenome(sobrenome);
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
	
	public void incrementarGols() {
		gols++;
	}
	
	public int getGols() {
		return gols;
	}

	public ArrayList<String> getErros() {
		return erros;
	}

	public boolean eValido() {
		erros.clear();

		if (nome.isEmpty())
			erros.add("Nome não pode ser vazio.");

		if (sobrenome.isEmpty())
			erros.add("Sobrenome não pode ser vazio.");

		return erros.isEmpty();
	}
}
