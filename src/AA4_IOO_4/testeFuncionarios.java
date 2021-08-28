package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class testeFuncionarios  {
    private Funcinarios funcinarios;

    @BeforeEach
    public void antesDeCadaTeste() {
        funcinarios = new Funcinarios("Diego", 800) {
            @Override
            public String getTipo() {
                return null;
            }
        };
    }

    @Test
    public void deveRetornarOSalarioDoHorista() {
        assertEquals(800,funcinarios.getSalario());
    }

    @Test
    public void deverRetornarOTipoHorista() {
        assertEquals("Diego",funcinarios.getNome());
    }

}
