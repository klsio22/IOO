package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testeFuncionarios {
    private Funcinario funcinario;

    @BeforeEach
    public void antesDeCadaTeste() {
        funcinario = new Funcinario("Diego", 800) {
            @Override
            public String getTipo() {
                return null;
            }
        };
    }

    @Test
    public void deveRetornarOSalarioDoHorista() {
        assertEquals(800, funcinario.getSalario());
    }

    @Test
    public void deverRetornarOTipoHorista() {
        assertEquals("Diego", funcinario.getNome());
    }

}
