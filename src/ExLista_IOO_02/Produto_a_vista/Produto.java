package ExLista_IOO_02.Produto_a_vista;

public class Produto {
    private double preco;
    private double porcentagemDeDesconto;

    public Produto() {
        preco = 0.0;
        porcentagemDeDesconto = 0.0;
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
        double desconto = getPorcentagemDeDesconto()/100;
        return Math.abs((preco*desconto)-preco);
    }

}
