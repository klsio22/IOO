package Simulado02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTeste {

    private Cliente c;

    @BeforeEach
    public void setUp() {
        c = new Cliente("Ruby da Silva Sobrinha", "433.616.121-61");
    }

    @Test
    public void devePossuirONomeConformeOArgumentoNoConstrutor() {
        assertEquals("Ruby da Silva Sobrinha", c.getNome());
    }

    @Test
    public void devePossuirOCpfConformeOArgumentoNoConstrutor() {
        assertEquals("433.616.121-61", c.getCpf());
    }

    @Test
    public void devePermetirAlterarONome() {
        c.setNome("Baltazar Neto Sobrinho");
        assertEquals("Baltazar Neto Sobrinho", c.getNome());
    }

    @Test
    public void devePermetirAlterarOCpf() {
        c.setCpf("322.744.753-34");
        assertEquals("322.744.753-34", c.getCpf());
    }

    @Test
    public void deveRemoverEspacosAntesEDepoisDaStringAoFazerUmaAtribuicaoPeloSet() {
        c.setNome(" Bernardo Sobrinho  ");
        c.setCpf("433.616.121-60 ");

        assertEquals("Bernardo Sobrinho", c.getNome());
        assertEquals("433.616.121-60", c.getCpf());
    }

    @Test
    public void deveRemoverEspacosAntesEDepoisDaStringAoFazerUmaAtribuicaoPeloConstrutor() {
        c = new Cliente(" Bernardo Sobrinho  ", "433.616.121-60 ");

        assertEquals("Bernardo Sobrinho", c.getNome());
        assertEquals("433.616.121-60", c.getCpf());
    }

    @Test
    public void devePossuirONomeCompostoPorNoMinimoDuasPalavras() {
        c.setNome("João");
        assertNotEquals("João", c.getNome());
        assertEquals("Ruby da Silva Sobrinha", c.getNome());

        c.setNome(" João");
        assertNotEquals(" João", c.getNome());
        assertEquals("Ruby da Silva Sobrinha", c.getNome());

        c.setNome("João Neto");
        assertEquals("João Neto", c.getNome());
    }

    @Test
    public void oNomeDeveSerNuloCasoOArgumentoDoConstrutorOuNoSetSejaInvalido() {
        c = new Cliente("Bartolomeu", "533.753.875-63 ");
        assertNull(c.getNome());
        assertEquals("533.753.875-63", c.getCpf());

        c.setNome("  Douglas  ");
        assertNull(c.getNome());

        c = new Cliente("Frederico ", "773.874.532-09");
        assertNull(c.getNome());
        assertEquals("773.874.532-09", c.getCpf());
    }

    @Test
    public void oCpfDeveSerNuloCasoOArgumentoDoConstrutorOuNoSetSejaInvalido() {
        c = new Cliente("Bartolomeu da Silva", "533.753.875-6");
        assertNull(c.getCpf());

        c.setCpf("045.200");
        assertNull(c.getCpf());
    }


    @Test
    public void cpfDevePossuirExatamente14CaracteresQuandoInvalidoMatemOValorAtual() {
        c = new Cliente("Bartolomeu Dias", "533.753.875-86");

        assertEquals("Bartolomeu Dias", c.getNome());
        assertEquals("533.753.875-86", c.getCpf());

        c.setCpf("533.753.875-8");
        assertEquals("533.753.875-86", c.getCpf());

        c.setCpf("533.753.875-86  ");
        assertEquals("533.753.875-86", c.getCpf());

        c = new Cliente("Frederico ", "773.874.532-0912");
        assertNull(c.getNome());
        assertNull(c.getCpf());
    }

}
