package AA3_IOO_3;

import Agrupamento_de_objetos.Bloco_De_Notas_Desenvolvendo.Nota;

import java.util.List;
import java.util.Scanner;

public class InterfaceTexto {
    private static final String SAIR = "sair";

    private Scanner entrada;
    private String opcao;

    private Time time;

    public InterfaceTexto() {
        entrada = new Scanner(System.in);
        time = new Time();
    }

    public void renderizar() {
        do {
            limpar();
            menu();
            leiaVerifique();
        } while (!opcao.equals(SAIR));
    }

    private void leiaVerifique() {
        opcao = leia("Digite a opção escolhida");
        limpar();
        switch (opcao) {
            case "1":
                adicionar();
                break;
            case "2":
                listar();
                break;
            case "3":
                remover();
                break;
            case "4":
                pesquisar();
                break;
            case "5":
                golsJogador();
            case "6":
                artilheiro();
            case SAIR:
                sln("Tchau!");
                return;
            default:
                sln("Opção inválida!!");
        }
        pause();
    }

    private void artilheiro() {


    }

    private void adicionar() {
        String nome = leia("Digite o nome do jogador: ");
        String sobrenome = leia("Digite sobrenome do jogador: ");

        Jogador jogador = new Jogador(nome, sobrenome);

        if (jogador.eValido()) {
            if (time.existeJogador(nome, sobrenome)) {
                sln("Jogador não adicionado!");
                slnf("Já exixte esse jogador '%s'", jogador.getNomeCompleto());
            } else {
                time.adicionaJogador(jogador);
                sln("Jogador adicionado com sucesso!");

            }
        } else {
            sln();
            sln("Não foi possível adiconar esse jogador, devidos aos seguintes problemas: ");
            for (String erro : jogador.getErros()) {
                sln(erro);
            }
        }


    }

    public void golsJogador() {
        if (time.getQuantidadeDeJogadores() == 0) {
            sln("Não exitem jogadores cadastradas!");
            pause();
            return;
        }

        String nome = leia("Digite o nome do jogador que marcou o gol: ");
        Jogador jogador = new Jogador(nome);

        if (time.existeJogador(nome)) {
            String gols = leia("Digite o numero de gol(s) marcado(s):");
            int numeroGols = Integer.parseInt(gols);

            time.golsJogador(nome,numeroGols);
            jogador.setGols(numeroGols);
            sln("Gols adicionado com sucesso!");
        } else {
            sln("Jogador não adicionado!");
            sf("não existe o jogador '%s' ", nome);
        }

        pause();

    }

    private void listar() {
        listarJogadores(time.getJogadores());
    }

    private void remover() {
        listarJogadoresComIndice();

        sln();
        String indiceS = leia("Digite o índice do jogador que deseja remover");

        int indice = Integer.parseInt(indiceS);

        Jogador jogadorRemovido = time.remover(indice);

        sln("O jogador '" + jogadorRemovido.getNomeCompleto() + "' foi removido com sucesso!");
    }


    private void pesquisar() {
        String palavraChave = leia("Digite o termo de busca");

        listarJogadores(time.pesquisar(palavraChave));
    }

    private void listarJogadoresComIndice() {
        sln("-----------------------------------------");
        sln("| Índice | Nome completo                |");
        sln("-----------------------------------------");

        List<Jogador> jogadores = time.getJogadores();

        for (int i = 0; i < jogadores.size(); i++) {
            Jogador jogador = jogadores.get(i);

            sf("| %-6d | %-28s |%n", i, jogador.getNomeCompleto());
            sln("-----------------------------------------");
        }
    }

    private void listarJogadores(List<Jogador> jogadores) {
        sln("-----------------------------------------");
        sln("      Visualização dos Jogadores         ");
        sln("-----------------------------------------");
        sln(jogadores.size() + " encontrado(s)");
        sln("-----------------------------------------");

        int i = 0;
        for (Jogador jogador : jogadores) {
            sln("Jogador: " + ++i);
            sln("Nome completo: " + jogador.getNomeCompleto());
            sln("Gol(s) marcado(s): " + jogador.getGols());
            sln("-----------------------------------------");
        }
    }

    private void menu() {
        sln("########################################");
        sln("#                 Time                 #");
        sln("########################################");
        sln("#                 Menu                 #");
        sln("########################################");
        sln("# 1 - Adicionar jogador                #");
        sln("# 2 - Listar jogadores                 #");
        sln("# 3 - Remover jogador                  #");
        sln("# 4 - Pesquisar                        #");
        sln("# 5 - Gols Marcados                    #");
        sln("#                                      #");
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
        s("\f");                                 // Limpa terminal do Bluej
        s("\033[H\033[2J");
        System.out.flush();  // Limpa terminal do Linux
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

    private void slnf(String s, String sf) {
        System.out.printf(s, sf);
    }


    private void sf(Object s, Object... args) {
        System.out.printf(s.toString(), args);
    }

    private boolean leiaBoleano(String s) {
        String ss = s + "\n[S]im, [N]ão";
        String entrada = leia(ss).toLowerCase();

        if (entrada.equals("s") || entrada.equals("sim"))
            return true;

        return false;
    }

    /**************************************************************
     * Métodos úteis
     **************************************************************/

    private String centralizar(String s, int espacoDisponivel) {
        int tamanho = s.length();
        int qntDeEspacos = (espacoDisponivel - tamanho) / 2;
        String espacos = " ".repeat(qntDeEspacos);

        s = espacos + s + espacos;

        if ((espacoDisponivel - tamanho) % 2 == 0)
            return s;

        return s + " ";
    }

    private String centralizar(int numero, int espacoDisponivel) {
        return centralizar(numero + "", espacoDisponivel);
    }
}