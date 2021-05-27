package Testes;

import java.util.ArrayList;
public class Teste01 {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("Fabiola da Silva", 10000));
        funcionarios.add(new Secretario("João Silva", 1000));

        for (Funcionario funcionario : funcionarios) {
            System.out.println("O salário de " + funcionario.getNome() + " é R$" + funcionario.getSalario());
        }
    }
}

 class Secretario extends Funcionario {

    public Secretario(String nome, double salario) {
        super(nome, salario);
    }

    public double getBonificacao() {
        return 1.15;
    }
}



 class Gerente extends Funcionario {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    public double getBonificacao() {
        return 1.4;
    }
}


 class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return this.salario * getBonificacao();
    }

    public double getBonificacao() {
        return 1.1;
    }
}

