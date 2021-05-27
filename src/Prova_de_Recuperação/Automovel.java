package Prova_de_Recuperação;

public class Automovel extends Veiculo {

	private double tarifa = 23.30;
	
	public Automovel(String placa) {
		super(placa, 2);
	}

	@Override
	public double getTarifa() {
		return tarifa;
	}

	@Override
	public String getTipo() {
		return "Automóvel";
	}
	
	@Override
	public String getTipoDeTarifa() {
		return "Fixa";
	}
}
