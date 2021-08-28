package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteHorista {

    private Horista horista;

    @BeforeEach
    public void antesDeCadaTeste() {
        horista = new Horista("Diego",80,10);
    }

    @Test
    public void deveRetornarOSalarioDoHorista() {
        assertEquals(800,horista.getSalario());
    }

    @Test
    public void deverRetornarOTipoHorista() {
        assertEquals("Horista",horista.getTipo());
    }


}
