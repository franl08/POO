public class Eliptica extends Actividade implements ComDistancia{
    private double kmsPercorridos;
    private double nivelEsforco;
    private double minutos;

    public Eliptica() {
        this.kmsPercorridos = 0.0;
        this.nivelEsforco = 0.0;
        this.minutos = 0.0;
    }

    public Eliptica(double kmsPercorridos, double nivelEsforco, double minutos) {
        this.kmsPercorridos = kmsPercorridos;
        this.nivelEsforco = nivelEsforco;
        this.minutos = minutos;
    }

    public Eliptica clone(){
        return new Eliptica();
    }

    @Override
    public double getKmsPercorridos() {
        return this.kmsPercorridos;
    }

    public void setKmsPercorridos(double kmsPercorridos) {
        this.kmsPercorridos = kmsPercorridos;
    }

    public double getNivelEsforco() {
        return this.nivelEsforco;
    }

    public void setNivelEsforco(double nivelEsforco) {
        this.nivelEsforco = nivelEsforco;
    }

    public double getMinutos() {
        return this.minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    @Override
    public double caloriasGastas() {
        return this.getCaloriasPorUnidadeTreino() * this.kmsPercorridos * (this.nivelEsforco <= 4 ? this.minutos * 0.2 : this.minutos * 0.05);
    }
}
