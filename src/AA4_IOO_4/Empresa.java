package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empresa {
	private ArrayList<Funcinarios> funcionarios;
	
	public Empresa() {
		funcionarios = new ArrayList<>();
	}
	
	public void registraFuncionario(Funcinarios funcionario) {
		funcionarios.add(funcionario);
	}
	
	public List<Funcinarios> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
	}
	
	public double getTotalDeSalariosAPagar() {
		double total = 0;
		for (Funcinarios f : funcionarios) {
			total += f.getSalario();
		}

		return total;
	}
}
