package Exlista_IOO_03.Data_simples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteData {

    private Data data;

    @BeforeEach
    public void antesDeCadaTeste() {
        data = new Data(10, 10, 2017);
    }

    @Test
    public void deveSerInstanciadaInformandoDiaMesAnoSeparadamente() {
        assertEquals("10/10/2017", data.getData());
    }

    @Test
    public void deveSerInstanciadaInformandoUmaString() {
        data = new Data("11/12/2017");
        assertEquals("11/12/2017", data.getData());

        data = new Data("01/02/2021");
        assertEquals("01/02/2021", data.getData());

    }

    @Test
    public void deveIncluirOZeroNoDiaEAnoCasoValorSejaMenorQue10() {
        data = new Data(1, 1, 2017);
        assertEquals("01/01/2017", data.getData());

        data = new Data(11, 11, 2021);
        assertEquals("11/11/2021", data.getData());

    }
}
