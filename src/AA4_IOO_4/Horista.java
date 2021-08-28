package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

public class Horista extends Funcinario {
    private double salario;

    public Horista(String nome, double salario, double horasDeTrabalho) {
        super(nome, salario);
        this.salario = salario * horasDeTrabalho;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    public String getTipo() {
        return "Horista";
    }


}
