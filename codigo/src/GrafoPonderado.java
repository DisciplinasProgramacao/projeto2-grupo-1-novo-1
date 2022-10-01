public class GrafoPonderado extends GrafoMutavel{

    public GrafoPonderado(String nome) {
        super(nome);
    }

    public void addAresta(int origem, int destino, int peso){
    
        Vertice verticesArray[] = new Vertice[this.ordem()];
        verticesArray = this.vertices.allElements(verticesArray);
        for (Vertice orig : verticesArray) {

            for (Vertice dest : verticesArray) {
                if (orig.existeAresta(dest.getId()) != null) {
               // Aresta ares = new Aresta(peso, dest.getId());
                }
            }
        }
    }
    
}
