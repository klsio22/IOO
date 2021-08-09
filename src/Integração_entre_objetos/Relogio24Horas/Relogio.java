package Integração_entre_objetos.Relogio24Horas;

public class Relogio {
    private Contador horas;
    private Contador minutos;

    public Relogio() {
        horas = new Contador(24);
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
        this.minutos.setValor(minutos);
    }

    public String getHora() {
        return horas.getValorExibido() + ":" +
        minutos.getValorExibido();
    }
}