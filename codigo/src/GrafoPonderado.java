import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
     * Override para carregar grafo ponderado no arquivo
     */
    @Override
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
     * Override para cria subgrafo ponderado com os vertices passados por parametro.
     * @param vertices lista de vertices para criação do subgrafo.
     */
    @Override
    public GrafoPonderado subGrafo(Lista<Vertice> vertices){
        Vertice verticesArray[] = new Vertice[this.ordem()];
        verticesArray = vertices.allElements(verticesArray);
        int naoNull = 0;
        for(int i = 0; i < this.ordem(); i++){
            if(verticesArray[i] != null){
                naoNull++;
            }
        }
        if(naoNull <= this.ordem() && naoNull > 0){
            return new GrafoPonderado("Subgrafo de " + this.nome);
        } else return null;
    }

}
