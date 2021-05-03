package EXlista_IOO_06.Nota_pesistente;

import java.util.Scanner;

public class InterfaceTexto {

    private Scanner entrada;
    private String opcao;
    
    private Nota nota;

    public InterfaceTexto() {
        nota = new Nota();
        entrada = new Scanner(System.in);
    }

    private void menu() {
        sln("####################");
        sln("#       Menu       #");
        sln("####################");
        sln("# 1 - Visualizar   #");
        sln("# 2 - Alterar      #");
        sln("#                  #");
        sln("####################");
        sln("# sair para sair   #");
        sln("####################");
    }

    public void renderizar() {
        do {
            limpar();
            menu();
            verificaOpcao();
        } while(!opcao.equals("sair"));
    }

    private void verificaOpcao() {
        sln("");
        opcao = leia("Escolha uma das opçoes: ");

        switch (opcao) {
            case "1":
              visualizar();
              break;
            case "2":
              alterar();
              break;
            case "sair":
              sln("Bye");
              return;
            default:
              sln("Opçao invalida");
        }
        
        
        pause();
    }

    private void visualizar() {
        sln(nota.getTexto());
    }
    
    private void alterar() {
        String texto = leia("Digite sua nota: ");
        nota.setTexto(texto);
    }
    
    private void pause() {
       sln("\nPressione enter para continuar");
       entrada.nextLine();
    }

    private String leia(String s) {
        System.out.print(s);
        return entrada.nextLine();
    }

    private void limpar() {
        System.out.print("\f");
    }

    private void sln(String s) {
        System.out.println(s);
    }
}
