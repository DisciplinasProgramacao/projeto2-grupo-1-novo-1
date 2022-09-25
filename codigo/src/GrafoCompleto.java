public class GrafoCompleto extends Grafo{
    private int ordem;
    private ABB<Vertice> vertices;
    
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
    
    @Override
    public boolean completo(){
        return true;
    }
    
    @Override
    public Aresta existeAresta(int verticeA, int verticeB){
        if(existeVertice(verticeA) != null && existeVertice(verticeB) != null){
            Vertice origem = this.vertices.find(verticeA);
            return origem.existeAresta(verticeB);
        } else return null;
    }
    
    @Override
    public Vertice existeVertice(int idVertice){
        if(idVertice >= 0 && idVertice < ordem){
            return this.vertices.find(idVertice);
        } else return null;
    }

    @Override
    public boolean euleriano(){
        if(ordem > 0 && (ordem % 2) == 1){
            return true;
        } else return false;
    }

  
    //@Override
    public GrafoCompleto subgrafo(ABB<Vertice> vertices){
        if(vertices.size() <= ordem){
            return new GrafoCompleto(nome, vertices.size());
        } else return null;
    }
    
}