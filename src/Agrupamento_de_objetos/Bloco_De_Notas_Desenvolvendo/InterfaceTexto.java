package Agrupamento_de_objetos.Bloco_De_Notas_Desenvolvendo;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceTexto {
    private static final String SAIR = "sair";
    private Scanner entrada;
    private String opcao;
    private BlocoDeNotas bloco;

    public InterfaceTexto() {
        entrada = new Scanner(System.in);
        bloco = new BlocoDeNotas();
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
            case SAIR:
                sln("Tchau!");
                return;
            default:
                sln("Opção inválida!!");
        }
        pause();
    }

    private void adicionar() {
        String titulo = leia("Digite o título da nota: ");
        String texto = leia("Digite o texto da nota: ");

        Nota nota = new Nota(titulo, texto);

        if (nota.eValido()) {
            if (bloco.encontrarTituloNota(titulo)) {
                sln("Nota não adicionada!");
                slnf("Já exixte uma nota com titulo '%s'", titulo);
            } else {
                bloco.adicionaNota(nota);
                sln("Nota adicionada com sucesso!");
            }
        } else {
            sln();
            sln("Não foi possível adiconar a nota, devidos aos seguintes problemas: ");
            for (String erro : nota.getErros()) {
                sln(erro);
            }
        }

    }

    private void listar() {
        mostrarNotas(bloco.getNotas());
    }

    private void pesquisar() {
        String palavraChave = leia("Digite o termo de busca:");

        ArrayList<Nota> notasEncontradas = bloco.pesquisar(palavraChave);
        mostrarNotas(notasEncontradas);
    }

    private void mostrarNotas(ArrayList<Nota> notas) {
        sln("-----------------------------------------");
        sln("|        Visualização das Notas         |");
        sln("-----------------------------------------");
        sln(notas.size() + " encotradas(s)");
        sln("-----------------------------------------");

        int i = 0;
        for (Nota nota : notas) {
            sln("Nota: " + ++i);
            sln("Título: \n\t" + nota.getTitulo());
            sln("Texto: \n\t" + nota.getTexto());
            sln("-----------------------------------------");
        }

    }

    private void remover() {
        if (bloco.getQuantidadeDeNotas() == 0) {
            sln("Não exitem notas cadastradas!");
            return;
        }

        listarParaRemocao();
        sln();
        String indiceS = leia("Digite o indice da nota que deseja remover");

        try {
            int indice = Integer.parseInt(indiceS);
            Nota notaRemovida = bloco.remover(indice);
            if (notaRemovida != null) {
                slnf("A nota %s foi removida com sucesso!", notaRemovida.getTitulo());
            } else {
                sln("Indice inválido!");
                slnf("Não existe uma nota com o indice %s cadastrada", indiceS);
            }
        } catch (NumberFormatException e) {
            slnf("Indice (%s) não é um número!", indiceS);
        }

    }

    private void listarParaRemocao() {

        sln("-----------------------------------------");
        sln("| Indice | Titulo da Nota         |");
        sln("-----------------------------------------");

        ArrayList<Nota> notas = bloco.getNotas();

        for (int i = 0; i < notas.size(); i++) {
            Nota nota = notas.get(i);

            System.out.printf("  %4d   | %s \n", i, nota.getTitulo());
            sln("-----------------------------------------");
        }

    }

    private void menu() {
        sln("########################################");
        sln("#           Bloco de Notas             #");
        sln("########################################");
        sln("#               Menu                   #");
        sln("########################################");
        sln("# 1 - Adicionar                        #");
        sln("# 2 - Listar                           #");
        sln("# 3 - Remover                          #");
        sln("# 4 - Pesquisar                        #");
        sln("#                                      #");
        sln("# Digite sair para encerrar            #");
        sln("########################################");
        sln("");
    }

    private void pause() {
        sln();
        sln("Pressione a tecla enter para continuar..");
        entrada.nextLine();
    }

    private String leia(String s) {
        sln(s);
        s("> ");
        return entrada.nextLine();
    }

    private void limpar() {
        // s("\f");             // Limpa terminal do Bluej
        //s("\033[H\033[2J");  // Limpa terminal do Linux
        // System.out.flush();  // Limpa terminal linux
    }

    private void sln() {
        System.out.println();
    }

    private void sln(String s) {
        System.out.println(s);
    }

    private void s(String s) {
        System.out.print(s);
    }

    private void slnf(String s, String sf) {
        System.out.printf(s, sf);
    }
}