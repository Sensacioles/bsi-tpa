package arvorebinaria;

public class Aluno<Tipo>{
	Tipo matricula;
	Tipo nome;
	Tipo nota;
	Aluno(Tipo m,Tipo nm,Tipo nt){
		this.matricula = m;
		this.nome = nm;
		this.nota = nt;
	}
	Tipo getMatricula(){
        return this.matricula;
    } 
    Tipo getNome(){
        return this.nome;
    }
    Tipo getNota(){
        return this.nota;
    }
	void setMatricula(Tipo m){
		this.matricula = m;
	}
	void setNome(Tipo nm){
		this.nome = nm;
	}
	void setNota(Tipo nt){
		this.nota = nt;
	}
	Aluno<Tipo> createAluno(Aluno<Tipo> stud,Tipo m, Tipo nm, Tipo nt){
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
	}
}