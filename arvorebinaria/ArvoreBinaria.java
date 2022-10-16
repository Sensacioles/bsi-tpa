/**@author Emanuel Norjoea Luz e Giovanni Sencioles*/

package arvorebinaria;

public class ArvoreBinaria<Tipo extends Comparable>{
    Node<Tipo> raiz;
    ArvoreBinaria(Node<Tipo> root){
        this.raiz = root;
    }

    ArvoreBinaria(){
        this.raiz = null;
    }


    //Função para criação de nó recursivamente
    private Node<Tipo> createNode(Node<Tipo> leaf,Tipo novo){
		if(leaf== null){
			return new Node<Tipo>(novo);}
        if(leaf.getValor() == null){
            return new Node<Tipo>(novo);
        }
        if(leaf.getValor().compareTo(novo) > 0){
            leaf.noEsquerdo = createNode(leaf.getEsquerdo(),novo);
         }
        else if(leaf.getValor().compareTo(novo) < 0){
            leaf.noDireito = createNode(leaf.getDireito(),novo);
 
        }
        else{
        	
        	
            return leaf;
        }
        return leaf;
    }
    //Função para busca de objeto iterativamente
    public Node<Tipo> searchValue(Node<Tipo> leaf,Tipo obj){
        Node<Tipo> aux = new Node<Tipo>(null);
        while(leaf != obj){
            if(leaf.getValor().compareTo(obj) > 0){ //Atual maior que o esperado, ir para a esquerda
                aux = leaf;
                leaf = aux.getEsquerdo();
            }
            else if(leaf.getValor().compareTo(obj) < 0){ //Atual menor que o esperado, ir para a direita
                aux = leaf;
                leaf = aux.getDireito();
            }
            else if(leaf.getValor().compareTo(obj) == 0){ //Objeto encontrado
                return leaf;
            }
        }
        return leaf;
    }
    //Função para remoção de objeto
    public void destroyNode(Tipo obj){
        Node<Tipo> aux = new Node<Tipo>(null);
        Node<Tipo> leaf = searchValue(this.raiz,obj);
        if(leaf.getEsquerdo() != null && leaf.getDireito() == null){ //Caso nao tenha filho maior
            aux.setEsquerdo(leaf.getEsquerdo());
            leaf = null;
        }
        else if(leaf.getEsquerdo() == null && leaf.getDireito() != null){ //Caso nao tenha filho menor
            aux.setDireito(leaf.getDireito());
            leaf = null;
        }
        else if(leaf.getEsquerdo() != null && leaf.getDireito() != null){ //Caso tenha ambos filhos
            if(leaf.getDireito().getEsquerdo() != null){ //Substitui pelo filho em ordem
               aux.setDireito(leaf.getDireito().getEsquerdo());  
            }
            else if(leaf.getDireito().getDireito() != null){ //Caso nao haja, substituir pelo seguinte
                aux.setDireito(leaf.getDireito().getDireito());
            }
            else if(leaf.getEsquerdo().getDireito() != null){ //Caso nao haja seguinte, voltar uma ordem
                aux.setEsquerdo(leaf.getEsquerdo().getDireito());
            }
            else{ //Caso nao haja ordem anterior, voltar mais uma ordem
                aux.setEsquerdo(leaf.getEsquerdo().getEsquerdo());
            }
            leaf = null; //Deleta node
        }
        else{ //Caso nao possua filhos, deleta node diretamente
            leaf = null;
        }
    }
    //Função para imprimir os objetos da árvore em ordem
    private Node<Tipo> inOrder(Node<Tipo> leaf){
        if(leaf != null){
            inOrder(leaf.getEsquerdo());
            System.out.println(leaf.getValor()+" ");
            inOrder(leaf.getDireito());
        }
        return leaf;
    }
    //Função para calcular a altura da árvore
    public int heightTree(Node<Tipo> leaf){
    	Node<Tipo> aux = new Node<Tipo>(null);
    	aux= leaf;
        if(leaf == null || leaf.getValor() == null){ //Arvore vazia
            return 0;
        }
        else{
        	int heightEsquerda = heightTree(aux.getEsquerdo());
            int heightDireita = heightTree(aux.getDireito());
            if(heightEsquerda > heightDireita){ //Subarvore da esquerda com mais níveis que a direita, sera usada como altura final
                return heightEsquerda+1;
            }
            else{ //Subarvore da direita com mais níveis que a esquerda, sera usada como altura final
                return heightDireita+1;
            }
        }
    }
    //Função para imprimir o nível da árvore
    private Node<Tipo> inLevel(Node<Tipo> leaf,int level){
        if(leaf != null){
            if(level == 1){
                System.out.println(leaf.getValor()+" ");
            }
            else{
                inLevel(leaf.getEsquerdo(),level-1);
                inLevel(leaf.getDireito(),level-1);
            }
        }
        return leaf;
    }
    //Função para quantificar os nós existentes na árvore
    public int enumNode(Node<Tipo> leaf){
        if(leaf == null){
            return 0;
        }
        return 1+enumNode(leaf.getEsquerdo())+enumNode(leaf.getDireito());
    }
    //Função para encontrar mínimo da árvore
    public Tipo findMin(){
        Node<Tipo> atual = this.raiz;
        while(atual.getEsquerdo()!=null){ //Caminha totalmente pra esquerda ate nao haver proximo elemento
            atual = atual.getEsquerdo();
        }
        return atual.getValor();
    }
    //Função para encontrar máximo da árvore
    public Tipo findMax(){
        Node<Tipo> atual = this.raiz;
        while(atual.getDireito()!=null){ //Caminha totalmente pra direita ate nao haver proximo elemento
            atual = atual.getDireito();
        }
        return atual.getValor();
    }
	//Função para encontrar o pior caso
	public Tipo getWorst(){
		return this.findMax();
	}
    //Método para adição de nó na árvore
    public void addNode(Tipo aluno){
        raiz = createNode(raiz,aluno);
    }
    /*//Método para busca de nó na árvore
    public void existsValue(Tipo obj){
        raiz = searchValue(raiz,obj);
    }
    //Método para remoção de nó na árvore
    public void removeNode(Tipo obj){
        raiz = destroyNode(raiz,obj);
    }*/
    //Método para caminhar a árvore em ordem
    public void printOrder(){
        raiz = inOrder(raiz);
    }
    //Método para caminhar a árvore em nível
    public void printLevel(){
        for(int i=1;i <= heightTree(raiz);i++){
            inLevel(raiz,i);
        }
    }
}
