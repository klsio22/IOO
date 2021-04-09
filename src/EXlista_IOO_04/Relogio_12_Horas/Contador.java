package EXlista_IOO_04.Relogio_12_Horas;

public class Contador {
    private int valor;
    private final int limite = 12;

    public Contador(int limite) {
        setValor(limite);
    }

    public int setValor(int valor) {
        if (valor >= 0 && valor < limite)
            this.valor = valor;
        return valor;
    }

    public int getValor() {
        return valor;
    }

    public void incrementa() {
        valor++;
        if (valor == limite)
            valor = 0;

    }

    public String getValorExibido() {
       if (valor < 10)
           return "0"+valor;
        return "" + valor;
    }

}
