import java.time.LocalDateTime;

public class Eletrodomestico {
    private String ident;
    private LocalDateTime inicio;
    private LocalDateTime parcial;
    private double consumoLigada;
    private double consumoTotal;
    private double consumoParcial;
    private boolean estado; // false - desligada, true - ligada

    public Eletrodomestico(String ident, double consumo){}
    public Eletrodomestico(){}
    public Eletrodomestico clone(){return new Eletrodomestico();}
    public void EletrodomesticoON(){}
    public void EletrodomesticoOFF(){}
    public double totalConsumo(){return 0.0;}
    public double periodoConsumo(){return 0.0;}
    public void efectuarResetConsumo(){}

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

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
