public class Apartamento extends Imovel implements Comparable {
    private String andar;
    private double factorQualidade;

    public double precoDia(){
        return super.getPrecoBase() * this.factorQualidade;
    }

    @Override
    public int compareTo(Object o) {
        Imovel i = (Imovel) o;
        return Double.compare(this.precoDia(), i.precoDia());
    }
}
