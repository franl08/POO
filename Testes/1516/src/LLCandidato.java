import java.util.LinkedList;

public class LLCandidato {
    private LinkedList<Candidato> candidatos;

    public LLCandidato(){
        this.candidatos = new LinkedList<>();
    }

    public LinkedList<Candidato> getCandidatos(){
        LinkedList<Candidato> cands = new LinkedList<>();
        if(this.candidatos != null)
            for(Candidato c : this.candidatos)
                cands.add(c.clone());
        return cands;
    }

    public int size(){
        return this.candidatos.size();
    }

    public void add(Candidato c){
        this.candidatos.add(c.clone());
    }

    public Candidato get(int i) throws CandidatoException{
        if(this.candidatos == null || this.candidatos.isEmpty() || this.candidatos.size() <= i) throw new CandidatoException();
        else return this.candidatos.get(i).clone();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        LLCandidato l = (LLCandidato) o;
        return (this.candidatos.equals(l.getCandidatos()));
    }
}
