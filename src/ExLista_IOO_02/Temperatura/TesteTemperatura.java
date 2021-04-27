package ExLista_IOO_02.Temperatura;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteTemperatura {

    private static final double DELTA = 0.001;
    private Temperatura temperatura;

    @BeforeEach
    public void antesDeCadaTeste() {
        temperatura = new Temperatura();
    }

    @Test
    public void deveTerOsEstadoInicialZero() {
        assertEquals(0, temperatura.getCelsius(), DELTA);
        assertEquals(0, temperatura.getFahrenheit(), DELTA);
        assertEquals(0, temperatura.getKelvin(), DELTA);
    }

    @Test
    public void deveSerPossivelAlterarATemperaturaEmCelcisus() {
        temperatura.setCelsius(30);
        assertEquals(30, temperatura.getCelsius(), DELTA);
        assertEquals(86, temperatura.getFahrenheit(), DELTA);
        assertEquals(303.15, temperatura.getKelvin(), DELTA);
    }

    @Test
    public void deveSerPossivelAlterarATemperaturaEmFahrenheit() {
        temperatura.setFahrenheit(50);
        assertEquals(10, temperatura.getCelsius(), DELTA);
        assertEquals(50, temperatura.getFahrenheit(), DELTA);
        assertEquals(283.15, temperatura.getKelvin(), DELTA);
    }

    @Test
    public void deveSerPossivelAlterarATemperaturaEmKelvin() {
        temperatura.setKelvin(273.15);
        assertEquals(0, temperatura.getCelsius(), DELTA);
        assertEquals(32, temperatura.getFahrenheit(), DELTA);
        assertEquals(273.15, temperatura.getKelvin(), DELTA);
    }
}