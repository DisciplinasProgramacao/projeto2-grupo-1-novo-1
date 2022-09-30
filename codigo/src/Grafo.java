import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
class Grafo {
    public final String nome;
    private ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome) {
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public Vertice existeVertice(int idVertice) {
        return this.vertices.find(idVertice);
    }

    /**
     * Verifica a existẽncia de uma possível aresta, retornando null quando a aresta
     * não existe. Caso exista, retorna um objeto de aresta
     * 
     * @param verticeA Vértice a ser considerado como origem ou destino da aresta
     * @param verticeB Vértice a ser considerado como origem ou destino da aresta
     * @return Objeto de aresta caso exista uma aresta que ligue os dois vértices do
     *         parâmetro. Caso não exista, retorna null
     */
    public Aresta existeAresta(int verticeA, int verticeB) {
        Vertice orig = new Vertice(verticeA);
        orig.existeAresta(verticeB);

        return orig.existeAresta(verticeB);
    }

    /**
     * Verifica se este é um grafo completo.
     * 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo() {
        boolean resposta = true;

        return resposta;
    }

    /**
     * Calcula a ordem do grafo completo
     * 
     * @return Retorna a ordem do grafo completo em inteiro
     */
    public int ordem() {
        return this.vertices.size();
    }

    /**
     * Calcula o tamanho do grafo completo
     * 
     * @return Retorna o tamanho do grafo completo em inteiro
     */
    public int tamanho() {

        int ordem, tamanho;

        ordem = ordem();
        tamanho = ordem * ((ordem - 1) / 2);

        return tamanho;
    }

    public boolean euleriano() {

        if (ordem() > 0 && (ordem() % 2) == 1) {
            return true;
        } else
            return false;
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * 
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if (saida != null && chegada != null) {
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }

        return adicionou;
    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o
     * próximo id disponível.
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public boolean delAresta(int origem, int destino) {

        return false;
    }

    public boolean delVertice(int idVertice) {

        return false;
    }

    public void carregar(String nomeArquivo) throws Exception {

        FileReader fr = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(fr);

        try {

            String linha = br.readLine();
            String[] verticesLidos = linha.split(",");

            int qtdeArestas = Integer.parseInt(verticesLidos[1]);

            linha = br.readLine();
            String[] vetVertLidos = linha.split(",");
            int[] vetVertLidosToInt = Arrays.stream(vetVertLidos).mapToInt(Integer::parseInt).toArray();

            for (int v : vetVertLidosToInt) {
                this.addVertice(v);
            }

            System.out.println("Arestas lidas : ");
            for (int i = 0; i < qtdeArestas; i++) {
                linha = br.readLine();
                String[] arestasLidas = linha.split(",");
                int[] arestasLidasToInt = Arrays.stream(arestasLidas).mapToInt(Integer::parseInt).toArray();
                this.addAresta(arestasLidasToInt[0], arestasLidasToInt[1]);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void salvar(String nomeArquivo) throws IOException {
        File arquivo = new File(nomeArquivo);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter arqEscrita = new FileWriter(arquivo, false);
            BufferedWriter escritor = new BufferedWriter(arqEscrita);

            int qtdeVertices = this.ordem();
            int qtdeArestas = this.tamanho() - qtdeVertices;

            escritor.write(qtdeVertices + "," + qtdeArestas);
            escritor.newLine();

            Vertice verticesArray[] = new Vertice[qtdeVertices];
            verticesArray = vertices.allElements(verticesArray);

            for (Vertice vet : verticesArray) {
                escritor.write(vet.toString() + ",");
            }

            escritor.newLine();

            for (Vertice orig : verticesArray) {

                for (Vertice dest : verticesArray) {
                    if (orig.existeAresta(dest.getId()) != null) {
                        escritor.write(orig.toString() + "," + orig.existeAresta(dest.getId()).toString());
                        escritor.newLine();
                    }
                }
            }

            escritor.close();
            arqEscrita.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void GrafoCompleto(String nome, int ordem){
       
        this.vertices = new ABB<>();
        for(int i=0; i<ordem; i++){
            this.addVertice(i);
        }
        
        Vertice verticesArray[] = new Vertice[ordem];
        verticesArray = this.vertices.allElements(verticesArray);
        for (Vertice orig : verticesArray) {

            for (Vertice dest : verticesArray) {
           
               this.addAresta(orig.getId(), dest.getId()); 
              
            }
        }
    }  
public void ponderarArestas(int origem, int destino, int peso){
 
    Vertice verticesArray[] = new Vertice[this.ordem()];
    verticesArray = this.vertices.allElements(verticesArray);
    for (Vertice orig : verticesArray) {

        for (Vertice dest : verticesArray) {
            if (orig.existeAresta(dest.getId()) != null) {
              Aresta ares = new Aresta(peso, dest.getId());
         
        }
    }
}


    
}

public int[] buscaProfundade(Grafo buscado){
    int []seqBusca =null;

    


    return seqBusca;
}
    
}
    

}
