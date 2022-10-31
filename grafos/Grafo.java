/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

import java.util.ArrayList;

public class Grafo<Tipo extends Comparable<Tipo>>{
    private ArrayList<Aresta<Tipo>> arestas;
    private ArrayList<Vertice<Tipo>> vertices;
    private int qArestas;
    
    Grafo(ArrayList<Aresta<Tipo>> a, ArrayList<Vertice<Tipo>> v, int q){
        this.arestas = a;
        this.vertices = v;
        this.qArestas = q;
    }
    public ArrayList<Aresta<Tipo>> getArestas(){
        return this.arestas;
    }
    public ArrayList<Vertice<Tipo>> getVertices(){
        return this.vertices;
    }
    public int getqArestas(){
        return this.qArestas;
    }
    public Vertice<Tipo> addVertice(Tipo valor){
        Vertice<Tipo> novo = new Vertice<Tipo>(valor);  //Instancia um novo vertice
        this.vertices.add(novo);    //Adiciona ele a lista de vertices
        return novo;    //Retorna ele para ser utilizado na busca dentro do método de adicionar aresta
    }       
    public Vertice<Tipo> getVertice(Tipo valor){
        Vertice<Tipo> comp;
        for(int i=0;i<this.vertices.size();i++){
            comp = this.vertices.get(i);    //Armazena o vertice i
            if(comp.getValor().equals(valor)){  //Compara com o valor passado
                return comp;    //Caso igual retorna i
            }
        }
        return null;    //Caso nao, vertice com o valor nao existe
    }
    public void addAresta(Tipo o, Tipo d, float p){
        Vertice<Tipo> origem,destino;
        origem = getVertice(o); 
        destino = getVertice(d);
        //Sao checados caso origem e/ou destino são nulos
        //Caso sejam, sao criados e retornados para serem adicionados a aresta
        if(origem == null){
            origem = addVertice(o);
        }
        if(destino == null){
            destino = addVertice(d);
        }
        //Nova aresta criada com valores de origem, destino e peso, adicionada a lista
        Aresta<Tipo> nova = new Aresta<Tipo>(origem, destino, p);
        this.arestas.add(nova); 
    }
    private ArrayList<Aresta<Tipo>> getListDestinos(Vertice<Tipo> v){
        ArrayList<Aresta<Tipo>> lstDestinos = new ArrayList<Aresta<Tipo>>();    //Instancia lista de destinos
        Aresta<Tipo> atual;
        for(int i=0;i<this.arestas.size();i++){ //Percorre a lista de arestas
            atual = this.arestas.get(i);
            if(atual.getOrigem().equals(v)){
                lstDestinos.add(atual); //Adiciona i na lista de destinos
            }
        }
        return lstDestinos;
    }
    public void buscaLargura(){
        ArrayList<Vertice<Tipo>> prox = new ArrayList<Vertice<Tipo>>();
        ArrayList<Vertice<Tipo>> perc = new ArrayList<Vertice<Tipo>>();
        Vertice<Tipo> atual = this.vertices.get(0);
        prox.add(atual);
        while(prox.size()>0){
            atual = prox.get(0);
            prox.remove(0);
            perc.add(atual);
            ArrayList<Aresta<Tipo>> dest = this.getListDestinos(atual);
            Vertice<Tipo> aux;
            for(int i=0;i<dest.size();i++){
                aux = dest.get(i).getDestino();
                if(!perc.contains(aux)){
                    prox.add(aux);
                }
            }
        }
    }
}