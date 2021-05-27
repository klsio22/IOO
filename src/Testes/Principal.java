package Testes;

import java.util.Scanner;

 class InterfaceTexto {

    private Scanner entrada;

    public void renderizar() {
        limpar();
        inicio();
    }

    private void inicio() {
        sln("Digite os dados solicitados.");
        sln();

        String email = leia("Digite o email: ");
        String senha = leia("Digite o senha: ");

        sln();
        sln("O email e senha digitados foram: ");
        sln("Email: " + email);
        sln("Senha: " + senha);
    }

    private String leia(String s) {
        sln();
        sln(s);
        s("> ");
        return entrada.nextLine();
    }

    private void limpar() {
        s("\f");
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

public class Principal {

    private Principal() {}

    public static void main(String[] args) {
        InterfaceTexto i = new InterfaceTexto();
        i.renderizar();
    }
}