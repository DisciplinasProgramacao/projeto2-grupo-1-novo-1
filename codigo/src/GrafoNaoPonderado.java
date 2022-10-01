public class GrafoNaoPonderado extends GrafoMutavel{

    public GrafoNaoPonderado(String nome) {
        super(nome);
    }

    @Override
    public GrafoCompleto subGrafo(Lista<Vertice> vertices){
        Vertice verticesArray[] = new Vertice[ordem()];
        verticesArray = vertices.allElements(verticesArray);
        int naoNull = 0;
        for(int i = 0; i < this.ordem(); i++){
            if(verticesArray[i] != null){
                naoNull++;
            }
        }
        if(naoNull <= ordem() && naoNull > 0){
            return new GrafoCompleto("Subgrafo de " + this.nome, naoNull);
        } else return null;
    }
}
