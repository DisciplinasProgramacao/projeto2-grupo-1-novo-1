public class GrafoNaoPonderado extends GrafoMutavel{

    public GrafoNaoPonderado(String nome) {
        super(nome);
    }

    /*
     * Override permite apenas arestas sem peso
     */
    @Override
    public boolean addAresta(int origem, int destino){
        int peso = 0;
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino, peso);
            chegada.addAresta(origem, peso);
            adicionou = true;
    }
        return adicionou;
    }


    /*
     * Override para subgrafo não ponderado
     */
    @Override
    public GrafoNaoPonderado subGrafo(Lista<Vertice> vertices){
        Vertice verticesArray[] = new Vertice[ordem()];
        verticesArray = vertices.allElements(verticesArray);
        int naoNull = 0;
        for(int i = 0; i < this.ordem(); i++){
            if(verticesArray[i] != null){
                naoNull++;
            }
        }
        if(naoNull <= ordem() && naoNull > 0){
            return new GrafoNaoPonderado("Subgrafo de " + this.nome);
        } else return null;
    }
}
