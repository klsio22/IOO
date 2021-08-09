package EXlista_IOO_04.Relogio_12_Horas;

public class Relogio {
    private Contador horas, minutos;
    private String periodo = "am";

    public Relogio() {
        horas = new Contador(13);
        minutos = new Contador(60);
        ajustaHora(12, 0);
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

        if (horas == 11 && minutos == 59) {
            this.horas.setValor(horas);
            this.minutos.setValor(minutos);
            trocaPeriodo();
        } else {
            this.horas.setValor(horas);
            this.minutos.setValor(minutos);
        }

    }

    public String getPeriodo() {
        return periodo;
    }

    public String trocaPeriodo() {
        if (this.periodo == "pm") {
            return this.periodo = "am";
        }
        return this.periodo = "pm";
    }

    public String getHoras() {
        return horas.getValorExibido() + ":"
                + minutos.getValorExibido() + " " + getPeriodo();
    }
}
