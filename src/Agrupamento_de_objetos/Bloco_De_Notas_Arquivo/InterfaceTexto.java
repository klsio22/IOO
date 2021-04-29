package Agrupamento_de_objetos.Bloco_De_Notas_Arquivo;

import java.util.Scanner;
import java.util.ArrayList;

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
        } while(!opcao.equals(SAIR));
    }

    private void leiaVerifique() {
        opcao = leia("Digite a opção escolhida");
        limpar();
        switch(opcao) {
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
        bloco.adicionaNota(nota);
    }

    private void listar() {
       mostrarNotas(bloco.getNotas());
    }

    private void remover() {
        if (bloco.getQuantidadeDeNotas() == 0) {
            sln("Não existem notas cadastradas!");
            return;
        }

        listarNotasParaRemocao();

        sln();
        String indiceS = leia("Digite o índice da nota que deseja remover");
        try {
            int indice = Integer.parseInt(indiceS);

            Nota notaRemovida = bloco.remover(indice);

            if (notaRemovida != null) {
                sln("A nota '" + notaRemovida.getTitulo() + "' foi removida com sucesso!");
            } else {
                sln("Não existe uma nota com o índice " + indice);
            }
        } catch (NumberFormatException e) {
            sln(indiceS + " não é um número!");
        }
    }

    private void listarNotasParaRemocao() {
        sln("-----------------------------------------");
        sln("| Índice | Título da Nota               |");
        sln("-----------------------------------------");

        ArrayList<Nota> notas = bloco.getNotas();

        for(int i = 0; i < notas.size(); i++) {
            Nota nota = notas.get(i);

            System.out.printf("  %4d   | %s", i, nota.getTitulo() + "\n");
            sln("-----------------------------------------");
        }
    }

    private void pesquisar() {
        String palavraChave = leia("Digite o termo de busca");
        ArrayList<Nota> notasEncontradas = bloco.pesquisar(palavraChave);

        mostrarNotas(notasEncontradas);
    }
    
    private void mostrarNotas(ArrayList<Nota> notas) {
        sln("-----------------------------------------");
        sln("|        Visualização das Notas         |");
        sln("-----------------------------------------");
        sln(notas.size() + " encontradas(s)");
        sln("-----------------------------------------");

        int i = 0;
        for(Nota nota : notas) {
            sln("Nota: " + ++i);
            sln("Título: \n\t" + nota.getTitulo());
            sln("Texto: \n\t" + nota.getTexto());
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
        s("\f");             // Limpa terminal do Bluej
        //s("\033[H\033[2J");  // Limpa terminal do Linux
        //System.out.flush();  // Limpa terminal linux
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
}