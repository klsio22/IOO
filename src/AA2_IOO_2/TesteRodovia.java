package AA2_IOO_2;
//Klesio Antonio do Nascimento
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TesteRodovia {

	private Rodovia rodovia;
	
	@Test
	public void devePossuirEstadoConformeArgumentosDoConstrutor() {
		rodovia = new Rodovia(111, 37, 10);
		assertEquals(111, rodovia.getDistancia());
		assertEquals(37,  rodovia.getDistanciaEntrePedagios());
		assertEquals(10,  rodovia.getPrecoDeCadaPedagio());
	}

	@Test
	public void deveCalcularOCustoDaViagemNaRodovia() {
		rodovia = new Rodovia(111, 37, 10);
		assertEquals(30, rodovia.getCustoDaViagemRodovia());
	}

}
