import java.util.Comparator;

public class Candidato implements Comparable<Candidato>{
    private String nome;
    private int idade;

    public Candidato(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Candidato(Candidato c){
        this.nome = c.getNome();
        this.idade = c.getIdade();
    }

    public Candidato clone(){
        return new Candidato(this);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int compareTo(Candidato o) {
        return this.nome.compareTo(o.getNome());
    }

    static class compareIdades implements Comparator<Candidato>{
        public int compare(Candidato o1, Candidato o2) {
            int ans = Integer.compare(o1.getIdade(), o2.getIdade());
            if(ans == 0)
                ans = o1.compareTo(o2);
            return ans;
        }
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        Candidato c = (Candidato) o;
        return (this.nome.equals(c.getNome()) && this.idade == c.idade);
    }
}
