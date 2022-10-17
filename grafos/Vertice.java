/**@author Emanuel Norjosa Luz e Giovanni Sencioles */
package Grafos;
//Biblioteca de vertices 

import java.util.ArrayList;

public class Vertice<Tipo extends Comparable>{
    private Tipo valor; //Alocacao generica de cidade
    
    Vertice(Tipo cidade){
        this.valor = cidade;
    }
    public Tipo getValor(){
        return this.valor;
    }
    public void setValor(Tipo c){
        this.valor = c;
    }
}