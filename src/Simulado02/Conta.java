package Simulado02;

public class Conta {
    private Cliente cliente;
    private double saldo, limite;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.limite = 500;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double sacar(double valor) {
        if (valor > 0 && valor <= getSaldoComLimite()) {
            saldo -= valor;
            return valor;
        }
        return 0;
    }

    public boolean depositar(double valor) {
        if (valor < 0)
            return false;
        saldo += valor;
        return true;
    }

    public double getSaldoComLimite() {
        return saldo + limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public String getExtrato() {
        String extrato = "";
        extrato += "-------------------------\n";
        extrato += "Cliente: " + cliente.getNome();
        extrato += "CPF: " + cliente.getCpf();
        extrato += "-------------------------\n";
        extrato += "Drescrição | Valor R$\n";
        extrato += "-------------------------\n";
        extrato += "Saldo: " + getSaldo();
        extrato += "Limite: " + getLimite();
        extrato += "Saldo e Limite : " + getSaldoComLimite();

        return extrato;

    }


}
