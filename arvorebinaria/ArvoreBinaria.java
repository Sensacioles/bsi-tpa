/**@author Emanuel Norjoea Luz e Giovanni Sencioles*/

package arvorebinaria;

public class ArvoreBinaria<Tipo extends Comparable<Tipo>>{
    Node<Tipo> raiz;
    protected ArvoreBinaria(Node<Tipo> root){
        this.raiz = null;
    }
    //Função para criação de nó recursivamente
    private Node<Tipo> createNode(Node<Tipo> leaf,Aluno<Tipo> aluno){
		if(leaf== null){
			return new Node<Tipo>(aluno);}
        if(leaf.getValor() == null){
            return new Node<Tipo>(aluno);
        }
        if((leaf.getValor().getMatricula()).compareTo(aluno.getMatricula()) > 0){
            leaf.noEsquerdo = createNode(leaf.getEsquerdo(),aluno);
        }
        else if((leaf.getValor().getMatricula()).compareTo(aluno.getMatricula()) < 0){
            leaf.noDireito = createNode(leaf.getDireito(),aluno);
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
            if(leaf.getValor().getMatricula().compareTo(obj) > 0){
                aux = leaf;
                leaf = aux.getEsquerdo();
                //searchValue(leaf.getEsquerdo(),obj);
            }
            else if(leaf.getValor().getMatricula().compareTo(obj) < 0){
                aux = leaf;
                leaf = aux.getDireito();
                //searchValue(leaf.getDireito(),obj);
            }
            else if(leaf.getValor().getMatricula().compareTo(obj) == 0){
                return leaf;
            }
        }
        return leaf;
    }
    //Função para remoção de objeto
    public Node<Tipo> destroyNode(Node<Tipo> leaf,Tipo obj){
        if(leaf != null){
            if(leaf.getValor().getMatricula().compareTo(obj) > 0){
                destroyNode(leaf.getEsquerdo(),obj);
            }
            else if(leaf.getValor().getMatricula().compareTo(obj) < 0){
                destroyNode(leaf.getDireito(),obj);
            }
            else{ 
                if(leaf.getEsquerdo() == null){
                    return leaf.getDireito();
                }
                else if(leaf.getDireito() == null){
                    return leaf.getEsquerdo();
                }
            }
            return leaf;
        }
        else{
            return leaf;
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
        if(leaf == null){
            return 0;
        }
        else{
            int heightEsquerda = heightTree(raiz.getEsquerdo());
            int heightDireita = heightTree(raiz.getDireito());
            if(heightEsquerda > heightDireita){
                return heightEsquerda+1;
            }
            else{
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
    public Node<Tipo> findMin(Node<Tipo> leaf){
        if(leaf != null){
            Node<Tipo> min = leaf;
            Node<Tipo> minEsquerda = leaf.getEsquerdo();
            Node<Tipo> minDireita = leaf.getDireito();
            if((min.getValor().getMatricula()).compareTo(minEsquerda.getValor().getMatricula()) > 0){
                min = minEsquerda;
            }
            else if(min.getValor().getMatricula().compareTo(minDireita.getValor().getMatricula()) > 0){
                min = minDireita;
            }
            return min;
        }
        return leaf;
    }
    //Função para encontrar máximo da árvore
    public Node<Tipo> findMax(Node<Tipo> leaf){
        if(leaf != null){
            Node<Tipo> max = leaf;
            Node<Tipo> maxEsquerda = leaf.getEsquerdo();
            Node<Tipo> maxDireita = leaf.getDireito();
            if(max.getValor().getMatricula().compareTo(maxEsquerda.getValor().getMatricula()) < 0){
                max = maxEsquerda;
            }
            else if(max.getValor().getMatricula().compareTo(maxDireita.getValor().getMatricula()) < 0){
                max = maxDireita;
            }
            return max;
        }
        return leaf;
    }
	//Função para encontrar o pior caso
	public Node<Tipo> getWorst(Node<Tipo> leaf){
		if(leaf != null){
			if(leaf.getDireito() != null){
				leaf = getWorst(leaf.getDireito());
			}
			else if(leaf.getEsquerdo() != null){
				leaf = getWorst(leaf.getEsquerdo());
			}
			return leaf;
		}
		return leaf;
	}
    //Método para adição de nó na árvore
    public void addNode(Aluno<Tipo> aluno){
        raiz = createNode(raiz,aluno);
    }
    //Método para busca de nó na árvore
    public void existsValue(Tipo obj){
        raiz = searchValue(raiz,obj);
    }
    //Método para remoção de nó na árvore
    public void removeNode(Tipo obj){
        raiz = destroyNode(raiz,obj);
    }
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
    //Método para imprimir mínimo da árvore
    public void printMin(){
        raiz = findMin(raiz);
    }
    //Método para imprimir mínimo da árvore
    public void printMax(){
        raiz = findMax(raiz);
    }
	//Método para obter pior caso de busca
	public void findWorst(){
		raiz = getWorst(raiz);
	}
 
}
