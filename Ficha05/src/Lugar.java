public class Lugar{
    private String matricula;
    private String nomeProp;
    private int minutos;
    private boolean permanente;

    public Lugar() {
        this.matricula = "";
        this.nomeProp = "";
        this.minutos = 0;
        this.permanente = false;
    }

    public Lugar(String matricula, String nomeProp, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nomeProp = nomeProp;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar(Lugar l){
        this.matricula = l.getMatricula();
        this.nomeProp = l.getNomeProp();
        this.minutos = l.getMinutos();
        this.permanente = l.getPermanente();
    }

    public Lugar clone(){
        return new Lugar(this);
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeProp() {
        return this.nomeProp;
    }

    public void setNomeProp(String nomeProp) {
        this.nomeProp = nomeProp;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean getPermanente() {
        return this.permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

}
