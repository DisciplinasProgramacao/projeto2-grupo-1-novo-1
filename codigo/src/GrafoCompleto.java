
public class GrafoCompleto extends Grafo{
    private int ordem;
    
    /**
     * Construtor da classe GrafoCompleto, já preenchendo as arestas
     * @param nome Parâmetro que informa nome do Grafo
     * @param ordem Parâmetro que informa a ordem do Grafo
     */
    public GrafoCompleto(String nome, int ordem){
        super(nome);
        this.ordem = ordem;
        for(int i=0; i<ordem; i++){
            Vertice novo = new Vertice(i);
            this.vertices.add(i, novo);
        }
        for(int j=0; j<ordem; j++){
            for(int k=j+1; k<ordem; k++){
                Vertice saida = this.vertices.find(j);
                Vertice chegada = this.vertices.find(k);
                saida.addAresta(k);
                chegada.addAresta(j);
            }
        }
    }
    
    /**
     * Override sempre retorna true
     */
    @Override
    public boolean completo(){
        return true;
    }
    
    /**
     * Override verifica aresta grafo completo
     */
    @Override
    public Aresta existeAresta(int verticeA, int verticeB){
        if(existeVertice(verticeA) != null && existeVertice(verticeB) != null){
            Vertice origem = this.vertices.find(verticeA);
            return origem.existeAresta(verticeB);
        } else return null;
    }
    
    /**
     * Override verifica vertice grafo completo
     */
    @Override
    public Vertice existeVertice(int idVertice){
        if(idVertice >= 0 && idVertice < ordem){
            return this.vertices.find(idVertice);
        } else return null;
    }

    /**
     * Override verifica se o grafo é euleriano
     */
    @Override
    public boolean euleriano(){
        if(ordem > 0 && (ordem % 2) == 1){
            return true;
        } else return false;
    }

    /**
     * Override para criar subgrafo completo
     */
    @Override
    public GrafoCompleto subGrafo(Lista<Vertice> vertices){
        Vertice verticesArray[] = new Vertice[this.ordem];
        verticesArray = vertices.allElements(verticesArray);
        int naoNull = 0;
        for(int i = 0; i < this.ordem; i++){
            if(verticesArray[i] != null){
                naoNull++;
            }
        }
        if(naoNull <= ordem && naoNull > 0){
            return new GrafoCompleto("Subgrafo de " + this.nome, naoNull);
        } else return null;
    }
}