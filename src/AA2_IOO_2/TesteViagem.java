package AA2_IOO_2;
//Klesio Antonio do Nascimento

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteViagem {

	private static final double DELTA = 0.001;
	private Viagem viagem;
		
	@BeforeEach
	public void antesDeCadaConstrutor() {
		Carro carro = new Carro(10, 4.20);
		Rodovia rodovia = new Rodovia(111, 37, 10);
		viagem = new Viagem(rodovia, carro);
	}
	
	@Test
	public void deveCalcularOCustoDaViagem() {
		assertEquals(76.62, viagem.getCusto(), DELTA);
	}

}
