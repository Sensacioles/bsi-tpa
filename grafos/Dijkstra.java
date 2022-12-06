package grafos;
import java.util.ArrayList;
 
public class Dijkstra<Tipo extends Comparable>{ 
    ArrayList<Vertice>  vertices_cidades; // as informações das cidades são organizadas de acordo com 
    ArrayList<Vertice>  precedentes;      // o index do verices_cidades
    ArrayList distancia;
    public void montar_dijkstra(Grafo grafo, Vertice origem,Vertice destino){
        Vertice atual = origem;
        ArrayList<Aresta> lista_de_arestas= grafo.getarestas();
        ArrayList<Vertice>  lista_de_precedentes= new ArrayList<Vertice>();//colocar um valor inicial que indique que o predecessor n foi calculado 
        ArrayList<Float> estimativas= new ArrayList();for(int u =0;u<grafo.getvertices().size();u++){estimativas.add(u,(float) 99999.0000);lista_de_precedentes.add((Vertice)grafo.getvertices().get(u));}
        ArrayList<Vertice> fechados = new ArrayList();         
        ArrayList<Vertice> lista_de_vertices = grafo.getvertices();// lista de vertices do grafo    
        estimativas.set(lista_de_vertices.indexOf(atual),(float) 0 );
        lista_de_precedentes.set(lista_de_vertices.indexOf(atual),atual);
        fechados.add(atual);
         while( fechados.size()<= lista_de_vertices.size() ){
              for ( int i = 0 ; i<lista_de_arestas.size();i++){ //pecorrendo a lista de arestas para saber quais são as cidades vizinhas
                if((Vertice)lista_de_arestas.get(i).getOrigem()==atual && fechados.contains((Vertice)lista_de_arestas.get(i).getDestino())==false ){
                    //marcando os VERTICES QUE ESTÃO ABERTOS
                    //marcando as ESTIMATIVAS das distancias
                    //marcando os PRECEDENTES
                    //para a marcação ocorrer, os verteces tem que estar marcadas como abertos 
                    int index = lista_de_vertices.indexOf((Vertice)lista_de_arestas.get(i).getDestino() );
                    float custo = lista_de_arestas.get(i).getPeso()+(float )estimativas.get(lista_de_vertices.indexOf(atual)) ;
                     if (((Float)estimativas.get(index))>custo  ){  
                            estimativas.set(index,custo); // define os pesos de um vertice a outro       
                            lista_de_precedentes.set(index, atual); // define os precedentes dos "próximos" vertices
                         }}}
            // seleciona qual dos caminhos é mais curto 
            //e fecha para selecionar o próximo vertice a ser analizado
            float vertice_com_menor_estimativa=99999; 
            for (int k=0;k<lista_de_vertices.size();k++){
                if ( fechados.contains(lista_de_vertices.get(k))==false && vertice_com_menor_estimativa>(float)estimativas.get(k)){
                    atual=lista_de_vertices.get(k);
                     vertice_com_menor_estimativa=(float)estimativas.get(k); 
                }}
            fechados.add( atual);
        }   
            for(int i=0;i<lista_de_vertices.size();i++){
                System.out.println("CIDADE : "+((Cidade)lista_de_vertices.get(i).getValor()).getNome()+"   ESTIMATIVA  : "+estimativas.get(i)+"   PRECEDENTES  : "+(((Cidade)((Vertice)lista_de_precedentes.get(i)).getValor()).getNome()));
            }         
            this.vertices_cidades=grafo.getvertices();
            this.distancia=estimativas;
            this.precedentes=lista_de_precedentes;
            Vertice d = destino;
            System.out.print("CAMINHO: ");
            while(destino!=origem){
                     System.out.print(((Cidade)destino.getValor()).getNome()+"/");
                     destino= lista_de_precedentes.get(vertices_cidades.indexOf(destino));
            }
            System.out.println( ((Cidade)destino.getValor()).getNome());
            System.out.println("DISTANCIA: " + estimativas.get(lista_de_vertices.indexOf(d)));
        }
    }

            


       



            




        









         
    
       

