import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GrafoPonderadoTest {

    @Test
    public void CriarGrafoPonderadoTest() {

        GrafoPonderado grafoPonderado = new GrafoPonderado("Ponderado Test");
        grafoPonderado.addVertice(1);
        grafoPonderado.addVertice(2);
        grafoPonderado.addVertice(3);

        grafoPonderado.addAresta(1, 2, 44);
        grafoPonderado.addAresta(1, 3, 40);
        grafoPonderado.addAresta(3, 2, 46);

        assertTrue(grafoPonderado.completo());
        
    }
    
}
