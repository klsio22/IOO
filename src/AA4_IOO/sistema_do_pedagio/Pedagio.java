package AA4_IOO.sistema_do_pedagio;
//Klésio Antônio do Nascimento

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedagio {
    private ArrayList<Veiculos> veiculos;

    public Pedagio() {
        veiculos = new ArrayList<>();
    }

    public void registrarPassagemVeiculo(Veiculos veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculos> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public double getTotalArrecadado() {

        double total = 0;
        for (Veiculos veiculo : veiculos) {
            total += veiculo.getTarifa();
        }
        return total;
    }


}
