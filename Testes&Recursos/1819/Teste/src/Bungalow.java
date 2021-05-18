public class Bungalow extends Imovel implements Comparable{
    private double factorQualidade;
    private double espessuraParedes;

    public double precoDia() {
        return super.getPrecoBase() * (0.5 * this.factorQualidade + 0.5 * this.espessuraParedes);
    }

    public int compareTo(Object o){
        Imovel i = (Imovel) o;
        return Double.compare(this.precoDia(), i.precoDia());
    }
}
