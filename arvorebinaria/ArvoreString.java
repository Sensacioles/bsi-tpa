/**@author Emanuel Norjosa Luz e Giovanni Sencioles*/

package arvorebinaria;

public class ArvoreString{
    NodeString raiz;
    ArvoreString(NodeString root){
        this.raiz = null;
    }
    //Função para criação de nó recursivamente
    private NodeString createNode(NodeString leaf,String obj){
        if(leaf.getValor() == null){
            return new NodeString(obj);
        }
        if(leaf.getValor().compareTo(obj) > 0){
            leaf.noEsquerdo = createNode(leaf.getEsquerdo(),obj);
        }
        else if(leaf.getValor().compareTo(obj) < 0){
            leaf.noDireito = createNode(leaf.getEsquerdo(),obj);
        }
        else{
            return leaf;
        }
        return leaf;
    }
    //Função para busca de objeto iterativamente
    private NodeString searchValue(NodeString leaf,String obj){
        NodeString aux = new NodeString(null);
        while(leaf.getValor() != obj){
            if(leaf.getValor().compareTo(obj) > 0){
                aux = leaf;
                leaf = aux.getEsquerdo();
                //searchValue(leaf.getEsquerdo(),obj);
            }
            else if(leaf.getValor().compareTo(obj) < 0){
                aux = leaf;
                leaf = aux.getDireito();
                //searchValue(leaf.getDireito(),obj);
            }
            else if(leaf.getValor().compareTo(obj) == 0){
                return leaf;
            }
        }
        return leaf;
    }
    //Função para remoção de objeto
    private NodeString destroyNode(NodeString leaf,String obj){
        if(leaf != null){
            if(leaf.getValor().compareTo(obj) > 0){
                destroyNode(leaf.getEsquerdo(),obj);
            }
            else if(leaf.getValor().compareTo(obj) < 0){
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
    private NodeString inOrder(NodeString leaf){
        if(leaf != null){
            inOrder(leaf.getEsquerdo());
            System.out.println(leaf.getValor()+" ");
            inOrder(leaf.getDireito());
        }
        return leaf;
    }
    //Função para calcular a altura da árvore
    public int heightTree(NodeString leaf){
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
    private NodeString inLevel(NodeString leaf,int level){
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
    public int enumNode(NodeString leaf){
        if(leaf == null){
            return 0;
        }
        return 1+enumNode(leaf.getEsquerdo())+enumNode(leaf.getDireito());
    }
    //Função para encontrar mínimo da árvore
    public NodeString findMin(NodeString leaf){
        if(leaf != null){
            NodeString min = leaf;
            NodeString minEsquerda = leaf.getEsquerdo();
            NodeString minDireita = leaf.getDireito();
            if(min.getValor().compareTo(minEsquerda.getValor()) > 0){
                min = minEsquerda;
            }
            else if(min.getValor().compareTo(minDireita.getValor()) > 0){
                min = minDireita;
            }
            return min;
        }
        return leaf;
    }
    //Função para encontrar máximo da árvore
    public NodeString findMax(NodeString leaf){
        if(leaf != null){
            NodeString max = leaf;
            NodeString maxEsquerda = leaf.getEsquerdo();
            NodeString maxDireita = leaf.getDireito();
            if(max.getValor().compareTo(maxEsquerda.getValor()) < 0){
                max = maxEsquerda;
            }
            else if(max.getValor().compareTo(maxDireita.getValor()) < 0){
                max = maxDireita;
            }
            return max;
        }
        return leaf;
    }
    //Método para adição de nó na árvore
    public void addNode(String obj){
        raiz = createNode(raiz,obj);
    }
    //Método para busca de nó na árvore
    public void existsValue(String obj){
        raiz = searchValue(raiz,obj);
    }
    //Método para remoção de nó na árvore
    public void removeNode(String obj){
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

    /* Não entendemos o item "obter pior caso de busca"
     * O pior caso de busca seria aquele pelo maior objeto em uma árvore que possui apenas filhos à direita
     * Em outras palavras, o pior caso é um conjunto ordenado em que se busca o maior elemento
     * Porque, para chegarmos ao maior elemento, deveríamos checar todos os outros incluindo o último.
     * A complexidade seria O(n).
     */
}
