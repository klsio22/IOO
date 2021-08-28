package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

public class Mensalista extends Funcinario {

    public Mensalista(String nome, double salario) {
        super(nome, salario);
    }

    public String getTipo() {
        return "Mensalista";
    }

}
