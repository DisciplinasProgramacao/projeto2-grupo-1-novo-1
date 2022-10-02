import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GrafoNaoPonderadoTest {

    @Test
    public void TestCriarGrafoPonderadoVerificandoOrdem() {

        GrafoNaoPonderado grafoNaoPonderado = new GrafoNaoPonderado("Não Ponderado");
        grafoNaoPonderado.addVertice(1);
        grafoNaoPonderado.addVertice(2);
        grafoNaoPonderado.addVertice(3);
        grafoNaoPonderado.ordem();

        assertEquals(3,grafoNaoPonderado.ordem());
    }

    @Test
    public void TestVerificarGrafoPonderadoCompletoComOrdemPar() {

        GrafoNaoPonderado grafoNaoPonderado = new GrafoNaoPonderado("Não Ponderado");
        grafoNaoPonderado.addVertice(1);
        grafoNaoPonderado.addVertice(2);
        grafoNaoPonderado.addVertice(3);
        grafoNaoPonderado.addVertice(4);

        grafoNaoPonderado.addAresta(1, 2);
        grafoNaoPonderado.addAresta(1, 3);
        grafoNaoPonderado.addAresta(1, 4);
        grafoNaoPonderado.addAresta(2, 3);
        grafoNaoPonderado.addAresta(2, 4);
        grafoNaoPonderado.addAresta(3, 4);

        assertTrue(grafoNaoPonderado.completo());
    }

    @Test
    public void TestVerificarGrafoPonderadoCompletoComOrdemImpar() {

        GrafoNaoPonderado grafoNaoPonderado = new GrafoNaoPonderado("Não Ponderado");
        grafoNaoPonderado.addVertice(1);
        grafoNaoPonderado.addVertice(2);
        grafoNaoPonderado.addVertice(3);

        grafoNaoPonderado.addAresta(1, 2);
        grafoNaoPonderado.addAresta(1, 3);
        grafoNaoPonderado.addAresta(2, 3);

        assertTrue(grafoNaoPonderado.completo());
    }

    @Test
    public void TestVerificarGrafoPonderadoNaoCompleto() {

        GrafoNaoPonderado grafoNaoPonderado = new GrafoNaoPonderado("Não Ponderado");
        grafoNaoPonderado.addVertice(1);
        grafoNaoPonderado.addVertice(2);
        grafoNaoPonderado.addVertice(3);

        grafoNaoPonderado.addAresta(1, 2);
        grafoNaoPonderado.addAresta(1, 3);

        assertFalse(grafoNaoPonderado.completo());
    }
    
}
