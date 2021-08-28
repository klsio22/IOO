package AA4_IOO.sistema_do_pedagio;
//Klésio Antônio do Nascimento
public abstract class Veiculos {

    private int numeroDeEixos;
    private String placa;

    public Veiculos(String placa, int numeroDeEixos) {
        this.placa = placa;
        this.numeroDeEixos = numeroDeEixos;
    }

    public String getPlaca() {
        return placa;
    }

    public int getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public abstract String getTipoDeTarifa();

    public abstract double getTarifa();

    public abstract String getTipo();
}
