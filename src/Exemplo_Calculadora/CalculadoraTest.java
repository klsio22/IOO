package Exemplo_Calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CalculadoraTest {

    private Calculadora calcular;

    @BeforeEach
    public void antesDecadaTeste() {
        calcular = new Calculadora();
    }


    @Test
    public void deveSomarDoisInteiros() {
        int resultado = calcular.somar(5, 2);
        assertEquals(7, resultado);
        assertEquals("5 + 2 = 7", calcular.getUltimaOperacao());
    }

    @Test
    public void deveSomarTresInteiros() {
        int resultado = calcular.somar(5, 2, 3);
        assertEquals(10, resultado);
        assertEquals("5 + 2 + 3 = 10", calcular.getUltimaOperacao());
    }

    @Test
    public void deveSomarDoisDoubles() {
        Double resultado = calcular.somar(5.5, 2.5);
        assertEquals(8.0, resultado);
        assertEquals("5.5 + 2.5 = 8.0", calcular.getUltimaOperacao());
    }


}