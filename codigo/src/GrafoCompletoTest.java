import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrafoCompletoTest {
    

    @Test
    public void testarCriarGrafo(){
        GrafoCompleto grafoTeste = new GrafoCompleto("Teste", 6);
        Lista<Vertice> vertices = new Lista<>();
        for(int i=0; i<4; i++){
            vertices.add(grafoTeste.existeVertice(i));
        }
        GrafoCompleto subgrafoTeste = grafoTeste.subGrafo(vertices);
        assertEquals(4, subgrafoTeste.ordem());
    }
}
