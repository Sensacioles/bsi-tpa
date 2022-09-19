/**@author Emanuel Norjosa Luz e Giovanni Sencioles*/

package arvorebinaria;

public class NodeString{
    String valor;
    NodeString noEsquerdo;
    NodeString noDireito;
    NodeString(String val){
        this.valor = val;
        this.noEsquerdo = null;
        this.noDireito = null;
    }
    String getValor(){
        return this.valor;
    } 
    NodeString getEsquerdo(){
        return this.noEsquerdo;
    }
    NodeString getDireito(){
        return this.noDireito;
    }
    void setValor(String val){
        this.valor = val;
    }
    void setEsquerdo(NodeString node){
        this.noEsquerdo = node;
    }
    void setDireito(NodeString node){
        this.noDireito = node;
    }
}