package Exlista_IOO_03.Retangulo;

public class Retangulo {
    private double base, altura;

    public Retangulo() {
        this(1, 1);
    }

    public Retangulo(double igual) {
        this.altura = igual;
        this.base = igual;
    }

    public Retangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
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
        return base == altura;
    }

    public boolean temAreaMaiorQue(double area) {
        return getArea() > area;
    }

    public boolean temAreaMaiorQue(Retangulo r) {
        return getArea() > r.getArea();
    }

}
