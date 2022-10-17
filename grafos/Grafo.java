/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package Grafos;

import java.util.ArrayList;
import Grafos.Vertice.*;

public class Grafo<Tipo extends Comparable>{
    private float arestas[][];
    private ArrayList<Vertice<Tipo>> vertices;
    int qArestas;
    
    Grafo(int q){
        this.arestas = new float[q][q];
        this.vertices = new ArrayList<Vertice<Tipo>>();
        this.qArestas = q;
    }
    
}

