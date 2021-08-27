/*package Testes;

import java.util.ArrayList;
public class Teste01 {
    public static void main(String[] args) {
        ArrayList<Funcio> Funcios = new ArrayList<>();
        Funcios.add(new Gerente("Fabiola da Silva", 10000));
        Funcios.add(new Secretario("João Silva", 1000));

        for (Funcio funcio : Funcios) {
            System.out.println("O salário de " + funcio.getNome() + " é R$" + funcio.getSalario());
        }
    }
}

 class Secretario extends Funcio {

    public Secretario(String nome, double salario) {
        super(nome, salario);
    }

    public double getBonificacao() {
        return 1.15;
    }
}



 class Gerente extends Funcio {
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

 */

