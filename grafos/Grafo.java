/** @author Emanuel Norjosa Luz e Giovanni Sencioles */
package grafos;

import java.util.ArrayList;
 

public class Grafo<Tipo extends Comparable<Tipo>>{
    private ArrayList<Aresta<Tipo>>  arestas ;
    private ArrayList<Vertice<Tipo>> vertices;
    private int qArestas;
    
    Grafo( ){
        this.arestas = new ArrayList<Aresta<Tipo>>();
        this.vertices = new ArrayList<Vertice<Tipo>>();
     }
  


    
    public ArrayList<Aresta<Tipo>> getarestas(){
        return this.arestas;
    }
    public void setarestas(ArrayList<Aresta<Tipo>> A)
    {
            this.arestas=A;
    }
    public ArrayList<Vertice<Tipo>> getvertices(){
        return this.vertices;
    }
    public void setvertices(ArrayList<Vertice<Tipo>> A)
    {
         this.vertices= A;
    }
    public int getqArestas(){
        return this.qArestas;
    }
    public void setqArestas(int A)
    {
         this.qArestas=A;
    }
 
    public ArrayList<Aresta<Tipo>>  arestas_da_origem(Vertice vertice){
        ArrayList<Aresta<Tipo>> vizinhas= new ArrayList<Aresta<Tipo>>();
        for(int i=0;i==this.arestas.size();i++){
            if ((this.arestas.get(i)).getOrigem()==vertice){
                vizinhas.add((this.arestas.get(i)))   
            }
        }
        return vizinhas; 
    }

    public void prim(){
        ArrayList v_vertices= new ArrayList<>();
        ArrayList v_aretas= new ArrayList<>();
        Vertice v_atual= this.vertices.get(0);
        Aresta a_atual= this.arestas.get(0);
        float soma= 0; 
        v_vertices.add(v_atual); // lista de vertices visitados 
        while(this.vertices.size() > v_vertices.size()){
            float f_aux=(float) 999999;
            for(int i =0; i<this.arestas.size();i++){
                if(this.arestas.get(i).getPeso()<f_aux &&    //Caso o peso seja menor que o peso que o menor fluxo
                   v_vertices.contains(this.arestas.get(i).getOrigem())==true &&    //e o vetor de vertices possua a origem do vertice atual
                   v_vertices.contains(this.arestas.get(i).getDestino())==false){   //mas ainda nao possua seu destino
                        f_aux = this.arestas.get(i).getPeso();    //Menor peso atualizado
                        v_atual=this.arestas.get(i).getDestino();    //Passa o vertice atual para o vertice vizinho
                        a_atual=this.arestas.get(i);    //Atualiza o peso atual
                    
                }
            }
            if(v_vertices.contains(v_atual)==false) {    //Caso o vetor nao possua o ultimo vertice
                soma=soma+f_aux;    //Atualiza a soma com o fluxo mínimo encontrado
                v_vertices.add(v_atual);    //Vetor recebe o ultimo vertice
                v_aretas.add(a_atual);    //Vetor de arestas recebe o peso atual
                System.out.println("origem:"+((Cidade)a_atual.getOrigem().getValor()).getNome()+"     destino:"+((Cidade)a_atual.getDestino().getValor()).getNome()+"   peso:"+a_atual.getPeso());
            }
        }
        System.out.println("soma total dos pesos: " +soma);
    }

    public double fmaximo(Vertice origem, Vertice destino){
        ArrayList<Aresta<Tipo>>  lista_de_arestas =this.arestas;
        ArrayList caminho = new ArrayList() ;
        //float fmax = 0;
        float fluxo_atual=9999999;
        Vertice atual = origem;
        ArrayList<Vertice<Tipo>> passados = new ArrayList<Vertice<Tipo>> ();
        while(atual!= destino){    //Caminhar o grafo até chegar ao destino
            for (int j =0;j<lista_de_arestas.size();j++){
                if ((lista_de_arestas.get(j).getOrigem()==atual) &&    //Caso vertice atual esteja no comeco de dado caminho 
                    (lista_de_arestas.get(j).getPeso()>0) &&    //e estar incluso em um arco positivo
                    passados.contains(lista_de_arestas.get(j).getDestino())==false){    //e o caminho para o vizinho nao tenha sido percorrido
                        caminho.add(j);    //Adiciona o indice do atual ao caminho
                        atual=lista_de_arestas.get(j).getDestino();    //Atual recebe o vizinho
                        System.out.println(((Cidade)atual.getValor()).getNome());
                        passados.add(lista_de_arestas.get(j).getDestino());    //Novo atual incluso na lista de percorridos
                        if(fluxo_atual>lista_de_arestas.get(j).getPeso()){
                            fluxo_atual=lista_de_arestas.get(j).getPeso();    //Fluxo maximo atualizado com o peso do arco
                        }
                        //fmax=fluxo_atual;
                }
            }
        }        
        /*for (int i =0;i<caminho.size();i++){
            System.out.print(lista_de_arestas.get((int) caminho.get(i)).getPeso()+" === ");
            lista_de_arestas.get((int) caminho.get(i)).setPeso(lista_de_arestas.get((int) caminho.get(i)).getPeso()-fluxo_atual);
            System.out.println(lista_de_arestas.get((int) caminho.get(i)).getPeso());
        }*/

        return fluxo_atual; 
    }
    
    public void fordFulkerson(){
        ArrayList pais = new ArrayList<>();
        ArrayList caminho = new ArrayList<>();
        Vertice atual = this.getvertices().get(0);
        double fmax = 0;

        caminho.add(atual);    //Comeca adicionando a origem ao caminho a ser percorrido
        //pais.set(0, -1);    //Coloca pai da origem como inexistente 

        //Busca em largura pelo elemento destino
        for(int i=0;i<this.getvertices().size();i++){
            atual = this.getarestas().get(i).getDestino();
            if(caminho.contains(atual) == false && this.getarestas().get(i).getPeso() > 0){    //Checa se o vertice nao foi visitado e se ha aresta entre o atual e destino
                if(this.getarestas().get(i).getDestino() == null){
                    fmax=fmaximo(this.getvertices().get(0), this.getvertices().get(i-1));
                    //pais.set((int)caminho.get(i),atual);    //Adiciona o destino como pai do penúltimo vértice
                }
                caminho.add(atual);    //Adiciona ao fim da lista
                pais.set(i+1,atual);    //Adiciona o percorrido a lista de pais
            }
        }
/*
        for(int i=0;i<caminho.size();i++){
            System.out.print(((Cidade)atual.getValor()).getNome());
        }*/
        System.out.printf("Fluxo maximo: %.2f",fmax);
    }
}