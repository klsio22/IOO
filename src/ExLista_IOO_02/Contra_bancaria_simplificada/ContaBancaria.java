package ExLista_IOO_02.Contra_bancaria_simplificada;

public class ContaBancaria {
    private double saldo;
    private double sacar;

    public void depositar(double saldo) {
        if (saldo > 0)
            this.saldo += saldo;
    }

    public double sacar(double sacar) {
        if (getSaldo() > 0 && sacar < getSaldo()) {
            this.sacar = sacar;
            return sacar;
        }
        return 0;
    }

    private double getSacar() {
        return sacar;
    }

    public double getSaldo() {
        return saldo -= getSacar();
    }

    public void pagaJuros() {
        saldo += (saldo * 0.05);
    }

}
