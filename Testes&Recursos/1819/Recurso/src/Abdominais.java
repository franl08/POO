public class Abdominais extends Actividade{
    private int numeroRepeticoes;
    private String tipoExercicio;

    public Abdominais(int numeroRepeticoes, String tipoExercicio) {
        this.numeroRepeticoes = numeroRepeticoes;
        this.tipoExercicio = tipoExercicio;
    }

    public Abdominais(){
        this.numeroRepeticoes = 0;
        this.tipoExercicio = "n/a";
    }

    public Abdominais clone(){
        return new Abdominais();
    }

    public int getNumeroRepeticoes() {
        return this.numeroRepeticoes;
    }

    public void setNumeroRepeticoes(int numeroRepeticoes) {
        this.numeroRepeticoes = numeroRepeticoes;
    }

    public String getTipoExercicio() {
        return this.tipoExercicio;
    }

    public void setTipoExercicio(String tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public double caloriasGastas(){
        return this.getCaloriasPorUnidadeTreino() * this.numeroRepeticoes;
    }
}
