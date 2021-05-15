import java.io.Serializable;
import java.util.Comparator;

public abstract class Imovel implements Serializable, Comparable{
    private String codImovel;
    private String morada;
    private String nifProprietario;
    private double area;
    private double precoBase;
    public abstract double precoDia();

    public double getPrecoBase(){
        return this.precoBase;
    }

    public double getArea(){
        return this.area;
    }

    public int compareTo(Imovel i){
        return Double.compare(this.precoDia(), i.precoDia());
    }
}