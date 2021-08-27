package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {
    private static int numeroSequencial = 1;

    private ArrayList<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();

    }

    public void registrarContaCorrente(Cliente cliente) {
        contas.add(new ContaCorrente(cliente, numeroSequencial++));
    }

    public void registrarContaPoupanca(Cliente cliente) {
        contas.add(new ContaPoupanca(cliente, numeroSequencial++));
    }

    public void processarContas() {
        for (Conta conta : contas) {
            conta.processar();
        }

    }

    public List<Conta> getContas() {
        return Collections.unmodifiableList(contas);
    }

    /*public List<ContaCorrente> getContasCorrente() {
        return Collections.unmodifiableList(contasCorrente);
    }

    public List<ContaPoupanca> getContasPoupanca() {
        return Collections.unmodifiableList(contasPoupanca);
    }*/

    public Conta getConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero)
                return conta;
        }
        return null;
    }

/*
    public ContaCorrente getContaCorrente(int numero) {
        for (ContaCorrente contaCorrente : contasCorrente) {
            if (contaCorrente.getNumero() == numero)
                return contaCorrente;
        }
        return null;
    }


    public ContaPoupanca getContaPoupanca(int numero) {
        for (ContaPoupanca contaPoupanca : contasPoupanca) {
            if (contaPoupanca.getNumero() == numero)
                return contaPoupanca;
        }
        return null;
    }*/
}
