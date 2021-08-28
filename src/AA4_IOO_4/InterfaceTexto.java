package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceTexto {
	private static final String SAIR = "sair";

	private Scanner entrada;
	private String opcao;
	private NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	
	private Empresa empresa;
	
	public InterfaceTexto() {
		entrada = new Scanner(System.in);
		empresa = new Empresa();
	}

	public void renderizar() {
		do {
			limpar();
			menu();
		} while(!opcao.equals(SAIR));
	}

	private void menu() {
		menuPrincipal();
		leiaVerifiqueOpcoesMenuPrincipal();
	}

	/*
	 **************************************************************
	 * Menu Principal
	 **************************************************************/
	private void menuPrincipal() {
		String titulo = "Empresa IOO Ltda";

		sln("----------------------------------------");
		sln("|"  +   centralizarTitulo(titulo)  +  "|");
		sln("----------------------------------------");
		sln("|               Menu                   |");
		sln("----------------------------------------");
		sln("| 1 - Registrar funcionário            |");
		sln("| 2 - Listar funcionários              |");
		sln("| 3 - Mostrar total de salários a pagar|");
		sln("|                                      |");        
		sln("| Digite sair para encerrar            |");
		sln("----------------------------------------");
		sln("");
	}

	private void leiaVerifiqueOpcoesMenuPrincipal() {
		opcao = leia("Digite a opção escolhida");
		limpar();
		switch(opcao) {
		case "1":
			registrarFuncionario();
			break;
		case "2":
			listarFuncionarios();
			break;
		case "3":
			mostrarTotalDeSalariosAPagar();
			break;  
		case SAIR:
			sln("Tchau!");
			return;
		default:
			sln("Opção inválida!!");
		}
		pause();
	}

	/*
	 * Métodos referente as opções do menu principal
	 **************************************************************/

	private void registrarFuncionario() {
		sln("------------------------------------------");
		sln("|           Tipos de Veículos            |");
		sln("------------------------------------------");
		sln("| 1 - Mensalista                         |");
		sln("| 2 - Horista                            |");
		sln("|                                        |");
		sln("| Precione enter para cancelar           |");
		sln("------------------------------------------");
		
		String tipo = leia("Digite tipo do funcionário: "); 
		String nome = leia("Digite o nome do funcionário: ");

		switch(tipo) {
			case "1":
				double salario = leiaDouble("Digite o salario do funcionário: ");
				empresa.registraFuncionario(new Mensalista(nome, salario));			
				break;
			case "2":
				double salarioHorista = leiaDouble("Digite o salario do funcionário por hora: ");
				double horasTrabalhadas = leiaDouble("Digite a quantidade de Horas trabalhadas:");
				empresa.registraFuncionario(new Horista(nome, salarioHorista,horasTrabalhadas));
				break;
		}
	}

	private void mostrarTotalDeSalariosAPagar() {
		sln("------------------------------------------");
		sln("|   Valor total dos sálarios a pagar     |");
		sln("------------------------------------------");
		sln(formatador.format(empresa.getTotalDeSalariosAPagar()));
	}

	private void listarFuncionarios() {
		sln("---------------------------------------");
		sln("|  Funcionários da empresa IOO Ltda   |");
		sln("---------------------------------------");
		sln("|  Nome  |    Tipo    |    Salário    |");
		sln("---------------------------------------");

		for (Funcinarios f : empresa.getFuncionarios()) {
			sf("| %-6s | %-10s | %-13s |\n", f.getNome(),
											 f.getTipo(),
											 formatador.format(f.getSalario()));
			sln("---------------------------------------");
		}
	}

	/*
	 ***************************************************************
	 * Métodos úteis
	 **************************************************************/

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

	private int leiaInteiro(String s) {
		String linha = leia(s);
		return Integer.parseInt(linha);
	}
	
	private double leiaDouble(String s) {
		String linha = leia(s);
		return Double.parseDouble(linha);
	}
	
	private void limpar() {
		s("\033[H\033[2J"); System.out.flush();  // Limpa terminal do Linux
		s("\f");                                 // Limpa terminal do Bluej
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