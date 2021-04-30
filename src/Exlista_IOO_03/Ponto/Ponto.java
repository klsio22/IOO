package Exlista_IOO_03.Ponto;

public class Ponto {
    private int x, y;

    public Ponto() {
        this(0, 0);
    }

    public Ponto(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("P(%d,%d)", x, y);
    }
}
