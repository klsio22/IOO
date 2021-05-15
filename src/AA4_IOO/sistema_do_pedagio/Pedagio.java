package AA4_IOO.sistema_do_pedagio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedagio {
    private ArrayList<Caminhao> veiculos;

    public Pedagio() {
        veiculos = new ArrayList<>();
    }

    public void registrarPassagemVeiculo(Caminhao veiculo) {
        veiculos.add(veiculo);
    }

    public List<Caminhao> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public double getTotalArrecadado() {
        double total = 0;
        for (Caminhao veiculo : veiculos) {
            total += veiculo.getTarifa();
        }
        return total;
    }
}
