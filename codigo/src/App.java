
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner obj = new Scanner(System.in);
        GrafoNaoPonderado grafo_01;
        grafo_01 = new GrafoNaoPonderado("grafo_01");

        GrafoNaoPonderado grafo_deArquivo;
        grafo_deArquivo = new GrafoNaoPonderado("grafo_deArquivo");
        String opcao = "";

        opcao = menu();

        while (opcao != "F") {

            switch (opcao) {

                case "1":
                    System.out.println("CRIAR GRAFO COMPLETO\n Entre com a string identificadora do grafo:");
                //    nomeIdGrafo = obj.nextLine();
                    System.out.println("Entre com a ordem do grafo:");
                    int ordem = Integer.parseInt(obj.nextLine());

                //    grafo_01.GrafoNaoPonderado(nomeIdGrafo, ordem);

                    opcao = "";

                    break;
                case "2":
                    System.out.println("Ponderar arestas do grafo.");
                    System.out.println("Entre com a origem, o destino e o peso da aresta separarados por virgula:");
                    String dadosAresta = obj.nextLine();
                    String[] dadosDaAresta = dadosAresta.split(",");
                    int[] dadosDaArestaToInt = Arrays.stream(dadosDaAresta).mapToInt(Integer::parseInt).toArray();
                 //   grafo_01.ponderarArestas(dadosDaArestaToInt[0], dadosDaArestaToInt[1], dadosDaArestaToInt[2]);

                    opcao = "";

                    break;

                case "3":
                    System.out.println("Incluir arestas nos vertices.");
                    System.out.println("Incluir arestas\n Entre com a origem:");
                    int ori = obj.nextInt();
                    System.out.println("Incluir arestas\n Entre com a destino:");
                    int des = obj.nextInt();
                    // grafo_01.addAresta(ori, des);
                    opcao = "";

                    break;

                case "4":

                    System.out.println("Imprimir grafo");

                    // int tam = grafo_01.tamanho();
                 //   System.out.println(tam);

                    opcao = "";

                    break;

                case "5":
                String localPadraoSalvar = "C:/Grafos/grafo_Salvo.csv";
                System.out.println("SALVAR GRAFO DE ARQUIVO:\n");
                System.out.println(
                        "Entre com o local para salvar o grafo ou 'ENTER' para salvar em 'C:\\Grafos\\grafo_salvo.csv':");
               if (obj.nextLine() != "") {
                    localPadraoSalvar = obj.nextLine();
                }

                    System.out.println("Salvando grafo em 'grafo_Salvar.csv'");
                    grafo_deArquivo.salvar(localPadraoSalvar);
                    opcao = "";

                    break;
                case "6":
                    String localPadraoCarregar = "C:/Grafos/grafo_Carregar.csv";
                    System.out.println("CARREGAR GRAFO DE ARQUIVO:\n Entre com a string identificadora do grafo:");
                    String nomeIdGrafo = obj.nextLine();
                    System.out.println(
                            "Entre com o local para carregar o grafo ou 'ENTER' para carregar de 'C:/Grafos/grafo_Carregar.csv':");
                   if (obj.nextLine() != "") {
                       localPadraoSalvar = obj.nextLine();
                    }


                    System.out.println("Carregando grafo " + nomeIdGrafo + " em: " + localPadraoCarregar);
                    grafo_deArquivo.carregar(localPadraoCarregar);
                    opcao = "";
                    break;
                case "F":

                    System.out.println("teste");
                    // nomeIdGrafo..salvar("C:/Grafos/grafo_01.csv");
                    // nomeIdGrafo.carregar("C:/Grafos/grafo_01.csv");

                    System.out.println("Finalizado!");
                    opcao = "";
                    break;
                // default:
                // System.out.println("opção invalida!");

            }
            opcao = menu();

        }
        obj.close();
    }

    public static String menu() {
        Scanner obj = new Scanner(System.in);
        System.out.println("GRAFO NÃO DIRECIONADO:\n");
        System.out.println("1 - Criar grafo completo.");
        System.out.println("2 - Retornar a ordem e o tamanho do grafo.");
        System.out.println("3 - Ponderar arestas do grafo.");
        System.out.println("4 - Gerar subgrafo.");
        System.out.println("5 - Salvar grafo.");
        System.out.println("6 - Carregar grafo.");
        System.out.println("Entre com o número correspondente à função do grafo para teste:");
        return obj.nextLine().toUpperCase();

    }

}
