package Exlista_IOO_03.Bilhetadora;

public class Bilhetadora {
    private double preco;
    private double valor;
    private double totalArrecadado;

    public Bilhetadora(double preco) {
        setPreco(preco);
    }

    public void setPreco(double preco) {
        if (preco > 0)
            this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public double restituirSaldo() {
        double devolucao = this.valor;
        this.valor -= this.valor;
        return devolucao;
    }


    public void inserir(double valor) {
        if (valor > 0)
            this.valor += valor;
    }

    public String getBilhete() {
        String bilhete;

        if (getSaldo() != 0) {
            this.valor -= preco;
            totalArrecadado += preco;
            bilhete = "##################";
            bilhete += "# The BlueJ Line";
            bilhete += "# Ticket";
            bilhete += "# " + getPreco() + " cents.";
            bilhete += "##################";
            return bilhete;
        }

        return "";
    }

    public double getSaldo() {
        return valor;
    }

    public double getTotalArrecadado() {
        return totalArrecadado;
    }
}
