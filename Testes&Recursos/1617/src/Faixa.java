import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Faixa implements Comparable<Faixa>, Playable{
    private String nome;
    private String autor;
    private double duracao;
    private int classificacao;
    private ArrayList<String> letra; // letra da música
    private int numeroVezesTocada; // número de vezes que foi tocada
    private LocalDateTime utlimaVez; // regista quando foi tocada pela última vez

    public Faixa(String nome, String autor, double duracao, int classificacao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime utlimaVez){
        this.nome = nome;
        this.autor = autor;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.setLetra(letra);
        this.numeroVezesTocada = numeroVezesTocada;
        this.utlimaVez = utlimaVez;
    }

    public Faixa(Faixa f){
        this.nome = f.getNome();
        this.autor = f.getAutor();
        this.duracao = f.getDuracao();
        this.classificacao = f.getClassificacao();
        this.setLetra(f.getLetra());
        this.numeroVezesTocada = f.getNumeroVezesTocada();
        this.utlimaVez = f.getUtlimaVez();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || o.getClass() != this.getClass()) return false;
        Faixa f = (Faixa) o;

        return(this.nome.equals(f.getNome()) && this.autor.equals(f.getAutor()) && this.duracao == f.getDuracao() && this.classificacao == f.getClassificacao()
                && this.letra.equals(f.getLetra()) && this.numeroVezesTocada == f.getNumeroVezesTocada() && this.utlimaVez.equals(f.getUtlimaVez()));
    }

    public Faixa clone(){
        return new Faixa(this);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getDuracao() {
        return this.duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getNumeroVezesTocada() {
        return this.numeroVezesTocada;
    }

    public void setNumeroVezesTocada(int numeroVezesTocada) {
        this.numeroVezesTocada = numeroVezesTocada;
    }

    public LocalDateTime getUtlimaVez() {
        return this.utlimaVez;
    }

    public void setUtlimaVez(LocalDateTime utlimaVez) {
        this.utlimaVez = utlimaVez;
    }

    public ArrayList<String> getLetra(){
        ArrayList<String> ans = new ArrayList<>();
        if(this.letra != null)
            ans.addAll(this.letra);
        return ans;
    }

    public void setLetra(ArrayList<String> letra){
        this.letra = new ArrayList<>();
        if(letra != null)
            this.letra.addAll(letra);
    }

    public int compareTo(Faixa f) {
        return Integer.compare(this.numeroVezesTocada, f.getNumeroVezesTocada());
    }

    class ComparaUltimaVez implements Comparator<Faixa>{
        public int compare(Faixa f1, Faixa f2){
            return f1.getUtlimaVez().compareTo(f2.getUtlimaVez());
        }
    }


    public void play() {
        System.audio(this.letra);
    }
}
