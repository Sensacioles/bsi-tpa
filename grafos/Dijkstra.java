package grafos;
import java.util.ArrayList;
 
public class Dijkstra<Tipo extends Comparable>{ 
    // As informações das cidades são organizadas de acordo com o index do verices_cidades
    ArrayList<Vertice> vertices_cidades; 
    ArrayList<Vertice> precedentes;      
    ArrayList distancia;
    public void montar_dijkstra(Grafo grafo, Vertice origem,Vertice destino){
        Vertice atual = origem;
        ArrayList<Aresta> lista_de_arestas= grafo.getarestas();
        ArrayList<Vertice> lista_de_vertices = grafo.getvertices();
        //Colocar um valor inicial que indique que o predecessor n foi calculado
        ArrayList<Vertice> lista_de_precedentes= new ArrayList<>();  
        ArrayList<Float> estimativas= new ArrayList<>();
        for(int u =0;u<grafo.getvertices().size();u++){ 
            //Estipula um peso alto para cada indice percorrido e
            //adiciona o vértice à lista de vértices percorrido no caminho 
            estimativas.add(u,(float) 99999.0000); 
            lista_de_precedentes.add((Vertice)grafo.getvertices().get(u)); 
        }
        ArrayList<Vertice> fechados = new ArrayList();         
        //Corrige o peso da origem para 0,
        //adiciona a origem no primeiro indice do caminho e
        //marca a origem como fechado ou já percorrido
        estimativas.set(lista_de_vertices.indexOf(atual),(float) 0 ); 
        lista_de_precedentes.set(lista_de_vertices.indexOf(atual),atual);
        fechados.add(atual);
        while(fechados.size()<=lista_de_vertices.size()){
            //Percorre a lista de arestas para saber quais são as cidades vizinhas
            for ( int i = 0 ; i<lista_de_arestas.size();i++){ 
                if((Vertice)lista_de_arestas.get(i).getOrigem()==atual && fechados.contains((Vertice)lista_de_arestas.get(i).getDestino())==false ){
                    //Marcando os VÉRTICES QUE ESTÃO ABERTOS,
                    //as ESTIMATIVAS das distâncias,
                    //e os VÉRTICES PRECEDENTES 
                    int index = lista_de_vertices.indexOf((Vertice)lista_de_arestas.get(i).getDestino());
                    float custo = lista_de_arestas.get(i).getPeso()+(float)estimativas.get(lista_de_vertices.indexOf(atual)) ;
                    if (((float)estimativas.get(index))>custo){  
                        //Define os pesos de um vértice a outro 
                        estimativas.set(index,custo);   
                        //Define os precedentes dos "próximos" vertices    
                        lista_de_precedentes.set(index, atual); 
                    }
                }
            }
            //Seleciona qual dos caminhos é mais curto 
            //fecha para selecionar o próximo vertice a ser analisado
            float vertice_com_menor_estimativa=99999; 
            for (int k=0;k<lista_de_vertices.size();k++){
                if(fechados.contains(lista_de_vertices.get(k))==false && vertice_com_menor_estimativa>(float)estimativas.get(k)){
                    atual=lista_de_vertices.get(k);
                    vertice_com_menor_estimativa=(float)estimativas.get(k); 
                }
            }
            fechados.add(atual);
        }   
        for(int i=0;i<lista_de_vertices.size();i++){
            System.out.println("CIDADE : "+((Cidade)lista_de_vertices.get(i).getValor()).getNome()+
            "   ESTIMATIVA  : "+estimativas.get(i)+"   PRECEDENTES  : "+
            (((Cidade)((Vertice)lista_de_precedentes.get(i)).getValor()).getNome()));
        }         
        this.vertices_cidades = grafo.getvertices();
        this.distancia = estimativas;
        this.precedentes = lista_de_precedentes;
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
            


       



            




        









         
    
       

