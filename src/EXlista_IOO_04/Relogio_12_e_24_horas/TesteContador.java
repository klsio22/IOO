package EXlista_IOO_04.Relogio_12_e_24_horas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteContador {
    private Contador pn;
    
    @BeforeEach
    public void antesDeCadaTeste()
    {
        pn = new Contador(15);
    }

    @Test
    public void deveIncrementarPainelNumericoEmUm() {
        int valor = pn.getValor();
        pn.incrementa();
        
        assertEquals(valor+1, pn.getValor());
    }
    
    @Test
    public void deveAlterarOValorSomenteDentroDoIntervalo() {
        pn.setValor(5);
        assertEquals(5, pn.getValor());
        
        pn.setValor(20);
        assertEquals(5, pn.getValor());

        pn.setValor(-1);
        assertEquals(5, pn.getValor());
    }
    
    @Test
    public void deveRetornarOValorComZeroSeMenorQue10() {
        assertEquals("00", pn.getValorExibido());
        
        pn.setValor(9);
        assertEquals("09", pn.getValorExibido());
        
        pn.setValor(10);
        assertEquals("10", pn.getValorExibido());
    }
}
