package grafos;

//import grafos.Grafo;
//import grafos.Aresta;
//import grafos.Vertice;   
import java.io.BufferedReader;
//import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.file.Path;
import java.util.ArrayList;

 public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
     public Grafo<Tipo> ler(String string) throws IOException{
        
        ArrayList<Aresta<Tipo>> lista_de_arestas = new ArrayList<Aresta<Tipo>>();
        ArrayList<Vertice<Tipo>> lista_de_Vertices = new ArrayList<Vertice<Tipo>>();
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
            Cidade cidade = new Cidade(Integer.parseInt(obj[0]), obj[1]);
            Vertice<Tipo> vertice= new Vertice<Tipo>((Tipo)cidade);
            lista_de_Vertices.add(vertice);
        }
   
        /* loop que converte matriz de arestas do arquivo txt em grafo*/
 
        for (int linhas_da_matriz = 0;linhas_da_matriz <=numero_de_casos-1;linhas_da_matriz++){
            linha = buffRead.readLine();
            obj = linha.split(";");


            for (int coluna_da_matriz=0;coluna_da_matriz<=obj.length-1;coluna_da_matriz++){
                if (obj[coluna_da_matriz]!="0,00"){
                Vertice<Tipo> origem = lista_de_Vertices.get(coluna_da_matriz);
                Vertice<Tipo> destino = lista_de_Vertices.get(coluna_da_matriz);
                float peso = Float.parseFloat((obj[coluna_da_matriz]).replace(",", "."));
                Aresta<Tipo> aresta = new Aresta<Tipo>(origem,destino,peso);
                lista_de_arestas.add(aresta);
                }
            }
        }
        
        //Instanciacao do grafo, fechamento do tempo de processamento e impressao do grafo
        Grafo<Tipo> matriz = new Grafo<Tipo>(lista_de_arestas, lista_de_Vertices, numero_de_casos);
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("O método foi executado em " +tempo+" ms");
        System.out.println(matriz);
        return matriz;
    }

  
}


