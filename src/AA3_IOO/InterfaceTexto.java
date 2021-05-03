package AA3_IOO;
//Klesio Antonio do Nascimento

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceTexto {
	private static final String SAIR = "sair";

	private Scanner entrada;
	private String opcao;

	private Minicurso minicurso;

	public InterfaceTexto() {
		entrada = new Scanner(System.in);
		minicurso = new Minicurso("Node.js", 3);
	}

	public void renderizar() {
		do {
			limpar();
			menu();
			leiaVerifique();
		} while(!opcao.equals(SAIR));
	}

	private void leiaVerifique() {
		opcao = leia("Digite a opção escolhida");
		limpar();
		switch(opcao) {
		case "1":
			matricular();
			break;
		case "2":
			mostrarMatriculados();
			break;
		case "3":
			mostrarListaDeEspera();
			break;
		case "4":
			removerAlunoMatriculado();
			break;
		case SAIR:
			sln("Tchau!");
			return;
		default:
			sln("Opção inválida!!");
		}
		pause();
	}
	
	/**************************************************************
	 * Métodos referente as opções do menu
	 **************************************************************/
	
	private void matricular() {
		String nome = leia("Digite o nome do aluno: ");
		Aluno aluno = new Aluno(nome);

		boolean adicionado = minicurso.matricular(aluno);
		imprimirMensagensFlash();

		if (!adicionado) {
			sln("Aluno não adicionado, os seguintes erros foram encontrados: ");
			int i = 1;
			for(String erro : aluno.getErros()) {
				sln("\t" + i++ + ": " + erro);
			}
		}
	}

	private void mostrarMatriculados() {
		String titulo = "Matriculados";
		mostrarAlunos(minicurso.getMatriculados(), titulo);	
	}

	private void mostrarListaDeEspera() {
		String titulo = "Lista de Espera";
		mostrarAlunos(minicurso.getListaDeEspera(), titulo);
	}

	private void removerAlunoMatriculado() {
		String nome = leia("Digite o nome do aluno que deseja remover");
		minicurso.removerAlunoMatriculado(nome);

		imprimirMensagensFlash();
	}

	/**************************************************************
	 * Métodos úteis
	 **************************************************************/
	
	private void mostrarAlunos(ArrayList<Aluno> alunos, String titulo) {
		sln("------------------------------------------");
		sln("| "   + centralizarTitulo(titulo) +    " |");
		sln("------------------------------------------");
		sln("| indice | Aluno                         |");
		sln("------------------------------------------");

		for(int i = 0; i < alunos.size(); i++) {
			Aluno aluno = alunos.get(i);

			sf("| %-6d | %-29s |\n", i, aluno.getNome());
			sln("-----------------------------------------");
		}			
	}
	
	private void imprimirMensagensFlash() {
		sln();
		for (String mensagem : Flash.getMensagens()) {
			int tamanho = mensagem.length();
			String linha = "-".repeat(tamanho + 4);
			
			sln(linha);
			sln("| " + mensagem + " |");
			sln(linha);
		}
	}

	private String centralizarTitulo(String titulo) {
		int tamanho = titulo.length();
		int qntDeEspacos = (38 - tamanho) / 2;
		String espacos = " ".repeat(qntDeEspacos); 

		titulo = espacos + titulo + espacos;

		if (tamanho % 2 == 0)
			return titulo;

		return titulo + " ";
	}
	
	/**************************************************************
	 * Menu
	 **************************************************************/
	
	private void menu() {
		String titulo = "Minicurso de " + minicurso.getNome();
		
		sln("########################################");
		sln("#"  +   centralizarTitulo(titulo)  +  "#");
		sln("########################################");
		sln("#               Menu                   #");
		sln("########################################");
		sln("# 1 - Matricular alunos                #");
		sln("# 2 - Listar alunos matriculados       #");
		sln("# 3 - Listar alunos em lista de espera #");
		sln("# 4 - Remover aluno matriculados       #");
		sln("#                                      #");        
		sln("# Digite sair para encerrar            #");
		sln("########################################");
		sln("");
	}

	/**************************************************************
	 * Métodos para entrada e saída de dados
	 **************************************************************/
	
	private void pause() {
		sln();
		sln("Pressione a tecla enter para continuar..");
		entrada.nextLine();
	}

	private String leia(String s) {
		sln(s);
		s("> ");
		return entrada.nextLine().trim();
	}

	private void limpar() {
		s("\f");              					 // Limpa terminal do Bluej
		s("\033[H\033[2J"); System.out.flush();  // Limpa terminal do Linux
	}

	private void sln() {
		System.out.println();
	}

	private void sln(Object s) {
		System.out.println(s);
	}

	private void s(Object s) {
		System.out.print(s);
	}

	private void sf(Object s, Object... args) {
		System.out.printf(s.toString(), args);
	}
}