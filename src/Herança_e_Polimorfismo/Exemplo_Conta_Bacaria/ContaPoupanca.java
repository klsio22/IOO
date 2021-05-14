package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

public class ContaPoupanca extends Conta {

    private double juros = 0.005;

    public ContaPoupanca(Cliente cliente, int numero) {
        super(cliente, numero);
    }

    public void pagarJuros() {
        depositar(getSaldo() * juros);
    }
}
