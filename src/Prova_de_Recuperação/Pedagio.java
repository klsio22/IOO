package Prova_de_Recuperação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedagio {
	private ArrayList<Veiculo> veiculos;
	
	public Pedagio() {
		veiculos = new ArrayList<>();
	}
	
	public void registrarPassagemVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}
	
	public List<Veiculo> getVeiculos() {
		return Collections.unmodifiableList(veiculos);
	}
	
	public double getTotalArrecadado() {
		double total = 0;
		for (Veiculo veiculo : veiculos) {
			total += veiculo.getTarifa();
		}
		return total;
	}
}
