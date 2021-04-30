package Exlista_IOO_03.Retangulo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteRetangulo {

    private static final double DELTA = 0.001;

    private Retangulo r;

    @BeforeEach
    public void antesDeCadaTeste() {
        r = new Retangulo(10, 20);
    }

    @Test
    public void deveInstaciarUsandoOConstrutorPadrão() {
        r = new Retangulo();
        assertEquals(1, r.getBase(), DELTA);
        assertEquals(1, r.getAltura(), DELTA);
    }

    @Test
    public void deveInformarOTamanhoDeUmLadoNoConstrutor() {
        r = new Retangulo(10);
        assertEquals(10, r.getBase(), DELTA);
        assertEquals(10, r.getAltura(), DELTA);
    }

    @Test
    public void deveInformarOTamanhoDaBaseEDaAlturaNoConstrutor() {
        assertEquals(10, r.getBase(), DELTA);
        assertEquals(20, r.getAltura(), DELTA);
    }

    @Test
    public void deveAlterarABasePeloSet() {
        r.setBase(50);
        assertEquals(50, r.getBase(), DELTA);
    }

    @Test
    public void deveAlterarAAlturaPeloSet() {
        r.setAltura(100);
        assertEquals(100, r.getAltura(), DELTA);
    }

    @Test
    public void deveTerArea() {
        assertEquals(200, r.getArea(), DELTA);
    }

    @Test
    public void deveTerPerimetro() {
        assertEquals(60, r.getPerimetro(), DELTA);
    }

    @Test
    public void deveVerificarSeEUmQuadrado() {
     //   assertFalse("Nao e quadrado", r.eQuadrado());
        r.setBase(20);
      //  assertTrue("E quadrado", r.eQuadrado());
    }



    @Test
    public void deveVerificarSeTemAreaMaiorQueUmValorInformado() {
        //assertFalse("Nao tem area maior que 200", r.temAreaMaiorQue(210));
        // assertTrue("Tem area maior que 20", r.temAreaMaiorQue(20));
    }

    @Test
    public void deveVerificarSeTemAreaMaiorQueUmOutroRetanguloInformado() {
        Retangulo r2 = new Retangulo(30, 30);
        Retangulo r3 = new Retangulo(10);

        //   assertFalse("Nao tem area maior que 900", r.temAreaMaiorQue(r2));
        //   assertTrue("Tem area maior que 100", r.temAreaMaiorQue(r3));
    }
}
