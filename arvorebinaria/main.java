
package arvorebinaria;

import java.io.IOException;
import java.util.Scanner;

 public class main <Tipo extends Comparable<Tipo>>{
	
	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria<Aluno>(null);
		LeitorArquivos leitor = new LeitorArquivos<>();
		 
		String nome;
		Integer nota;
		try {
			//Trocar path sempre que for rodar o programa
			arvore =  leitor.ler ("C:\\Users\\giova\\java\\arvorebinaria\\Entradas.txt");
		} catch (IOException e) {
 			e.printStackTrace();}
			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			Scanner scanner3 = new Scanner(System.in);
			Scanner scanner4 = new Scanner(System.in);

			int matricula ;
			int menu = 0;


 
			while(menu!=99){
				System.out.println(
				"Exibir estatísticas: digite 1.\n"+ 
				"Efetuar busca por matrícula:digite 2\n"+
				"Excluir por matrícula: digite 3\n"+
				"Incluir aluno: digite 4\n"+
				"Sair:digite 99\n"+
				"digite a sua escolha: ");
				menu =scanner.nextInt();
				if(menu==1){
					System.out.println("quantidade total de elementos:"+ (arvore.enumNode(arvore.raiz)));
					System.out.println("\naltura da árvore:"+  (arvore.heightTree(arvore.raiz))); 
					System.out.println("\no maior elemento:"+(arvore.findMax()));
					System.out.println("\no menor elemento:"+(arvore.findMin()));
					System.out.println("\npior caso de busca:"+(arvore.getWorst()));
				}
				else if(menu==2){
					System.out.println("digite a matricula : ");
					matricula=scanner2.nextInt();
					Aluno a = new Aluno(matricula, "", 100);
					a=(Aluno)arvore.searchValue(arvore.raiz,a).getValor();
					System.out.println(a);
				}
				else if(menu==3){
					System.out.println("digite a matricula que quer excluir: ");
					matricula=scanner3.nextInt();
					arvore.destroyNode(matricula);
					if (arvore.searchValue(arvore.raiz,matricula) == null){
						System.out.println("Matricula excluida ");
					}
				}
				else if(menu==4){
					System.out.println("digite a matricula que quer add: ");
					matricula=scanner2.nextInt();
					System.out.println("digite o nome do aluno que quer add: ");
					nome= scanner3.nextLine();
					System.out.println("digite a nota do aluno que quer add: ");
					nota= scanner4.nextInt();
					Aluno novo_aluno=new Aluno (matricula, nome, nota);
					arvore.addNode(novo_aluno);
				}
				else if(menu==99){

				}
				else{ 
					System.out.println("DADO DE ENTRADA INVALIDO ");
				}
		}
		scanner.close();
		scanner2.close();
		scanner3.close();
		scanner4.close();
	}
}

