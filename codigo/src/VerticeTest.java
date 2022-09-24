import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VerticeTest {

    @Test
    public void verificaOrdem() {

        Vertice vert = new Vertice(1);
        assertEquals(0, vert.grau());
    }
    
}
