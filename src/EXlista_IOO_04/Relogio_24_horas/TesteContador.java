package EXlista_IOO_04.Relogio_24_horas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteContador {
    
    private Contador c;
    
    @BeforeEach
    public void antesDeCadaTeste() {
        c = new Contador(24);
    }
    
    @Test
    public void deveTerValorIncialZero() {
        assertEquals(0, c.getValor());
    }
    
    @Test
    public void deveAlterarOValorDentroDoIntervaloPermitido() {
        c.setValor(10);
        assertEquals(10, c.getValor());
        
        c.setValor(-1);
        assertEquals(10, c.getValor());
        
        c.setValor(24);
        assertEquals(10, c.getValor());
    }
    
    @Test
    public void deveRetornarOValorComDoisDigitos() {
        assertEquals("00", c.getValorExibido());
        c.setValor(9);
        assertEquals("09", c.getValorExibido());
        c.setValor(10);
        assertEquals("10", c.getValorExibido());
    }
}
