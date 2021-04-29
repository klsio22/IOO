package ExLista_IOO_02.Poupanca;

public class Poupanca {
    private double valorInicial;
    private double aporteMensal;
    private double prazoEmMeses;
    private double taxaJurosMensal;

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setAporteMensal(double aporteMensal) {
        this.aporteMensal = aporteMensal;
    }

    public double getAporteMensal() {
        return aporteMensal;
    }

    public void setPrazoEmMeses(double prazoEmMeses) {
        this.prazoEmMeses = prazoEmMeses;
    }

    public double getPrazoEmMeses() {
        return prazoEmMeses;
    }

    public void setTaxaJurosMensal(double taxaJurosMensal) {
        this.taxaJurosMensal = taxaJurosMensal;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public double getSaldoNoFinalDoPrazo() {
        //Não achei a formula para calcular o saldo no final do prazo.
        double juros = getTaxaJurosMensal() / 100;

        return 0.0;
    }

}
