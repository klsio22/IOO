package AA2_IOO_2;

public class Carro {
    private double kmPorLitro, precoDoCombustivel;

    public Carro(double kmPorLitro, double precoDoCombustivel) {
        setKmPorLitro(kmPorLitro);
        setPrecoDoCombustivel(precoDoCombustivel);
    }

    private void setKmPorLitro(double kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }

    private void setPrecoDoCombustivel(double precoDoCombustivel) {
        this.precoDoCombustivel = precoDoCombustivel;
    }

    public double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public double getKmPorLitro() {
        return kmPorLitro;
    }

    public double getCustoDoKm(){
        return getPrecoDoCombustivel()/getKmPorLitro();
    }



}
