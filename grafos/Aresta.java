/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

public class Aresta <Tipo extends Comparable<Tipo>>{
    private Vertice origem,destino;
    private float peso;

    Aresta(){
        this.origem = null;
        this.destino = null;
        this.peso = 0;
    }
    public Vertice getOrigem(){
        return this.origem;
    }
    public Vertice getDestino(){
        return this.destino;
    }
    public float getPeso(){
        return this.peso;
    }
    public void setOrigem(Vertice o){
        this.origem = o;
    }
    public void setDestino(Vertice d){
        this.destino = d;
    }
    public void setPeso(float p){
        this.peso = p;
    }
}
