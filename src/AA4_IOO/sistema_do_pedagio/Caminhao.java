package AA4_IOO.sistema_do_pedagio;

public class Caminhao {

	private int numeroDeEixos;
	private String placa;
	private double tarifaPorEixo = 19.50;
	
	public Caminhao(String placa, int numeroDeEixos) {
		this.placa = placa;
		this.numeroDeEixos = numeroDeEixos;
	}

	public String getPlaca() {
		return placa;
	}
	
	public int getNumeroDeEixos() {
		return numeroDeEixos;
	}
	
	public double getTarifa() {
		return numeroDeEixos * tarifaPorEixo;
	}
	
	public String getTipo() {
		return "Caminhão";
	}

	public String getTipoDeTarifa() {
		return "Por eixo";
	}
}
