package EXlista_IOO_04.Relogio_12_Horas;

public class Relogio {
    private Contador horas;
    private Contador minutos;


    public Relogio() {
        horas = new Contador(12);
        minutos = new Contador(60);
    }

    public Relogio(int horas, int minutos) {
        this();
        ajustaHora(horas, minutos);
    }

    public void marcaRitmo() {
        minutos.incrementa();
        if (minutos.getValor() == 0)
            horas.incrementa();
    }

    public void ajustaHora(int horas, int minutos) {
        this.horas.setValor(horas);
        this.horas.setValor(minutos);
    }

    public String getPeriodo() {
        return " am";
    }

    public void trocaPeriodo() {
        String tarde = " pm";
    }

    public String getHoras() {
        return horas.getValorExibido() + ":" + minutos.getValorExibido() + getPeriodo();
    }
}
