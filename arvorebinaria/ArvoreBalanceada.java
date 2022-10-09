import arvorebinaria.ArvoreBinaria;
import arvorebinaria.Node;

public class ArvoreBalanceada extends ArvoreBinaria{
    ArvoreBalanceada(Node root) {
        super(root);
    }
    private int getFator(ArvoreBinaria<Tipo> tree){
        if(tree == null){
            return 0;
        }
        return heightTree(tree.raiz.getEsquerdo())-heightTree(tree.raiz.getDireito());
    }
    private int rotaEsquerda(Node<Tipo> leaf){
        Node<Tipo> n = leaf.getDireito();
        leaf.setDireito(n.getEsquerdo);
        n.setEsquerdo(leaf);
    }
    private int rotaDireita(Node<Tipo> leaf){
        Node<Tipo> n = leaf.getEsquerdo();
        leaf.setEsquerdo(n.getDireito);
        n.setDireito(leaf);
    }
    @Override
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
            leaf.noDireito = createNode(leaf.getEsquerdo(),aluno);
        }
        //Balanceamento por fator
        if((fat = getFator(leaf)) != 0){
            if(fat > 1 && aluno.getMatricula() < leaf.getEsquerdo.getValor()){
                //Rotação à esquerda
                rotaEsquerda(leaf);
            }
            else if(fat < -1 && aluno.getMatricula() > leaf.getDireito.getValor()){
                //Rotação à direita
                rotaDireita(leaf);
            }
            else if(fat > 1 && aluno.getMatricula() < leaf.getEsquerdo.getValor()){
                //Rotação esquerda direita
                leaf.setEsquerdo(rotaEsquerda(leaf.getEsquerdo()));
                rotaDireita(leaf);
            }
            else if(fat < -1 && aluno.getMatricula() > leaf.getDireito.getValor()){
                //Rotação direita esquerda
                leaf.setDireito(rotaDireita(leaf.getDireito()));
                rotaEsquerda(leaf);
            }
        }
        else{
            return leaf;
        }
        return leaf;
    }
}
