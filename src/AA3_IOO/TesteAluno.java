package AA3_IOO;
//Klesio Antonio do Nascimento

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteAluno {

	private Aluno aluno;

	@BeforeEach
	public void antesDeCadaTeste() {
		aluno = new Aluno();
	}

	@Test
	public void deveTerNomeVazio() {
		assertEquals("", aluno.getNome());
	}

	@Test
	public void deveSerInvalidoQuandoONomeForVazio() {
		assertFalse(aluno.eValida());

		String erro = "Nome não pode ser vazio.";
		assertEquals(erro, aluno.getErros().get(0));

		erro = "Deve ser informado o nome e sobrenome.";
		assertEquals(erro, aluno.getErros().get(1));
	}

	@Test
	public void deveSerValidoSeNomeComposto() {
		aluno = new Aluno("Diego Marczal");
		assertTrue(aluno.eValida());

		assertEquals(0, aluno.getErros().size());
	}

	@Test
	public void deveSerInvalidoSeNomeNaoForComposto() {
		aluno = new Aluno("Diego");
		assertFalse(aluno.eValida());

		String erro = "Deve ser informado o nome e sobrenome.";
		assertEquals(erro, aluno.getErros().get(0));
	}

	@Test
	public void deveSeTornarValido() {
		assertFalse(aluno.eValida());
		assertEquals(2, aluno.getErros().size());

		aluno.setNome("Diego Marczal");
		assertTrue(aluno.eValida());
		assertEquals(0, aluno.getErros().size());
	}

	@Test
	public void deveAlterarONome() {
		aluno.setNome("Diego Marczal");
		assertEquals("Diego Marczal", aluno.getNome());
	}

	@Test
	public void deveInstanciarInformandoONome() {
		aluno = new Aluno("Diego Marczal");
		assertEquals("Diego Marczal", aluno.getNome());
	}

	@Test
	public void deveIgnorarEspacosAntesEDepoisDoNome() {
		aluno = new Aluno("  Diego Marczal   ");
		assertEquals("Diego Marczal", aluno.getNome());

		aluno.setNome("  Diego Marczal  ");
		assertEquals("Diego Marczal", aluno.getNome());
	}
}
