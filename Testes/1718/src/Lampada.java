import java.time.LocalDateTime;

public class Lampada {
    private String ident;
    private LocalDateTime inicio;
    private LocalDateTime parcial;
    private double consumoLigada;
    private double consumoEco;
    private double consumoTotal;
    private double consumoParcial;
    private int estado; // 0 - desligada, 1 - ligada, 2 - eco

    public Lampada(String ident, double consumoLigada, double consumoEco, double consumoTotal, double consumoParcial, int estado){
        this.ident = ident;
        this.consumoLigada = consumoLigada;
        this.consumoEco = consumoEco;
        this.consumoTotal = consumoTotal;
        this.consumoParcial = consumoParcial;
        this.estado = estado;
    }

    public Lampada(Lampada l){
        this.ident = l.getIdent();
        this.inicio = l.getInicio();
        this.parcial = l.getParcial();
        this.consumoLigada = l.getConsumoLigada();
        this.consumoEco = l.getConsumoEco();
        this.consumoTotal = l.consumoTotal;
        this.consumoParcial = l.getConsumoParcial();
        this.estado = l.getEstado();
    }

    public Lampada clone(){
        return new Lampada(this);
    }

    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public LocalDateTime getInicio() {
        return this.inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getParcial() {
        return this.parcial;
    }

    public void setParcial(LocalDateTime parcial) {
        this.parcial = parcial;
    }

    public double getConsumoLigada() {
        return this.consumoLigada;
    }

    public void setConsumoLigada(double consumoLigada) {
        this.consumoLigada = consumoLigada;
    }

    public double getConsumoEco() {
        return this.consumoEco;
    }

    public void setConsumoEco(double consumoEco) {
        this.consumoEco = consumoEco;
    }

    public double getConsumoTotal() {
        return this.consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getConsumoParcial() {
        return this.consumoParcial;
    }

    public void setConsumoParcial(double consumoParcial) {
        this.consumoParcial = consumoParcial;
    }

    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void lampON(){
        this.inicio = LocalDateTime.now();
        this.estado = 1;
    }

    public void lampEco(){
        this.inicio = LocalDateTime.now();
        this.estado = 2;
    }

    public void lampOFF(){
        this.parcial = LocalDateTime.now();
        this.estado = 0;
    }
}
