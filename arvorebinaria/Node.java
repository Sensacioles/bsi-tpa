/**@author Emanuel Norjosa Luz e Giovanni Sencioles*/

package arvorebinaria;
import Aluno.*;

public class Node<Tipo> {
    private Aluno<Tipo> valor;
    private Node<Tipo> noEsquerdo;
    private Node<Tipo> noDireito;
    Node(Aluno<Tipo> val){
		this.valor = val;
		this.noEsquerdo = null;
		this.noDireito = null;
	}
    public Tipo getValor(){
        return this.valor;
    } 
    public Node<Tipo> getEsquerdo(){
        return this.noEsquerdo;
    }
    public Node<Tipo> getDireito(){
        return this.noDireito;
    }
    public void setValor(Tipo val){
        this.valor = val;
    }
    public void setEsquerdo(Node<Tipo> node){
        this.noEsquerdo = node;
    }
    public void setDireito(Node<Tipo> node){
        this.noDireito = node;
    }
}