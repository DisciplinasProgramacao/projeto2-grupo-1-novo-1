import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

abstract class GrafoMutavel extends Grafo{

    public GrafoMutavel(String nome){
        super(nome);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo. 
     * Não verifica se os vértices pertencem ao grafo.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
    }
    
        return adicionou;
    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o próximo id disponível.
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Lê arquivo formato cvs no local passado por parametro e carrega os dados no grafo.
     * Primeira linha do arquivo deve conter número de vertices e número de arestas.
     * Segunda linha deve conter todos os vertices do grafo.
     * Linhas seguintes devem ter os pares de vertices que tem arestas.
     * @param nomeArquivo local do arquivo a ser carregado.
     */

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
    /**
     * Salva grafo em arquivo formato cvs.
     * Cria novo arquivo no local se não existir ou sobregrava se existir.
     * @param nomeArquivo local do arquivo a ser salvo.
     */
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

    /**
     * Cria grafo completo.
     * @param nome nome identificador do grafo.
     * @param ordem quantidade de vertices do grafo completo.
     */

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

    public boolean delAresta(int origem, int destino){
        
        return false;
    }

    public boolean delVertice(int idVertice){
        
        return false;
    }

    
}
