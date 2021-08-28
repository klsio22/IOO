package AA4_IOO_4;
//Klésio Antônio do Nascimento - Turma: SI1B

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesteEmpresa {

    private Empresa empresa;

    @BeforeEach
    public void antesDeCadaTeste() {
        empresa = new Empresa();
    }

    @Test
    public void deveRegistrarUmFuncinarioMensalista() {
        empresa.registraFuncionario(new Mensalista("Ana", 1000));

        for (Funcinario f : empresa.getFuncionarios()) {
            assertEquals("Ana", f.getNome());
            assertEquals("Mensalista", f.getTipo());
            assertEquals(1000, f.getSalario());
        }
    }

    @Test
    public void deveRegistrarUmFuncinarioHorista() {
        empresa.registraFuncionario(new Horista("Marcos", 80, 10));

        for (Funcinario f : empresa.getFuncionarios()) {
            assertEquals("Marcos", f.getNome());
            assertEquals("Horista", f.getTipo());
            assertEquals(800, f.getSalario());
        }
    }

    @Test
    public void totalDeSalariosAPagar() {
        empresa.registraFuncionario(new Mensalista("Ana", 1000));
        empresa.registraFuncionario(new Horista("Klesio", 100, 10));
        assertEquals(2000, empresa.getTotalDeSalariosAPagar());
    }

}
