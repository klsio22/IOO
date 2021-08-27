package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

public abstract class Conta {
    private Cliente cliente;
    private int numero;
    private double saldo;

    public Conta(Cliente cliente, int numero) {
        this.cliente = cliente;
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public double sacar(double valor) {
        this.saldo -= valor;
        return valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void processar();

    public abstract String getTipo();

}
