package ExLista_IOO_02.Lampada;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {
    private Lampada lampada;

    @BeforeEach
    public void antesCadaTeste() {
        lampada = new Lampada();
    }

    @Test
    public void deveEstarApagada() {
        assertFalse(lampada.estaAcessa(), "Ao instanciar deve estar apagada");
    }

    @Test
    public void deveSerPossivelAcender() {
        lampada.acender();
        assertTrue(lampada.estaAcessa(), "Deve ser possível acender a lâmpada");
    }

    @Test
    public void deveSerPossivelApagar() {
        lampada.acender();
        lampada.apagar();
        assertFalse(lampada.estaAcessa(), "Deve ser possível apagar a lâmpada");
    }
}