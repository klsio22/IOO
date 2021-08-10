package AA3_IOO_minicurso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TesteFlash {

	@Test
	public void deveArmazenarMensagens() {
		Flash.mensagem("Mensagem 1");
		Flash.mensagem("Mensagem 2");
		Flash.mensagem("Mensagem 3");
		
		ArrayList<String> mensagens = Flash.getMensagens();
		
		assertEquals("Mensagem 1", mensagens.get(0));
		assertEquals("Mensagem 2", mensagens.get(1));
		assertEquals("Mensagem 3", mensagens.get(2));
	}
	
	@Test
	public void deveLimparAsMensagensAposOReturno() {
		Flash.mensagem("Mensagem 1");
		Flash.mensagem("Mensagem 2");
		Flash.mensagem("Mensagem 3");
		
		assertEquals(3, Flash.getMensagens().size());
		assertEquals(0, Flash.getMensagens().size());
	}
}
