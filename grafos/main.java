
package grafos;
import grafos.Grafo;
import grafos.Vertice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import grafos.Cidade;
public class main<Tipo extends Comparable<Tipo>>{
    static Grafo grafo;
 	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Scanner nome_cidade = new Scanner(System.in);
         
        int menu = 0;
        LeitorArquivos leitor = new LeitorArquivos();
       
        try{
        grafo = leitor.ler("entrada.txt") ;}
        catch (IOException e) {
        e.printStackTrace();}
        while(menu!=99){
            System.out.println(
                "i.  Obter cidades vizinhas: digite 1 \n"+
                "ii.  Obter todos os caminhos a partir de uma cidade digite 2\n"+
                "iii.  Sair: digite 99"
            );
            menu =scanner.nextInt();
            if(menu==1){ 
                System.out.println("digite o codigo da cidade que quer consultar :");
                int codigo_da_cidade = nome_cidade.nextInt();
                 int l = grafo.getVertices().size();
                Vertice v = null;
                for(int i=0;i<l;i++){
                    Vertice v_aux=(Vertice)grafo.getVertices().get(i);
                    Cidade aux =(Cidade) (v_aux.getValor());

                     if(aux.getCodigo()==codigo_da_cidade){
                            v = (Vertice) grafo.getVertices().get(i);
                            System.out.println("cidade celecionada == "+ aux.getNome());
                            break;
                    }
                }
            
 

                if (v ==null){
                    System.out.println("CIDADE NÃO LISTADA");
                }else{
                    ArrayList<Aresta> cidades_vizinhas= new ArrayList<Aresta>();
                        for(int i=0;i<grafo.getArestas().size();i++){
                           if (((Aresta) grafo.getArestas().get(i)).getOrigem()==v){
                             
                            cidades_vizinhas.add((Aresta) grafo.getArestas().get(i));

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
                    //Incompleto
                }
                else if(menu==99){}
                else{ 
                    System.out.println("DADO DE ENTRADA INVALIDO ");}
            }
            nome_cidade.close();
          
    } 
}



