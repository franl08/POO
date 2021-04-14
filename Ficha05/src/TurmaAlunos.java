import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TurmaAlunos implements Comparable<TurmaAlunos> {
    private Map<String, Aluno> turma;
    private String nomeTurma;
    private String uc;

    public TurmaAlunos(){
        this.turma = new HashMap<>();
        this.nomeTurma = "";
        this.uc = "";
    }

    public TurmaAlunos(String nomeTurma, String uc){
        this.turma = new HashMap<>();
        this.nomeTurma = nomeTurma;
        this.uc = uc;
    }

    public TurmaAlunos(Map<String, Aluno> turma, String nomeTurma, String uc){
        this.setTurma(turma);
        this.nomeTurma = nomeTurma;
        this.uc = uc;
    }

    public TurmaAlunos (TurmaAlunos t){
        this.setTurma(t.getTurma());
        this.nomeTurma = t.getNomeTurma();
        this.uc = t.getUc();
    }

    public Map<String, Aluno> getTurma(){
        return this.turma.entrySet()
                .stream()
                .collect(Collectors.toMap(t -> t.getValue().getNumero(), t -> t.getValue().clone()));
    }

    public void setTurma(Map<String, Aluno> turma){
        this.turma = new HashMap<>();
        for (Map.Entry<String, Aluno> a : turma.entrySet())
            this.turma.put(a.getKey(), a.getValue().clone());
    }

    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        TurmaAlunos t = (TurmaAlunos) o;
        return (this.nomeTurma.equals(t.getNomeTurma()) && this.uc.equals(t.getUc()) && this.turma.equals(t.getTurma()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Turma: ")
                .append(nomeTurma).append(" | ")
                .append(uc).append(" | ")
                .append(turma.toString())
                .append("\n");
        return sb.toString();
    }

    public String getNomeTurma() {
        return this.nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getUc() {
        return this.uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    public int sizeT(){
        return this.turma.size();
    }

    public int compareTo(TurmaAlunos t1){
        return this.turma.size() - t1.sizeT();
    }

    public void insereAluno (Aluno a){
        this.turma.put(a.getNumero(), a.clone());
    }

    public Aluno getAluno (String codAluno){
        return this.turma.get(codAluno);
    }
}
