/**@author Emanuel Norjosa Luz e Giovanni Sencioles*/

package arvorebinaria;

public class Node<Tipo> {
    Aluno<Tipo> valor;
    Node<Tipo> noEsquerdo;
    Node<Tipo> noDireito;
    Node(Aluno<Tipo> aluno){
        this.valor = aluno;
        this.noEsquerdo = null;
        this.noDireito = null;
    }
    Aluno<Tipo> getValor(){
        return this.valor;
    } 
    Node<Tipo> getEsquerdo(){
        return this.noEsquerdo;
    }
    Node<Tipo> getDireito(){
        return this.noDireito;
    }
    void setValor(Aluno<Tipo> val){
        this.valor = val;
    }
    void setEsquerdo(Node<Tipo> node){
        this.noEsquerdo = node;
    }
    void setDireito(Node<Tipo> node){
        this.noDireito = node;
    }
}