import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    static GrafoCompleto grafoTeste;

    @Test
    public void testarCriarSubgrafo(){
        
        grafoTeste = new GrafoCompleto("Teste", 6);
        Lista<Vertice> vertices = new Lista<>();
        for(int i=0; i<4; i++){
            vertices.add(grafoTeste.existeVertice(i));
        }
        GrafoCompleto subgrafoTeste = grafoTeste.subGrafo(vertices);
        assertEquals(4, subgrafoTeste.ordem());
    }

    @Test
    public void TestVerificaGrauDoGrafo() {
        
        grafoTeste = new GrafoCompleto("Teste", 5);
        assertEquals(10, grafoTeste.tamanho());        
    }

    @Test
    public void TestExisteAresta() {
        
        grafoTeste = new GrafoCompleto("Teste", 2);
        Lista<Aresta> aresta = new Lista<>();
        aresta.add(grafoTeste.existeAresta(1, 2));
        assertNull(grafoTeste.existeAresta(1, 2));       
    }
}
