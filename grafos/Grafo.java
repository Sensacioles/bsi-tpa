/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

import java.util.ArrayList;

public class Grafo<Tipo extends Comparable<Tipo>>{
    private ArrayList<Aresta<Tipo>> arestas;
    private ArrayList<Vertice<Tipo>> vertices;
    private int qArestas;
    
    Grafo(){
        this.arestas = new ArrayList<Aresta<Tipo>>();
        this.vertices = new ArrayList<Vertice<Tipo>>();
    }

    public ArrayList<Aresta<Tipo>> getarestas(){
        return this.arestas;
    }
    public void setarestas(ArrayList<Aresta<Tipo>> A){
        this.arestas=A;
    }
    public ArrayList<Vertice<Tipo>> getvertices(){
        return this.vertices;
    }
    public void setvertices(ArrayList<Vertice<Tipo>> A){
        this.vertices= A;
    }
    public int getqArestas(){
        return this.qArestas;
    }
    public void setqArestas(int A){
        this.qArestas=A;
    }
    public ArrayList<Aresta<Tipo>> arestas_da_origem(Vertice vertice){

         ArrayList<Aresta<Tipo>> vizinhas= new ArrayList<Aresta<Tipo>>();
   
         for(int i=0;i==this.arestas.size();i++){
            if ((this.arestas.get(i)).getOrigem()==vertice){
                vizinhas.add((this.arestas.get(i)));
            }
        }
        return vizinhas; 
    }

    public void prim(){
        ArrayList<Vertice<Tipo>> v_vertices= new ArrayList<>();
        ArrayList<Aresta<Tipo>> v_aretas= new ArrayList<>();
        Vertice<Tipo> v_atual= this.vertices.get(0);
        Aresta<Tipo> a_atual= this.arestas.get(0);
        // Marca origem como visitado, adicionando-o no vetor de vértices 
        v_vertices.add(v_atual); 
        while(this.vertices.size() > v_vertices.size()){
            double f_aux= 999999.9;
            for(int i =0; i<this.arestas.size();i++){
                //Caso seja menor peso e
                //o vetor tenha a origem visitada e
                //o vetor não tenha o destino não visitado
                if(this.arestas.get(i).getPeso()<f_aux && v_vertices.contains(this.arestas.get(i).getOrigem())==true && v_vertices.contains(this.arestas.get(i).getDestino())==false){
                    //O peso dessa aresta passa a ser o menor,
                    //o vértice atual é definido como destino e
                    //a aresta é marcada como visitada
                    f_aux = this.arestas.get(i).getPeso();
                    v_atual=this.arestas.get(i).getDestino();
                    a_atual=this.arestas.get(i);
                }
                //Caso o vetor de vértices ainda não possua o último vértice a ser visitado
                if(v_vertices.contains(v_atual)==false){
                    //Adiciona ele ao vetor e
                    //o peso da aresta ao vetor de arestas
                    v_vertices.add(v_atual);
                    v_aretas.add(a_atual);
                    System.out.println("origem:"+((Cidade)a_atual.getOrigem().getValor()).getNome()+
                    "     destino:"+((Cidade)a_atual.getDestino().getValor()).getNome()+
                    "   peso:"+a_atual.getPeso());
                }
            }
        }
    }
}