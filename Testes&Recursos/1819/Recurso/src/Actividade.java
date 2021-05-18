import java.io.Serializable;

public abstract class Actividade implements Serializable, Comparable<Actividade> {
    private String designacao;
    private double caloriasPorUnidadeTreino; // calorias por unidade de treino (o nome parecia bastante óbvio)

    public abstract double caloriasGastas(); // o consumo de calorias depende de cada actividade específica

    public double getCaloriasPorUnidadeTreino(){
        return this.caloriasPorUnidadeTreino;
    }

    public abstract Actividade clone();

    public int compareTo(Actividade a){
        return Double.compare(this.caloriasGastas(), a.caloriasGastas());
    }
}
