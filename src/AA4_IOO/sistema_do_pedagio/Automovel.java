package AA4_IOO.sistema_do_pedagio;
//Klésio Antônio do Nascimento

public class Automovel extends Veiculos {

    private final double tarifaFixa = 23.30;

    public Automovel(String placa, int numeroDeEixos) {
        super(placa, numeroDeEixos);
    }

    public double getTarifa() {
        return tarifaFixa;
    }

    public String getTipo() {
        return "Automóvel";
    }

    public String getTipoDeTarifa() {
        return "Valor fixo";
    }


}
