package EXlista_IOO_04.Relogio_12_Horas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteRelogio {
    private Relogio relogio;

    @BeforeEach
    public void antesDeCadaTeste() {
        relogio = new Relogio();
    }

    @Test
    public void deveTerAHora12AMInstanciadoComConstrutorPadrao() {
        assertEquals("12:00 am", relogio.getHoras());
    }

    @Test
    public void deveTerAHoraConformAjustadoNaInstanciacao() {
        relogio = new Relogio(3, 30);
        assertEquals("03:30 am", relogio.getHoras());
    }

    @Test
    public void deveSerPossivelAjustarAHora() {
        relogio.ajustaHora(2, 23);
        assertEquals("02:23 am", relogio.getHoras());
    }

    @Test
    public void naoDeveSerPossivelAjustarAHoraComValoresInvalidos() {
        relogio.ajustaHora(13, 30);
        assertEquals("12:30 am", relogio.getHoras());
    }

    @Test
    public void deveMarcarORitmoAlterandoOsMinutosDeUmEmUm() {
        relogio.marcaRitmo();
        assertEquals("12:01 am", relogio.getHoras());
    }

    @Test
    public void deveMarcarORitmoAlterandoAsHorasQuandoOsMinutosChegaremA60() {
        relogio.ajustaHora(10, 59);
        relogio.marcaRitmo();
        assertEquals("11:00 am", relogio.getHoras());
    }

    @Test
    public void deveTerPeriodoInicialAM() {
        assertEquals("am", relogio.getPeriodo());
    }

    @Test
    public void deveSerPossivelAlterarOPerido() {
        relogio.trocaPeriodo();
        assertEquals("pm", relogio.getPeriodo());
    }

    @Test
    public void deveMarcarORitmoAlterandoOPeridoQuandoChegarEm12() {
        relogio.ajustaHora(11, 59);
        relogio.marcaRitmo();
        assertEquals("12:00 pm", relogio.getHoras());

        relogio.ajustaHora(11, 59);
        relogio.marcaRitmo();
        assertEquals("12:00 am", relogio.getHoras());
    }


}
