package arvorebinaria;

import java.io.IOException;
import java.util.Scanner;

import arvorebinaria.LeitorArquivos;
public class main <Tipo extends Comparable<Tipo>>{
	
	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria<>(null);
		LeitorArquivos leitor = new LeitorArquivos<>();
		Aluno novo_aluno= new Aluno<>(null,null,null);
		String nome;
		Integer nota;
		try {
			arvore =  leitor.ler ("C:\\Users\\giova\\Downloads\\DOO-main\\DOO-main\\bsi-doo-main\\bsi-tpa-master\\arvorebinaria\\Entradas.txt");
		} catch (IOException e) {
 			e.printStackTrace();}
			Scanner scanner = new Scanner(System.in);
			String matricula = "";
			int menu = 0;


 
			while(menu!=1){
				System.out.println(
				"Exibir estatísticas: digite 1.\n"+ 
				"Efetuar busca por matrícula:digite 2\n"+
				"Excluir por matrícula: digite 3\n"+
				"Incluir aluno: digite 4\n"+
				"Sair:digite 99\n" );
				menu =scanner.nextInt();
				if(menu==1){
					System.out.println("quantidade total de elementos:"+ arvore.enumNode(arvore.raiz)+
					"\naltura da árvore:"+  arvore.heightTree(arvore.raiz) +
					"\no maior elemento:"+arvore.findMax(arvore.raiz)+
					"\no menor elemento:"+arvore.findMin(arvore.raiz)+
					"\npior caso de busca:"+arvore.getWorst(arvore.raiz));
				}
				else if(menu==2){
					System.out.println("digite a matricula : ");
					matricula=scanner.nextLine();
					System.out.println("Matricula : "+arvore.searchValue(arvore.raiz,matricula));
				}
				else if(menu==3){
					System.out.println("digite a matricula que quer excluir: ");
					matricula=scanner.nextLine();
					arvore.destroyNode(arvore.raiz,matricula);
					if (arvore.searchValue(arvore.raiz,matricula) == null){
						System.out.println("Matricula excluida ");
					}
				}
				else if(menu==4){
					System.out.println("digite a matricula que quer add: ");
					matricula=scanner.nextLine();
					System.out.println("digite o nome do aluno que quer add: ");
					nome= scanner.nextLine();
					System.out.println("digite a nota do aluno que quer add: ");
					nota= scanner.nextInt();
					novo_aluno.createAluno(novo_aluno, matricula, nome, nota);
					arvore.addNode(novo_aluno);


				}
				else if(menu==99){

				}
				else{ 
					System.out.println("DADO DE ENTRADA INVALIDO ");

				}
			


		} 

	}
}

