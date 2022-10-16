package arvorebinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
    public static final int ler = 0;

    public ArvoreBinaria<Aluno> ler(String path) throws IOException{
        Aluno aluno;
        //Node<Aluno> raiz =   new Node<Aluno>(aluno);
        ArvoreBinaria<Aluno> arvore =new ArvoreBinaria<Aluno>();
        long tempoInicial = System.currentTimeMillis();
        String linha = ""; 
        BufferedReader buffRead =new BufferedReader(new FileReader(path));
        linha = buffRead.readLine();
        int numero_matriculas = Integer.parseInt(linha);
        System.out.println(numero_matriculas);
        String[] obj;
        for (int i=0;i <=numero_matriculas-1;i++){
            linha = buffRead.readLine();
            obj = linha.split(";");
            aluno=new Aluno(Integer.parseInt(obj[0]),obj[1],Float.parseFloat(obj[2])); 
            arvore.addNode(aluno);
        }
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("Arquivo lido em " +tempo+" ms");
        return arvore;
    }
}
