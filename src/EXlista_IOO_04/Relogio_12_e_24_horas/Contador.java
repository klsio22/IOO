package EXlista_IOO_04.Relogio_12_e_24_horas;

public class Contador {
    private int valor;
    private int limite;

    public Contador(int limite) {
        this.limite = limite;
    }

    public void setValor(int valor) {
        if (valor >= 0 && valor < limite)
            this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void incrementa() {
        valor++;
        if (valor == limite)
            valor = 0;

        //valor = (valor + 1) % limite;

    }

    public String getValorExibido() {
        if (valor < 10)
            return "0" + valor;
        return "" + valor;
    }

}
