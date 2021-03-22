package cronometro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CronometroTest {
    private Cronometro cronometro;

    @BeforeEach
    public void antesDeAdcionarValor(){
        cronometro = new Cronometro();
    }

    @Test
    public void valorIncializazero() {
        assertEquals(0.0,cronometro.getValor());
    }

    @Test
    public void incrementaValor() {
        cronometro.incrementa();
        assertEquals(1.0,cronometro.getValor());
    }

    @Test
    public void zerarValorDoCronometro() {
        for ( int i = 0 ; i <= 2 ; i++){
            cronometro.incrementa();
        }

        assertEquals(3,cronometro.getValor());

        cronometro.zerarValor();
        assertEquals(0,cronometro.getValor());
    }

}