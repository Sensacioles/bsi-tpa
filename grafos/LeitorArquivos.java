package grafos;

import grafos.Vertice;   
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

 public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
    Grafo matriz =new Grafo() ;
     public Grafo<Tipo> ler(String string) throws IOException{
        
        
        ArrayList<Aresta> lista_de_arestas = new ArrayList<Aresta>();
        
        ArrayList<Vertice> lista_de_Vertices = new ArrayList<Vertice>();
        long tempoInicial = System.currentTimeMillis();
        String linha = ""; 
        BufferedReader buffRead =new BufferedReader(new FileReader(string));
        linha = buffRead.readLine();
        int numero_de_casos = Integer.parseInt(linha);
         String[] obj;

        // Percorre as linhas do arquivo txt responsáveis por indicar o código e o nome da cidade
        for (int i=0;i <=numero_de_casos-1;i++){
            linha = buffRead.readLine();
            obj = linha.split(";");
            Cidade cidade=new Cidade();
            cidade.setCodigo(Integer.parseInt(obj[0]));
            cidade.setNome( obj[1]);
            Vertice vertice= new Vertice();

            vertice.setValor(cidade);
            lista_de_Vertices.add(vertice);
        }
   
        /* loop que converte matriz de arestas do arquivo txt em grafo*/
 
        for (int linhas_da_matriz = 0;linhas_da_matriz <=numero_de_casos-1;linhas_da_matriz++){
            linha = buffRead.readLine();
            obj = linha.split(";");


            for (int coluna_da_matriz=0;coluna_da_matriz<=obj.length-1;coluna_da_matriz++){
                if (Float.parseFloat((obj[coluna_da_matriz]).replace(",", "."))!=0){
                Aresta aresta = new Aresta();
                aresta.setOrigem(lista_de_Vertices.get(linhas_da_matriz));
                aresta.setDestino(lista_de_Vertices.get(coluna_da_matriz));
                aresta.setPeso(Float.parseFloat((obj[coluna_da_matriz]).replace(",", ".")));                
                lista_de_arestas.add(aresta);
            }
        }


            
             
         }
              
         
        this.matriz.setarestas(lista_de_arestas);
        this.matriz.setvertices(lista_de_Vertices);
        this.matriz.setqArestas(numero_de_casos);
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("O método foi executado em " +tempo+" ms");
        System.out.println(this.matriz);
         
        return  this.matriz;
    }

  
}


