package EXlista_IOO_04.Relogio_12_e_24_horas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteRelogio {
    private Relogio relogio;

     @BeforeEach
     public void antesDeCadaTeste() {
         relogio = new Relogio();
     }

     /*
      * 24 Horas
      */
    @Test
    public void deveTerFormatoInicialDe24Horas() {
        assertEquals("24 horas", relogio.getFormato());
    }

    @Test
    public void deveTerAHoraComoZeroZeroInstanciadoComConstrutorPadrao() {
        assertEquals("00:00", relogio.getHoras());
    }

    @Test
    public void deveTerAHoraConformAjustadoNaInstanciacao() {
        relogio = new Relogio(15, 30);
        assertEquals("15:30", relogio.getHoras());
    }

    @Test
    public void deveSerPossivelAjustarAHora() {
        relogio.ajustaHora(14, 23);
        assertEquals("14:23", relogio.getHoras());
    }

    @Test
    public void naoDeveSerPossivelAjustarAHoraComValoresInvalidos() {
        relogio.ajustaHora(25, 60);
        assertEquals("00:00", relogio.getHoras());
    }

    @Test
    public void deveMarcarORitmoAlterandoOsMinutosDeUmEmUm() {
        relogio.marcaRitmo();
        assertEquals("00:01", relogio.getHoras());
    }

    @Test
    public void deveMarcarORitmoAlterandoAsHorasQuandoOsMinutosChegaremA60() {
        relogio.ajustaHora(11, 59);
        relogio.marcaRitmo();
        assertEquals("12:00", relogio.getHoras());
    }

    /*
     * 12 Horas
     */
    @Test
    public void deveTerAHoraInicial12AMoFormato12Horas() {
        relogio.trocaFormato();
        assertEquals("12:00 am", relogio.getHoras());
    }

    @Test
    public void deveSerPossivelAjustarAHoraFormato12Horas() {
        relogio.trocaFormato();
        relogio.ajustaHora(2, 23);
        assertEquals("02:23 am", relogio.getHoras());
    }

    @Test
    public void deveMarcarORitmoAlterandoAsHorasQuandoOsMinutosChegaremA60NoFormato12Horas() {
        relogio.trocaFormato();
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
        relogio.trocaFormato();

        relogio.ajustaHora(11, 59);
        relogio.marcaRitmo();
        assertEquals("12:00 pm", relogio.getHoras());

        relogio.ajustaHora(11, 59);
        relogio.marcaRitmo();
        assertEquals("12:00 am", relogio.getHoras());
    }

    /*
     * Alternar entre 12 e 24 Horas
     */
    @Test
    public void deveSerPossívelAlterarOFormato() {
        relogio.trocaFormato();
        assertEquals("12 horas", relogio.getFormato());
    }

    @Test
    public void deveManterAHoraEOsMinutosCorretamenteNaTroca() {
        relogio.ajustaHora(23, 50);
        relogio.trocaFormato();

        assertEquals("11:50 pm", relogio.getHoras());
    }

    @Test
    public void deveManterAHoraEOsMinutosCorretamenteNaTrocaCasoDois() {
        relogio.trocaFormato();  // Muda para 12 horas
        relogio.trocaPeriodo();  // Muda para PM

        relogio.ajustaHora(11, 50);

        relogio.trocaFormato(); // Muda para 24 horas
        assertEquals("23:50", relogio.getHoras());
    }

    @Test
    public void deveManterAHoraEOsMinutosCorretamenteNaTrocaCasoTres() {
        relogio.ajustaHora(12, 00);
        relogio.trocaFormato();

        assertEquals("12:00 pm", relogio.getHoras());
    }

    @Test
    public void deveManterAHoraEOsMinutosCorretamenteNaTrocaCasoQuatro() {
        relogio.ajustaHora(00, 00);
        relogio.trocaFormato();

        assertEquals("12:00 am", relogio.getHoras());
    }

    @Test
    public void deveManterAHoraEOsMinutosCorretamenteNaTrocaCasoCinco() {
        relogio.trocaFormato();  // Muda para 12 horas
        relogio.ajustaHora(12, 00);

        relogio.trocaFormato();  // Muda para 24 horas
        assertEquals("00:00", relogio.getHoras());
    }

    @Test
    public void deveManterAHoraEOsMinutosCorretamenteNaTrocaCasoSeis() {
        relogio.trocaFormato();  // Muda para 12 horas
        relogio.trocaPeriodo();  // Muda para PM
        relogio.ajustaHora(12, 00);

        relogio.trocaFormato();  // Muda 24 horas
        assertEquals("12:00", relogio.getHoras());
    }

}
