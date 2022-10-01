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

public class Vertice {
    
    private ABB<Aresta> arestas;    
    private final int  id;
    private boolean visitado;

/**
     * Construtor para criação de vértice identificado
     * @param id Número/id do vértice a ser criado (atributo final).
     */
    public Vertice(int id){
        this.id = id;
        this.arestas = new ABB<Aresta>();
        this.visitado = false;
    }
    
/**
     * Adiciona uma aresta neste vértice para um destino
     * @param peso Peso da aresta (0 para grafos não ponderados)
     * @param destino Vértice de destino
     * @return TRUE quando a aresta for adicionada
     */
    public boolean addAresta(int destino){
        return this.arestas.add(destino,new Aresta(0, destino));
    }


    /**
     * Adiciona uma aresta neste vértice para um destino
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE quando a aresta for adicionada
     */
    public boolean addAresta(int destino, int peso){
        return this.arestas.add(destino,new Aresta(peso, destino));
    }

    /**
     * Verifica se já existe aresta entre este vértice e um destino. Método privado
     * @param destino Vértice de destino
     * @return TRUE se existe aresta, FALSE se não
     */
    public Aresta existeAresta(int destino){
        return this.arestas.find(destino);

    }
    
    /**
     * Retorna o grau do vértice
     * @return Grau (inteiro não negativo)
     */
    public int grau(){
        return this.arestas.size();
    }

    public void visitar(){
        this.visitado = true;
    }
    
    public void limparVisita(){
        this.visitado = false;
    }
    
    public boolean visitado(){
        return this.visitado;
    }
}
