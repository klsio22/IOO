package ExLista_IOO_02.Produto_a_Prazo;

public class Produto {
    private double preco;
    private double porcentagemDeDesconto;
    private int numeroDeParcelas;
    private double taxaDeJurosMensal;

    public double getTaxaDeJurosMensal() {
        return taxaDeJurosMensal;
    }

    public void setTaxaDeJurosMensal(double taxaDeJurosMensal) {
        this.taxaDeJurosMensal = taxaDeJurosMensal;
    }

    public int getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public void setPorcentagemDeDesconto(double porcentagemDeDesconto) {
        this.porcentagemDeDesconto = porcentagemDeDesconto;
    }

    public double getPorcentagemDeDesconto() {

        return (porcentagemDeDesconto);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoAVista() {
        double desconto = getPorcentagemDeDesconto() / 100;
        return Math.abs((preco * desconto) - preco);
    }

    private double getJurosComposto() {
        double juros = getTaxaDeJurosMensal() / 100;
        double denominador = 1 - (Math.pow(1 + juros, -numeroDeParcelas));
        return (preco * juros) / denominador;
    }

    public Double getValorDaPrestacao() {
        return getJurosComposto();
    }

    public double getPrecoTotalComJuros() {
        return getValorDaPrestacao() * numeroDeParcelas;
    }

    public double getTotalDeJurosPago() {
        return getPrecoTotalComJuros() - preco;
    }

}
