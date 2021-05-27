package Prova_de_Recuperação;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceTexto {
    private static final String SAIR = "sair";

    private Scanner entrada;
    private String opcao;
    private NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private Pedagio pedagio;

    public InterfaceTexto() {
        entrada = new Scanner(System.in);
        pedagio = new Pedagio();
    }

    public void renderizar() {
        do {
            limpar();
            menu();
        } while (!opcao.equals(SAIR));
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
        String titulo = "Pedagio de IOO";

        sln("----------------------------------------");
        sln("|" + centralizarTitulo(titulo) + "|");
        sln("----------------------------------------");
        sln("|               Menu                   |");
        sln("----------------------------------------");
        sln("| 1 - Registrar passagem de veículo    |");
        sln("| 2 - Listar veículos que passaram     |");
        sln("| 3 - Mostrar arrecadação total        |");
        sln("|                                      |");
        sln("| Digite sair para encerrar            |");
        sln("----------------------------------------");
        sln("");
    }

    private void leiaVerifiqueOpcoesMenuPrincipal() {
        opcao = leia("Digite a opção escolhida");
        limpar();
        switch (opcao) {
            case "1":
                registrarPassagemDeVeiculo();
                break;
            case "2":
                listarVeiculos();
                break;
            case "3":
                mostrarArrecadacaoTotal();
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

    private void registrarPassagemDeVeiculo() {
        sln("------------------------------------------");
        sln("|           Tipos de Veículos            |");
        sln("------------------------------------------");
        sln("| 1 - Veículo Passeio                    |");
        sln("| 2 - Caminhao                           |");
        sln("|                                        |");
        sln("| Precione enter para cancelar           |");
        sln("------------------------------------------");

        String tipoDoVeiculo = leia("Digite o tipo de veículo: ");
        String placa = leia("Digite a placa do veículo: ");

        switch (tipoDoVeiculo) {
            case "1":
                pedagio.registrarPassagemVeiculo(new Automovel(placa));
                break;
            case "2":
                int numeroDeEixos = leiaInteiro("Digite o numero de eixos: ");
                pedagio.registrarPassagemVeiculo(new Caminhao(placa, numeroDeEixos));
                break;
        }


    }

    private void mostrarArrecadacaoTotal() {
        sln("------------------------------------------");
        sln("|      Total arrecadodo pelo pedágio     |");
        sln("------------------------------------------");
        sln(formatador.format(pedagio.getTotalArrecadado()));
    }

    private void listarVeiculos() {


        sln("---------------------------------------------------------------------");
        sln("|               Veículos que passaram pelo pedágio                  |");
        sln("---------------------------------------------------------------------");
        sln("| Placa  |    Tipo    | Nº de eixos | Tipo de Tarifa | Tarifa Total |" +
                " Data e horas |");
        sln("---------------------------------------------------------------------");

        for (Veiculo v : pedagio.getVeiculos()) {
            sf("| %-6s | %-10s | %-11d | %-14s | %-12s | %-12s |\n",
                    v.getPlaca(),
                    v.getTipo(), v.getNumeroDeEixos(),
                    v.getTipoDeTarifa(),
                    formatador.format(v.getTarifa()),
                    v.getDataHora());

            sln("---------------------------------------------------------------------");
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