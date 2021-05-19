public class Tecnico implements Comparable<Tecnico>{
    private String ident; // identificador técnico
    private String nome; // nome do técnico
    private int numTickets; // número de tickets resolvidos

    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumTickets() {
        return this.numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public int compareTo(Tecnico o) {
        return Integer.compare(this.numTickets, o.getNumTickets());
    }
}
