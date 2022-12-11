
package grafos;
import grafos.Vertice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class main <Tipo extends Comparable<Tipo>>{
    static Grafo grafo;
 	public static void main(String[] args) {
        
        Scanner nome_cidade = new Scanner(System.in);
        Scanner menu_s = new Scanner(System.in);
        Scanner ori = new Scanner(System.in);
        Scanner des = new Scanner(System.in);
        int menu = 0;
        LeitorArquivos leitor = new LeitorArquivos();
       
        try{
        grafo = leitor.ler("grafos\\entrada.txt") ;}
        catch (IOException e) {
        e.printStackTrace();}
        while(menu!=99){
            System.out.println(
                "i.  Obter cidades vizinhas: digite 1 \n"+
                "ii.  Obter todos os caminhos a partir de uma cidade: digite 2\n"+
                "iii Calcular caminho mínimo: digite 3\n"+
                "iv Calcular árvore geradora mínima: digite 4\n"+
                "v Calcular fluxo maximo: digite 5\n"+
                "vi.  Sair: digite 99"
            );
            menu = menu_s.nextInt();
            
            if(menu==1){ 
                System.out.println("digite o codigo da cidade que quer consultar :");
                int codigo_da_cidade = nome_cidade.nextInt();
                int l = grafo.getvertices().size();
                Vertice   v =null;
                for(int i=0;i<l;i++){
                    Vertice  v_aux=(Vertice)grafo.getvertices().get(i);
                    Cidade aux =(Cidade) (v_aux.getValor());

                     if(aux.getCodigo()==codigo_da_cidade){
                            v = (Vertice) grafo.getvertices().get(i);
                            System.out.println("cidade celecionada == "+ aux.getNome());
                            break;
                    }
                }
            
 

                if (v ==null){
                    System.out.println("CIDADE NÃO LISTADA");
                }else{
                    ArrayList<Aresta> cidades_vizinhas= new ArrayList<Aresta>();
                        for(int i=0;i<grafo.getarestas().size();i++){
                           if (((Aresta) grafo.getarestas().get(i)).getOrigem()==v){
                             
                            cidades_vizinhas.add((Aresta) grafo.getarestas().get(i));

                            }}
                    System.out.println("CODIGO DA CIDADE VIZINHA ;NOME DA CIDADE VIZINHA ; DISTANCIA DA ORIGEM "); 
                    for(int i=0;i<cidades_vizinhas.size();i++){
                         if (cidades_vizinhas.get(i).getPeso()!=0){System.out.println(
                    
                        ( (Cidade) ((cidades_vizinhas.get(i)).getDestino().getValor())).getCodigo()+"  -----  "+
                        ( (Cidade) ((cidades_vizinhas.get(i)).getDestino().getValor())).getNome()+"  -----  "+
                        (cidades_vizinhas.get(i)).getPeso()+"\n"); }
                    }
                
 
                }
                
            }
            
                else if (menu==2){
                    ArrayList<Cidade> cidades = new ArrayList<Cidade>();
                    ArrayList num_cidades= new ArrayList<>();
                    for (int i =0;i<grafo.getvertices().size();i++){
                        cidades.add(((Cidade)((Vertice)grafo.getvertices().get(i)).getValor()));
                        num_cidades.add(cidades.get(i).getCodigo());    
                    }
                    int origem;
                    
                    System.out.println("Cod da cidade origem:");
                    origem=ori.nextInt();
                    
                    while(num_cidades.contains(origem)==false){
                        System.out.println("codigo para cidade origem não é valido");
                        System.out.println("Cod da cidade origem:");
                        origem=ori.nextInt();
                    } 
                    Vertice v_origem=(Vertice)grafo.getvertices().get(num_cidades.indexOf(origem));
                    grafo.lista_de_caminhos(v_origem);



                }
               

                else if(menu==3){
                    ArrayList<Cidade> cidades = new ArrayList<Cidade>();
                    ArrayList num_cidades= new ArrayList<>();
                    for (int i =0;i<grafo.getvertices().size();i++){
                        cidades.add(((Cidade)((Vertice)grafo.getvertices().get(i)).getValor()));
                        num_cidades.add(cidades.get(i).getCodigo());    
                    }
                    int origem,destino;
                    
                    System.out.println("Cod da cidade origem:");
                    origem=ori.nextInt();
                    
                    while(num_cidades.contains(origem)==false){
                        System.out.println("codigo para cidade origem não é valido");
                        System.out.println("Cod da cidade origem:");
                        origem=ori.nextInt();
                    }
                    System.out.println("Cod da cidade destino:");
                    destino=des.nextInt();
                    while(num_cidades.contains(destino)==false){
                        System.out.println("codigo para cidade destino não é valido");
                        System.out.println("Cod da cidade destino:");
                        destino=ori.nextInt();
                    }
                    Vertice v_origem=(Vertice)grafo.getvertices().get(num_cidades.indexOf(origem));
                    Vertice v_destino=(Vertice)grafo.getvertices().get(num_cidades.indexOf(destino));
                     
                    Dijkstra d= new Dijkstra();
                    d.montar_dijkstra(grafo, v_origem,v_destino);
                    
                }
                else if(menu==4){
                    grafo.prim();
                } 
                else if(menu==5){
                    
                    


                    ArrayList<Cidade> cidades = new ArrayList<Cidade>();
                    ArrayList num_cidades= new ArrayList<>();
                    for (int i =0;i<grafo.getvertices().size();i++){
                        cidades.add(((Cidade)((Vertice)grafo.getvertices().get(i)).getValor()));
                        num_cidades.add(cidades.get(i).getCodigo());    
                    }
                    int origem,destino;
                    
                    System.out.println("Cod da cidade origem:");
                    origem=ori.nextInt();
                    
                    while(num_cidades.contains(origem)==false){
                        System.out.println("codigo para cidade origem não é valido");
                        System.out.println("Cod da cidade origem:");
                        origem=ori.nextInt();
                    }
                    System.out.println("Cod da cidade destino:");
                    destino=des.nextInt();
                    while(num_cidades.contains(destino)==false){
                        System.out.println("codigo para cidade destino não é valido");
                        System.out.println("Cod da cidade destino:");
                        destino=ori.nextInt();
                    }
                    Vertice v_origem=(Vertice)grafo.getvertices().get(num_cidades.indexOf(origem));
                    Vertice v_destino=(Vertice)grafo.getvertices().get(num_cidades.indexOf(destino));
                    System.out.println(((Cidade)v_origem.getValor()).getNome()+" ----- "+((Cidade)v_destino.getValor()).getNome());
                    grafo.fmaximo(v_origem,v_destino);
                }
                else if(menu==99){}
                else{ 
                    System.out.println("DADO DE ENTRADA INVALIDO ");}
            
            
             }
            menu_s.close();
            nome_cidade.close();
            ori.close();
            des.close();
          
    } 
}



