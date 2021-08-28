package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteMensalista {
    private Mensalista mensalista;
    private Empresa empresa;

    @BeforeEach
    public void antesDeCadaTeste() {
        mensalista = new Mensalista("Marcos",1500);
    }

    @Test
    public void deveRetornarOSalarioDoMensalista() {
        assertEquals(1500, mensalista.getSalario());
    }

    @Test
    public void deverRetornarOTipoHorista() {
        assertEquals("Mensalista",mensalista.getTipo());
    }

}
