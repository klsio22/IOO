package Testes;

public class Testes03 {
    public static void main(String[] args) {
        WA w = new ZB();
        System.out.println(w.fbb());
    }

}

abstract class WA {
    protected int a, b;

    public WA() {
        a = b = 10;
    }

    public void faa() {
        if (a < 10) b = 0;
        else a = 0;
    }

    public abstract int fbb();
}

class ZB extends WA {
    public ZB() {
        a += 5;
        b += 5;
    }

    public int fbb() {
        faa();
        return a + b;
    }

    public void faa() {
        try {
            if (a > 10)
                throw new Exception();
        } catch (Exception e) {
            a = b = 0;
        } finally {
            a += 3;
            b += 3;
        }
    }
}