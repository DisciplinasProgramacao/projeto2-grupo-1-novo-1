
import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner obj = new Scanner(System.in);
        GrafoNaoPonderado grafo_01;
        grafo_01 = new GrafoNaoPonderado("grafo_01");

        String opcao = "";

        opcao = menu();

        while (opcao != "F") {

            switch (opcao) {

                case "1":
                    String localPadraoSalvar = "C:/Grafos/grafo_salvo.csv";
                    System.out.println("SALVAR GRAFO DE ARQUIVO:\n");
                    System.out.println("Salvando grafo em 'grafo_Salvo.csv'");
                    grafo_01.salvar(localPadraoSalvar);
                    opcao = "";

                    break;
                case "2":
                    String localPadraoCarregar = "C:/Grafos/grafo_01.csv";
                    System.out.println("CARREGAR GRAFO DE ARQUIVO:\n Entre com a string identificadora do grafo:");
                    String nomeIdGrafo = obj.nextLine();
                    System.out.println("Carregando grafo " + nomeIdGrafo + " em: " + localPadraoCarregar);
                    grafo_01.carregar(localPadraoCarregar);
                    opcao = "";
                    break;

                case "3":
                    System.out.println("SABER A ORDEM E O TAMNAHO DO GRAFO:\n");

                    System.out.println("A ordem do grafo é: " + grafo_01.ordem());
                    System.out.println("o tamanho do grafo é: " + grafo_01.tamanho());

                    opcao = "";

                    break;

                case "4":

                    System.out.println("VERIFICAR A EXISTÊNCIA DE UMA ARESTA:\n");

                    System.out.println("Entre com a origem da aresta:");
                    int origemEntrada = obj.nextInt();
                    System.out.println("Entre com o destino da aresta:");
                    int destinoEntrada = obj.nextInt();

                    Aresta resp = grafo_01.existeAresta(origemEntrada, destinoEntrada);
                    System.out.println("A aresta " + origemEntrada + " - " + destinoEntrada + resp.toString());

                    opcao = "";

                    break;
                case "5":

                    System.out.println("GERAR UM GRAFO COMPLETO\n");
                    System.out.println("Entre com a string identificadora do grafo:\n");
                    String nomeGrafo = obj.nextLine();
                    System.out.println("Entre com a ordem do grafo completo a ser gerado:\n");
                    int ordemEntrada = obj.nextInt();

                    GrafoCompleto grafoCompleto = new GrafoCompleto(nomeGrafo, ordemEntrada);

                    opcao = "";

                    break;
                case "6":

                    System.out.println("GERAR UM SUBGRAFO DE UM GRAFO:\n");

                    // Grafo subgrafo =

                    opcao = "";

                    break;
                case "7":

                    System.out.println("PERMITIR A CRIAÇÃO DE ARESTAS PONDRADAS:\n");

                    // int tam = grafo_01.tamanho();
                    // System.out.println(tam);

                    opcao = "";

                    break;

                case "8":

                    System.out.println("REALIZAR UMA BUSCA EM PROFUNDIDADE:\n");

                    // int tam = grafo_01.tamanho();
                    // System.out.println(tam);

                    opcao = "";

                    break;

                case "9":

                    System.out.println("ENCONTAR UM CAMINHO ENTRE DOIS VÉRTICES:\n");

                    // int tam = grafo_01.tamanho();
                    // System.out.println(tam);

                    opcao = "";

                    break;

                case "10":

                    System.out.println("DETERMINAR UM CAMINHO EULERIANO:\n");

                    // int tam = grafo_01.tamanho();
                    // System.out.println(tam);

                    opcao = "";

                    break;

                case "11":

                    System.out.println("IMPLEMENTAR GRAFOS DIRECIONADOS:\n");

                    // int tam = grafo_01.tamanho();
                    // System.out.println(tam);

                    opcao = "";

                    break;

                case "F":

                    System.out.println("Finalizado!");
                    opcao = "";
                    break;
                default:
                    System.out.println("opção invalida!");

            }
            opcao = menu();

        }
        obj.close();
    }

    public static String menu() {
        Scanner obj = new Scanner(System.in);
        System.out.println("GRAFO NÃO DIRECIONADO:\n");
        System.out.println("1 -  Salvar grafo em arquivo:");
        System.out.println("2 -  Carregar grafo de arquivo.");
        System.out.println("3 -  Saber a ordem e o tamamho do grafo.");
        System.out.println("4 -  Verificar a existência de uma aresta");
        System.out.println("5 -  Gerar um grafo completo.");
        System.out.println("6 -  Gerar um subgrafo de um grafo");
        System.out.println("7 -  Permitir a criação de arestas ponderadas");
        System.out.println("8 -  Realizar uma busca em profundidade.");
        System.out.println("9 -  Encontrar um caminho entre dois vértices.");
        System.out.println("10 - Determinar um caminho euleriano.");
        System.out.println("11 - Implementar grafo direcionado");
        System.out.println("Entre com o número correspondente à função do grafo para teste ou 'f' para finalizar:\n");
        return obj.nextLine().toUpperCase();

    }

}
