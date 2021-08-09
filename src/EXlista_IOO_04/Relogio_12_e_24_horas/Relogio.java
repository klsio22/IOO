package EXlista_IOO_04.Relogio_12_e_24_horas;

public class Relogio {
    private Contador horas, minutos;
    private String periodo = "am";
    private String adicionaPeriodo = "";

    public Relogio() {
        horas = new Contador(25);
        minutos = new Contador(60);

    }

    public Relogio(int horas, int minutos) {
        this();
        ajustaHora(horas, minutos);
    }

    public void trocaFormato() {
        //8pm + 12 = 20:00
        //8am + 12 = 8:00

        if (horas.getValor() > 12) {
            ajustaHora(horas.getValor() - 12, minutos.getValor());
            adicionaPeriodo();
        } else {
            horas = new Contador(13);
            minutos = new Contador(60);

            ajustaHora(12, 0);

        }

    }

    private String adicionaPeriodo() {
        return adicionaPeriodo = " " + getPeriodo();
    }

    public void marcaRitmo() {
        minutos.incrementa();
        if (minutos.getValor() == 0)
            horas.incrementa();
    }

    public void ajustaHora(int horas, int minutos) {
        if (horas == 11 && minutos == 59)
            adicionaPeriodo = " pm";
            adicionaPeriodo();

        this.horas.setValor(horas);
        this.minutos.setValor(minutos);
    }

    public String getPeriodo() {
        return periodo;
    }

    public String trocaPeriodo() {
        if (periodo.equals("pm")) {
            return periodo = "am";
        }
        return periodo = "pm";
    }

    public String getHoras() {
        return horas.getValorExibido() + ":"
                + minutos.getValorExibido() + adicionaPeriodo;
    }

    public String getFormato() {

        ajustaHora(24, 0);

        return horas.getValorExibido() + " horas";
    }

}
