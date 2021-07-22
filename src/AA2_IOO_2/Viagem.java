package AA2_IOO_2;
//Klesio Antonio do Nascimento
public class Viagem {
    private Carro carro;
    private Rodovia rodovia;

    public Viagem(Rodovia rodovia, Carro carro) {
        this.carro = carro;
        this.rodovia = rodovia;
    }

    public double getCusto() {
        return (carro.getCustoDoKm() * rodovia.getDistancia())
                + rodovia.getCustoDaViagemRodovia();
    }


}
