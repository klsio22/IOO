package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

public class Horista extends Funcinarios {
    private double salarioPorHoras;

    public Horista(String nome, double salario , double horasDeTrabalho) {
        super(nome, salario);
        setSalarioPorHoras(salario * horasDeTrabalho);
    }

    public void setSalarioPorHoras(double salarioPorHoras) {
        this.salarioPorHoras = salarioPorHoras;
    }

    @Override
    public double getSalario() {
        return salarioPorHoras;
    }

    public String getTipo() {
        return "Horista";
    }

}
