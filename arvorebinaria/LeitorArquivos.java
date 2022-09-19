package arvorebinaria;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
    public void ler(String path){
        Node<Tipo> leaf = new Node<Tipo>(null);
        long tempoInicial = System.currentTimeMillis();
        String linha = ""; 
        BufferedReader buffRead;
        linha = buffRead.readLine();
        int numero_matriculas = Integer.parseInt(linha);
        linha = buffRead.readLine();
        String[] obj=linha.split(";");
        for (int i=0;i <=numero_matriculas-1;i++){
            linha = buffRead.readLine();
            obj = linha.split(";");
            String matricula = obj[0];
            leaf.setValor(matricula); //Can't insert string into a generic type node
            addNode(matricula);
        }
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("O método foi executado em " +tempo);
    }
}
