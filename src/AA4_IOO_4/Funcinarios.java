package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

public abstract class Funcinarios {
    private String nome;
    private double salario;

    public Funcinarios(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public  String getNome() {
        return nome;
    }

    public  double getSalario(){
        return salario;
    }

    public abstract String getTipo();

}
