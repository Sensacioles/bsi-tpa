/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

public class Aresta <Tipo extends Comparable<Tipo>>{
    private Vertice<Tipo> origem,destino;
    private float peso;

    Aresta(Vertice<Tipo> o, Vertice<Tipo> d, float p){
        this.origem = o;
        this.destino = d;
        this.peso = p;
    }
    public Vertice<Tipo> getOrigem(){
        return this.origem;
    }
    public Vertice<Tipo> getDestino(){
        return this.destino;
    }
    public float getPeso(){
        return this.peso;
    }
    public void setOrigem(Vertice<Tipo> o){
        this.origem = o;
    }
    public void setDestino(Vertice<Tipo> d){
        this.destino = d;
    }
    public void setPeso(float p){
        this.peso = p;
    }
}
