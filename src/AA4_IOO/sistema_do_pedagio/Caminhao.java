package AA4_IOO.sistema_do_pedagio;
//Klésio Antônio do Nascimento

public class Caminhao extends Veiculos {

    private double tarifaPorEixo = 19.50;

    public Caminhao(String placa, int numeroDeEixos) {
        super(placa, numeroDeEixos);
    }

    public double getTarifa() {
        return getNumeroDeEixos() * tarifaPorEixo;
    }

    public String getTipoDeTarifa() {
        return "Por eixo";
    }

    public String getTipo() {
        return "Caminhão";
    }

}
