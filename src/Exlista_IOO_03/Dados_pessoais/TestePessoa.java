package Exlista_IOO_03.Dados_pessoais;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

public class TestePessoa
{
    private Pessoa pessoa;

    @BeforeEach
    public void antesDeCadaTeste() {
        pessoa = new Pessoa("Mateus", "Silva", 1960);
    }

    @Test
    public void devePermitirAlterarOsAtributos() {
    	pessoa.setNome("Rafaela");
    	pessoa.setSobrenome("Virmond");
    	pessoa.setAnoDeNascimento(1964);
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals(pessoa.getAnoDeNascimento(), 1964);
    }
    
    @Test
    public void deveRetornarONomeCompleto() {
        assertEquals("Mateus", pessoa.getNome());
        assertEquals("Silva", pessoa.getSobrenome());
        
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
    }
    
    @Test
    public void deveRetornarAIdade() {
    	int idade = getAnoAtual() - pessoa.getAnoDeNascimento();
        assertEquals(idade, pessoa.getIdade());
    }
    
    @Test
    public void deveRetornarAIdadeEmMeses() {
    	int idadeEmMeses = (getAnoAtual() - pessoa.getAnoDeNascimento()) * 12;
        assertEquals(idadeEmMeses, pessoa.getIdadeEmMeses());
    }
    
    @Test
    public void deveRemoverOsEspacosAntesEDepoisDaStringQuandoAlteradoPelosMetodosModificadores() {
    	pessoa.setNome(" Rafaela  ");
    	pessoa.setSobrenome("  Virmond      ");
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals("Rafaela Virmond", pessoa.getNomeCompleto());
    }
    
    @Test
    public void deveRemoverOsEspacosAntesEDepoisDaStringQuandoInstanciado() {
    	pessoa = new Pessoa(" Rafaela  ", "  Virmond      ", 1964);
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals("Rafaela Virmond", pessoa.getNomeCompleto());
    }
    
    @Test
    public void naoDeveAceitarValoresVaziosParaONomeESobrenome() {
    	pessoa.setNome("  ");
    	pessoa.setSobrenome("      ");
    	
    	assertEquals("Mateus", pessoa.getNome());
        assertEquals("Silva", pessoa.getSobrenome());
        
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
    }
    
    @Test
    public void naoDeveAceitarValoresEmBrancoNaInstanciacao() {
    	pessoa = new Pessoa("   ", "       ", 1964);
    	
    	assertEquals("<Não informado>", pessoa.getNome());
        assertEquals("<Não informado>", pessoa.getSobrenome());
        assertEquals("<Não informado> <Não informado>", pessoa.getNomeCompleto());
    }
    
    @Test
    public void deveCapitalizarONomeESobrenome() {
    	pessoa.setNome("rafaela");
    	pessoa.setSobrenome("virmond");
    	pessoa.setAnoDeNascimento(1964);
    	
    	assertEquals("Rafaela", pessoa.getNome());
        assertEquals("Virmond", pessoa.getSobrenome());
        assertEquals("Rafaela Virmond", pessoa.getNomeCompleto());
        
        pessoa = new Pessoa("mateus", "silva", 1960);
        assertEquals("Mateus Silva", pessoa.getNomeCompleto());
    }
    
    @Test
    public void naoDeveAceitarValoresMaioresQueADataAtualParaOAnoDeNascimento() {
    	pessoa.setAnoDeNascimento(getAnoAtual());
    	assertEquals(getAnoAtual(), pessoa.getAnoDeNascimento());
    	
    	pessoa.setAnoDeNascimento(getAnoAtual() + 1);
    	assertEquals(getAnoAtual(),pessoa.getAnoDeNascimento());
    }
    
    private int getAnoAtual() {
    	return Calendar.getInstance().get(Calendar.YEAR);
    }
    
}
