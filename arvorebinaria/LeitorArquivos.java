package arvorebinaria;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeitorArquivos<Tipo extends Comparable<Tipo>>{
    public ArvoreBinaria<Tipo> geraArvore(String path){
        long tempoInicial = System.currentTimeMillis();
		String current = new java.io.File( "." ).getCanonicalPath();
        File inputFile = new File(current + "\\arvorebinaria\\Entradas.txt");                
        FileReader in = new FileReader(inputFile);
        BufferedReader buffRead = new BufferedReader(in);
		String linha = buffRead.readLine();
        int numero_matriculas = Integer.parseInt(linha);
        linha = buffRead.readLine();
        String[] obj=linha.split(";");
        for (int i=0;i <=numero_matriculas-1;i++){
            linha = buffRead.readLine();
            if(linha != null){
				Aluno<Tipo> aluno = new Aluno<Tipo>(null,null,null);
				obj = linha.split(";");
				String matricula = obj[0];
				String nome = obj[1];
				String nota = obj[2];
				aluno.setMatricula(matricula);
				aluno.setNome(nome);
				aluno.setNota(nota);
				Node<Tipo> leaf = createNode(aluno);
				ArvoreBinaria<Tipo> tree = addNode(leaf);
			}
        }
        buffRead.close();
        long tempo = System.currentTimeMillis() - tempoInicial;
        System.out.println("O método foi executado em " +tempo);
		return tree;
    }
}
