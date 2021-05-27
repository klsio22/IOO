package Prova_de_Recuperação;

public class Caminhao extends Veiculo {

	private double tarifaPorEixo = 19.50;
	
	public Caminhao(String placa, int numeroDeEixos) {
		super(placa, numeroDeEixos);
	}
	
	@Override
	public double getTarifa() {
		return getNumeroDeEixos() * tarifaPorEixo;
	}
	
	@Override
	public String getTipo() {
		return "Caminhão";
	}

	@Override
	public String getTipoDeTarifa() {
		return "Por eixo";
	}
}
