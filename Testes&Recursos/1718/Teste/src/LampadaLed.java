public class LampadaLed extends Lampada{
    private double difCons;

    public LampadaLed(String ident, double consumoLigada, double consumoEco, double consumoTotal, double consumoParcial, int estado, double difCons) {
        super(ident, consumoLigada, consumoEco, consumoTotal, consumoParcial, estado);
        this.difCons = difCons;
    }

    public LampadaLed(Lampada l, double difCons) {
        super(l);
        this.difCons = difCons;
    }

    public double getConsumoTotal() {
        return super.getConsumoTotal() * difCons;
    }
}
