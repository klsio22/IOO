package AA2_IOO_2;
//Klesio Antonio do Nascimento

public class Rodovia {

    private double distancia, distanciaEntrePedagios, precoDeCadaPedagio;

    public Rodovia(double distancia, double distanciaEntrePedagios,
                   double precoDeCadaPedagio) {

        setDistancia(distancia);
        setDistanciaEntrePedagios(distanciaEntrePedagios);
        setPrecoDeCadaPedagio(precoDeCadaPedagio);
    }

    private void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    private void setDistanciaEntrePedagios(double distanciaEntrePedagios) {
        this.distanciaEntrePedagios = distanciaEntrePedagios;
    }

    private void setPrecoDeCadaPedagio(double precoDeCadaPedagio) {
        this.precoDeCadaPedagio = precoDeCadaPedagio;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getDistanciaEntrePedagios() {
        return distanciaEntrePedagios;
    }

    public double getPrecoDeCadaPedagio() {
        return precoDeCadaPedagio;
    }


    public double getCustoDaViagemRodovia() {
        return (getDistancia() / distanciaEntrePedagios) * precoDeCadaPedagio;
    }


}
