package AA3_IOO_minicurso;
//Klesio Antonio do Nascimento
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteMinicurso {

	private Minicurso curso;
	
	@BeforeEach
	public void antesDeCadaTeste() {
		curso = new Minicurso("Java", 2);
		Flash.limpar();
	}
	
	@Test
	public void deveTerOsArgumentosInformadosNoConstrutor() {
		assertEquals("Java", curso.getNome());
		assertEquals(2, curso.getNumeroDeVagas());
	}
	
	@Test
	public void deveMatricular() {
		Aluno aluno = new Aluno("Diego Marczal");
		assertTrue(curso.matricular(aluno));
		
		assertEquals(1, curso.getQuantidadDeMatriculados());
		assertEquals(aluno, curso.getMatriculados().get(0));
		assertEquals("Aluno matriculado com sucesso!", Flash.getMensagens().get(0));
	}
	
	@Test
	public void naoDeveMatricularAlunoInvalido() {
		Aluno aluno = new Aluno("Diego");
		
		assertFalse(curso.matricular(aluno));
		assertEquals(0, curso.getQuantidadDeMatriculados());
		assertEquals("Existem dados incorretos! Por favor verifique!", Flash.getMensagens().get(0));
	}
	
	@Test
	public void naoDeveMatricularOMesmoAlunoDuasVezes() {
		curso.matricular(new Aluno("Diego Marczal"));
		curso.matricular(new Aluno("Diego Marczal"));
		
		assertEquals(1, curso.getQuantidadDeMatriculados());
		assertEquals(0, curso.getQuantidadeEmEspera());
		assertEquals("Este aluno já está registrado!", Flash.getMensagens().get(1));
	}
	
	@Test
	public void naoDeveMatricularOMesmoAlunoDuasVezesInclusiveNaListaDeEspera() {
		curso.matricular(new Aluno("Diego Marczal"));
		curso.matricular(new Aluno("Eleandro Maschio"));
		curso.matricular(new Aluno("Andres Jesse"));
		curso.matricular(new Aluno("Andres Jesse"));
		
		assertEquals(2, curso.getQuantidadDeMatriculados());
		assertEquals(1, curso.getQuantidadeEmEspera());
		assertEquals("Este aluno já está registrado!", Flash.getMensagens().get(3));
	}
	
	@Test
	public void deveInserirNaListaDeEsperaQuandoNumeroDeMatriculadosForAtingido() {
		curso.matricular(new Aluno("Diego Marczal"));
		curso.matricular(new Aluno("Eleandro Maschio"));
		
		Aluno aluno = new Aluno("Andres Jesse");
		curso.matricular(aluno);

		assertEquals(2, curso.getQuantidadDeMatriculados());
		assertEquals(1, curso.getQuantidadeEmEspera());
		
		assertEquals(aluno, curso.getListaDeEspera().get(0));
		assertEquals("Turma lotada! Aluno adicionado na lista de espera!", Flash.getMensagens().get(2));
	}
	
	@Test
	public void naoDeveMatricularCasoATurmaEListaEsperaLotadas() {
		curso.matricular(new Aluno("Diego Marczal"));
		curso.matricular(new Aluno("Eleandro Maschio"));
		curso.matricular(new Aluno("Andres Jesse"));
		curso.matricular(new Aluno("Luciano Ogibolski"));
		curso.matricular(new Aluno("Guilherme Silva"));
		
		assertEquals(2, curso.getQuantidadDeMatriculados());
		assertEquals(2, curso.getQuantidadeEmEspera());
		
		assertEquals("Turma e lista de espera lotadas! Aguarde novas informações", Flash.getMensagens().get(4));
	}
	
	@Test
	public void deveRemoverAlunoMatriculado() {
		Aluno aluno = new Aluno("Diego Marczal");
		curso.matricular(aluno);
		
		assertEquals(aluno, curso.removerAlunoMatriculado("Diego Marczal"));
		assertEquals(0, curso.getQuantidadDeMatriculados());
		assertEquals("Aluno '" + aluno.getNome() + "' removido com sucesso", Flash.getMensagens().get(1));
	}
	
	@Test
	public void aoRemoveAlunoInformarCasoNaoOEncontre() {
		Aluno aluno = new Aluno("Diego Marczal");
		curso.matricular(aluno);
		
		assertEquals(null, curso.removerAlunoMatriculado("Diego"));
		assertEquals(1, curso.getQuantidadDeMatriculados());
		assertEquals("Não existe um aluno com o nome 'Diego'", Flash.getMensagens().get(1));
	}
	
	@Test
	public void deveRemanejarAlunoDaListaDeEsperaParaMatriculadosQuandoRemover() {
		Aluno aluno = new Aluno("Andres Jesse");
		
		curso.matricular(new Aluno("Diego Marczal"));
		curso.matricular(aluno);
		curso.matricular(new Aluno("Eleandro Maschio"));
		curso.matricular(new Aluno("Luciano Ogibolski"));
		
		assertEquals(aluno, curso.removerAlunoMatriculado("Andres Jesse"));
		assertEquals(2, curso.getQuantidadDeMatriculados());
		assertEquals(1, curso.getQuantidadeEmEspera());
	}
	
}
