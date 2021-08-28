package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

public abstract class Funcinario {
    private String nome;
    private double salario;

    public Funcinario(String nome, double salario) {
        setNome(nome);
        setSalario(salario);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public abstract String getTipo();

}
