import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GrafoNaoPonderadoTest {

    @Test
    public void TesteAdicionarVertice() {
        
    }

    @Test
    public void TesteConstruirGrafoMutavel() {

        GrafoNaoPonderado grafoNPonderado = new GrafoNaoPonderado("Grafo N ponderado teste");
        grafoNPonderado.addVertice(10);
        grafoNPonderado.addVertice(15);
        grafoNPonderado.addAresta(10, 15);
        assertEquals(2, grafoNPonderado.ordem());
    }
    
}