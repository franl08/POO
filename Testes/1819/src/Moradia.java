public class Moradia extends Imovel implements Comparable{
    private double areaPrivativa;
    private double areaExterior;

    public double precoDia() {
        return super.getPrecoBase() * (0.3 * this.areaPrivativa + 0.7 * this.areaExterior);
    }

    public int compareTo(Object o){
        Imovel i = (Imovel) o;
        return Double.compare(this.precoDia(), i.precoDia());
    }
}
