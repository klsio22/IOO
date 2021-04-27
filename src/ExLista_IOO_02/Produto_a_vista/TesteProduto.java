package ExLista_IOO_02.Produto_a_vista;

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
    public void deveRetornarOPrecoAVista() {
        produto.setPreco(50);
        produto.setPorcentagemDeDesconto(25);
        assertEquals(37.5, produto.getPrecoAVista(), DELTA);
    }
}