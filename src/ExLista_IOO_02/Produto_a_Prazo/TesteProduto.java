package ExLista_IOO_02.Produto_a_Prazo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class TesteProduto {
    private static final double DELTA = 0.001;
    private Produto produto;

    @BeforeEach
    public void antesDeCadaTeste() {
        produto = new Produto();
    }

    @Test
    public void deveAlterarOPreco() {
        produto.setPreco(100);
        assertEquals(100, produto.getPreco(), DELTA);
    }

    @Test
    public void deveAlterarAPorcentagemDeDesconto() {
        produto.setPorcentagemDeDesconto(50);
        assertEquals(50, produto.getPorcentagemDeDesconto(), DELTA);
    }

    @Test
    public void deveAlterarATaxaDeJurosMensal() {
        produto.setTaxaDeJurosMensal(15);
        assertEquals(15, produto.getTaxaDeJurosMensal(), DELTA);
    }

    @Test
    public void deveAlterarONumeroDeParcelas() {
        produto.setNumeroDeParcelas(10);
        assertEquals(10, produto.getNumeroDeParcelas(), DELTA);
    }

    @Test
    public void deveRetornarOPrecoAVista() {
        produto.setPreco(50);
        produto.setPorcentagemDeDesconto(25);
        assertEquals(37.5, produto.getPrecoAVista(), DELTA);
    }

    @Test
    public void deveRetornarOValorDaPrestacao() {
        produto.setPreco(100);
        produto.setTaxaDeJurosMensal(15);
        produto.setNumeroDeParcelas(10);
        assertEquals(19.925, produto.getValorDaPrestacao(), DELTA);
    }

    @Test
    public void deveRetornarOTotalPagoComJuros() {
        produto.setPreco(100);
        produto.setTaxaDeJurosMensal(15);
        produto.setNumeroDeParcelas(10);
        assertEquals(199.252, produto.getPrecoTotalComJuros(), DELTA);
    }

    @Test
    public void deveRetornarOTotalDeJurosPago() {
        produto.setPreco(100);
        produto.setTaxaDeJurosMensal(15);
        produto.setNumeroDeParcelas(10);
        assertEquals(99.252, produto.getTotalDeJurosPago(), DELTA);
    }

}