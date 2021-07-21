package AA2_IOO_2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteCarro {

	private static final double DELTA = 0.001;
	
	private Carro carro;
		
	@BeforeEach
	public void antesDeCadaConstrutor() {
		carro = new Carro(10, 4.20);
	}
	
	@Test
	public void devePossuirEstadoConformeArgumentosDoConstrutor() {
		assertEquals(10, carro.getKmPorLitro());
		assertEquals(4.20, carro.getPrecoDoCombustivel());
	}

	@Test
	public void deveCalcularOCustoDoKmRodado() {
		assertEquals(0.42, carro.getCustoDoKm(), DELTA);
	}
}
