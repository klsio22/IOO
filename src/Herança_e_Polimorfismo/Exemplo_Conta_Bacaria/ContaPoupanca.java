package Herança_e_Polimorfismo.Exemplo_Conta_Bacaria;

public class ContaPoupanca extends Conta {

    private double juros = 0.005;

    public ContaPoupanca(Cliente cliente, int numero) {
        super(cliente, numero);
    }

    @Override
    public void processar() {
        depositar(getSaldo() * juros);
    }

    @Override
    public String getTipo() {
        return "cp";
    }
}
