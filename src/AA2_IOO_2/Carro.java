package AA2_IOO_2;
//Klesio Antonio do Nascimento

public class Carro {
    private double kmPorLitro, precoDoCombustivel;

    public Carro(double kmPorLitro, double precoDoCombustivel) {
        setKmPorLitro(kmPorLitro);
        setPrecoDoCombustivel(precoDoCombustivel);
    }

    private void setKmPorLitro(double kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }

    public void setPrecoDoCombustivel(double precoDoCombustivel) {
        if (precoDoCombustivel > 0)
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
