package Integração_entre_objetos.Relogio24Horas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteRelogio {
    
    private Relogio relogio;
    
    @BeforeEach
    public void antesDeCadaTeste() {
        relogio = new Relogio();
    }
    
    @Test
    public void deveTerHoraInicialZero() {
        assertEquals("00:00", relogio.getHora());
    }
    
    @Test
    public void deveSerPossivelAjustarAHoraPeloConstrutor() {
        relogio = new Relogio(15, 30);
        assertEquals("15:30", relogio.getHora());
    }
    
    @Test
    public void deveMarcarORitmo() {
        relogio.marcaRitmo();
        assertEquals("00:01", relogio.getHora());
    }
    
    @Test
    public void deveMarcarORitmoIncrementoAsHoras() {
        relogio.ajustaHora(15, 59);
        relogio.marcaRitmo();
        assertEquals("16:00", relogio.getHora());
    }
    
    @Test
    public void deveAjustaAHora() {
        relogio.ajustaHora(15, 59);
        assertEquals("15:59", relogio.getHora());
    }
    
    @Test
    public void naoDeveAlterarAHoraParaValoreInvalidos() {
        relogio.ajustaHora(24, 60);
        assertEquals("00:00", relogio.getHora());
    }
}
