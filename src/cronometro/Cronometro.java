package cronometro;

public class Cronometro {
    private double valor ;

    public void incrementa() {
      valor = valor + 1 ;
    }

    public void zerarValor(){
        this.valor = 0.0;
    }

    public double getValor() {
        return valor;
    }

}
