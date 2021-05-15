package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

import java.util.Scanner;

public class InterfaceTexto {
    private static final String SAIR = "sair";

    private Scanner entrada;
    private String opcao;

    private Banco banco;

    private Conta conta;


    public InterfaceTexto() {
        entrada = new Scanner(System.in);
        banco = new Banco();
    }

    public void renderizar() {
        do {
            limpar();
            menu();
        } while (!opcao.equals(SAIR));
    }

    private void menu() {
        if (conta != null) {
            menuDaConta();
            leiaVerifiqueOpcoesDaConta();
            return;
        }

        menuPrincipal();
        leiaVerifiqueOpcoesMenuPrincipal();
    }

    /*
     **************************************************************
     * Menu Principal
     **************************************************************/
    private void menuPrincipal() {
        String titulo = "Bando de IOO";

        sln("########################################");
        sln("#" + centralizarTitulo(titulo) + "#");
        sln("########################################");
        sln("#               Menu                   #");
        sln("########################################");
        sln("# 1 - Adicionar Conta Corrente         #");
        sln("# 2 - Adicionar Conta Poupança         #");
        sln("# 3 - Listar Contas Corrente           #");
        sln("# 4 - Listar Contas Poupança           #");
        sln("# 5 - Processar contas                 #");
        sln("# 6 - Acessar conta                    #");
        sln("#                                      #");
        sln("# Digite sair para encerrar            #");
        sln("########################################");
        sln("");
    }

    private void leiaVerifiqueOpcoesMenuPrincipal() {
        opcao = leia("Digite a opção escolhida");
        limpar();
        switch (opcao) {
            case "1":
                registrarContaCorrente();
                break;
            case "2":
                registrarContaPoupanca();
                break;
            case "3":
                mostrarContas();
                   // mostrarContasCorrente();
                break;
            case "4":
                //   mostrarContasPoupanca();
                break;
            case "5":
                processarContas();
                break;
            case "6":
                acessarConta();
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

    private void registrarContaCorrente() {
        String nome = leia("Digite o nome do cliente: ");
        Cliente cliente = new Cliente(nome);

        banco.registrarContaCorrente(cliente);
    }

    private void registrarContaPoupanca() {
        String nome = leia("Digite o nome do cliente: ");
        Cliente cliente = new Cliente(nome);

        banco.registrarContaPoupanca(cliente);
    }

    private void mostrarContas() {
        imprimirCabecalhoDaListagemDeContas("Contas Poupanças");

        for (Conta c : banco.getContas()) {
            sf("| %-6d | %-5s | %-21s |\n", c.getNumero(), c.getSaldo(), c.getCliente().getNome());
            sln("-----------------------------------------");
        }
    }


	/*
	private void mostrarContasCorrente() {
		imprimirCabecalhoDaListagemDeContas("Contas Corrente");

		for (ContaCorrente cc : banco.getContasCorrente()) {
			sf("| %-6d | %-5s | %-21s |\n", cc.getNumero(), cc.getSaldo(), cc.getCliente().getNome());
			sln("-----------------------------------------");
		}
	}

	private void mostrarContasPoupanca() {
		imprimirCabecalhoDaListagemDeContas("Contas Poupanças");

		for (ContaPoupanca cp : banco.getContasPoupanca()) {
			sf("| %-6d | %-5s | %-21s |\n", cp.getNumero(), cp.getSaldo(), cp.getCliente().getNome());
			sln("-----------------------------------------");
		}
	}*/

    private void imprimirCabecalhoDaListagemDeContas(String titulo) {
        sln("------------------------------------------");
        sln("| " + centralizarTitulo(titulo) + " |");
        sln("------------------------------------------");
        sln("| numero | saldo | cliente               |");
        sln("------------------------------------------");
    }

    private void processarContas() {
        banco.processarContas();
        sln("Processamento realizado com sucesso! Consulte listagem para verificar a atualização dos saldos");
    }

    private void acessarConta() {
        String numeroDaConta = leia("Digite o numero da conta: ");

        int numero = Integer.parseInt(numeroDaConta);

        conta = banco.getConta(numero);

    }

    /*
     **************************************************************
     * Menu da Conta
     **************************************************************/

    private void menuDaConta() {
        String titulo = "Conta CC: " + conta.getNumero();

        sln("########################################");
        sln("#" + centralizarTitulo(titulo) + "#");
        sln("########################################");
        sln("#               Menu                   #");
        sln("########################################");
        sln("# 1 - Depositar                        #");
        sln("# 2 - Sacar                            #");
        sln("# 3 - Consultar saldo                  #");
        sln("#                                      #");
        sln("# Digite sair para voltar              #");
        sln("########################################");
        sln("");
    }


    private void leiaVerifiqueOpcoesDaConta() {
        opcao = leia("Digite a opção escolhida");
        limpar();
        switch (opcao) {
            case "1":
                depositar();
                break;
            case "2":
                sacar();
                break;
            case "3":
                consultarSaldo();
                break;
            case SAIR:
                sln("Tchau!");
                opcao = "";
                conta = null;
                return;
            default:
                sln("Opção inválida!!");
        }
        pause();
    }

    /*
     * Métodos referente as opções do menu da conta
     **************************************************************/

    private void depositar() {
        double valor = leiaDouble("Digite o valor do depósito: ");
        conta.depositar(valor);

        sln("Depositor realizado com sucesso!");
    }

    private void sacar() {
        double valor = leiaDouble("Digite o valor do saque: ");
        conta.sacar(valor);
        sln("Saque realizado com sucesso!");
    }

    private void consultarSaldo() {
        sln("O saldo da conta é: " + conta.getSaldo());
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

    private double leiaDouble(String s) {
        String linha = leia(s);
        return Double.parseDouble(linha);
    }

    private void limpar() {
        s("\033[H\033[2J");
        System.out.flush();  // Limpa terminal do Linux
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