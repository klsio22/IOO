package Exlista_IOO_03.Retangulo;

public class Retangulo {
    private int base, altura;

    public Retangulo() {
        this(1,1);
    }

    public Retangulo(int igual) {
        this.altura = igual;
        this.base = igual;
    }

    public Retangulo(int base, int altura) {
        setBase(base);
        setAltura(altura);
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public double getArea() {
        return base * altura;
    }

    public double getPerimetro() {
        return 2 * (base + altura);
    }

    public boolean eQuadrado() {
        return true;
    }

    public String temAreaMaiorQue(int maior) {
        return "Nao tem area maior que 200";
    }

}
