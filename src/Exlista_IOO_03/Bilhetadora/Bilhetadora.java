package Exlista_IOO_03.Bilhetadora;

public class Bilhetadora {
    private double preco;

    public Bilhetadora(double preco){
        setPreco(preco);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void restituirSaldo(){

    }


    public void inserir(double preco){
    }

    public String getBilhete(){
        return "";
    }

    public double getSaldo(){
        return 0.0;
    }
    public double getTotalArrecadado(){
        return 0.0;
    }

}
