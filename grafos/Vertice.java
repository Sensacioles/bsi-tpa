/**@author Emanuel Norjosa Luz e Giovanni Sencioles */

//Biblioteca de vertices 
public class Vertice<Tipo>{
    private Tipo codigo; //Codigo da cidade
    private Tipo nome; //Nome da cidade
    private ArrayList<Aresta> distancia;  /*Lista de distancias, cada indice representa
    a distancia para cada cidade da matriz, o indice 0 sendo a propria cidade*/
    
    Vertice(Tipo c, Tipo n){
        this.codigo = c;
        this.nome = n;
        this.distancia[0] = 0;
    }
    public Tipo getCodigo(){
        return this.codigo;
    }
    public Tipo getNome(){
        return this.nome;
    }
    public void setCodigo(Tipo c){
        this.codigo = c;
    }
    public void setNome(Tipo n){
        this.nome = n;
    }
}