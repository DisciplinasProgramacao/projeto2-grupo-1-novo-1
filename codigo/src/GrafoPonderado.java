public class GrafoPonderado extends GrafoMutavel{

    public GrafoPonderado(String nome) {
        super(nome);
    }
    /**
     * Adiciona aresta ponderada entre os vertices passados por parametro.
     * @param origem vertice de origem da aresta.
     * @param destino vertice de destino da aressta.
     * @param peso valor de ponderação da aresta.
     */
    public boolean addAresta(int origem, int destino, int peso){

        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino,peso);
            chegada.addAresta(origem,peso);
            adicionou = true;
        }
        return adicionou;
    }
    /**
     * Cria subgrafo com os vertices passados por parametro.
     * @param vertices lista de vertices para criação do subgrafo.
     */

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
