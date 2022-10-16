package arvorebinaria;

public class Aluno implements Comparable<Aluno>{
	int matricula;
	String nome;
	float nota;
	Aluno(int m,String nm,float nt){
		this.matricula = m;
		this.nome = nm;
		this.nota = nt;
	}
	int getMatricula(){
        return this.matricula;
    } 
    String getNome(){
        return this.nome;
    }
    float getNota(){
        return this.nota;
    }
	void setMatricula(int m){
		this.matricula = m;
	}
	void setNome(String nm){
		this.nome = nm;
	}
	void setNota(float nt){
		this.nota = nt;
	}
	/*Aluno<Tipo> createAluno(Aluno<Tipo> stud,Tipo m, Tipo nm, Tipo nt){
		if(stud.matricula == null){
			stud = new Aluno<Tipo>(m,nm,nt);
		}
		else{
			if(stud.nome == null){
				stud.setNome(nm);
			}
			else{
				stud.setNota(nt);
			}
		}
		return stud;
	}*/
	@Override
	public int compareTo(Aluno o) {
		if (this.matricula == o.matricula)
			return 0;
		else if (this.matricula > o.matricula)
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Matricula: " + Integer.toString(this.matricula) + " - Nome: " + this.nome);
	}
}