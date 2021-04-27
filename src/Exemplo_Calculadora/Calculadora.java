package Exemplo_Calculadora;

import java.util.Locale;

public class Calculadora {
    private String ultimaOperacao;

    public Calculadora() {
        ultimaOperacao="";
        Locale.setDefault(Locale.US);
    }

    public int somar(int a, int b) {
        int resultado = a + b;
        ultimaOperacao = String.format("%d + %d = %d", a, b, resultado);
        return resultado;
    }

    public int somar(int a, int b, int c) {
        int resultado = a + b + c;
        ultimaOperacao = String.format("%d + %d + %d = %d", a, b, c, resultado);
        return resultado;
    }

    public Double somar(Double a, Double b) {
        Double resultado = a + b;
        ultimaOperacao = String.format("%.1f + %.1f = %.1f", a, b, resultado);
        return resultado;
    }

    public String getUltimaOperacao() {
        return ultimaOperacao;
    }

}
