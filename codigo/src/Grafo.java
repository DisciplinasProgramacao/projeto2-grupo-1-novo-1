/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/** 
 * Classe básica para um Grafo simples
 */
abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome){
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    /*
     * Metodo para verificar existência de vertice
     */
    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    /**
     * Verifica a existência de uma possível aresta, retornando null quando a aresta não existe. Caso exista, retorna um objeto de aresta
     * @param verticeA Vértice a ser considerado como origem ou destino da aresta
     * @param verticeB Vértice a ser considerado como origem ou destino da aresta
     * @return Objeto de aresta caso exista uma aresta que ligue os dois vértices do parâmetro. Caso não exista, retorna null
     */
    public Aresta existeAresta(int verticeA, int verticeB){

        Vertice vertcA = this.existeVertice(verticeA);
        Vertice vertcB = this.existeVertice(verticeB);

        if(vertcA!=null && vertcB !=null){
            Aresta arestaAParaB;
            Aresta arestaBParaA;
            
            arestaAParaB = vertcA.existeAresta(verticeB);
            arestaBParaA = vertcB.existeAresta(verticeA);
            
            if(arestaAParaB.destino() > 0) {
                return arestaAParaB;
            }
            if(arestaBParaA.destino() > 0) {
                return arestaAParaB;
            }
        }
    return null;
    }

    /**
     * Método para verificar a quantidade de arestas de um grafo.
     * @return Retorna em inteiro a quantidade de arestas de um grafo
     */
    private int quantidadeArestas(){

        int qtd = 0, grauTotal = 0;

        Vertice verticesArray[] = new Vertice[this.ordem()];
        verticesArray = this.vertices.allElements(verticesArray);

        if (verticesArray[0].grau() % 2 == 0) {
            for(int i = 0; i < this.ordem(); i++){
                grauTotal = grauTotal + verticesArray[i].grau();
            }    
        }
        else{
            for(int i = 1; i < this.ordem(); i++){
                grauTotal = grauTotal + verticesArray[i].grau();
            }
        }
        qtd = (grauTotal / 2);

        return qtd;
    }
    
    /**
     * Verifica se este é um grafo completo. 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo(){

        int tamanho = 0, tamanhoComp = 0;
        boolean resposta = false;
        int n = this.ordem();

        tamanho = (n + quantidadeArestas());
        tamanhoComp = (n + (n * ((n-1)/2)));

        if(tamanhoComp == tamanho){
            resposta = true;
        }
        return resposta;
    }

    /**
     * Método para gerar subgrafo
     * @param vertices Lista de vértices que irão compor subgrafo
     * @return Retorna um subgrafo
     */
    public Grafo subGrafo(Lista<Vertice> vertices){

        Grafo subgrafo = new GrafoCompleto("Subgrafo de "+this.nome, this.vertices.size());
        return subgrafo;
    }

    /**
     * Calcula a ordem do grafo 
     * @return Retorna a ordem do grafo em inteiro
     */
    public int ordem(){
        return this.vertices.size();
    }
    
    /**
     * Calcula o tamanho do grafo, sendo completo ou não
     * @return Retorna o tamanho do grafo em inteiro
     */
    public int tamanho(){
        
        int tamanho, ordem;
        ordem = ordem();

        if(completo()){
            tamanho = (ordem + (ordem * ((ordem - 1)/2)));
        }
        else{
            tamanho = ordem + quantidadeArestas();
        }
        return tamanho;
    }

    /**
     * Método para verificar se o grafo é euleriano
     * @return Retorna TRUE caso o grafo seja euleriano, FALSE caso não seja
     */
    public boolean euleriano(){

        if(ordem() > 0 && (ordem() % 2) == 1){
            return true;
        } 
        else {
            return false;
        }
    }

}
