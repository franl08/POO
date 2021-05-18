public class Corrida extends Actividade implements ComDistancia{
    private double kmsPercorridos;
    private double elevacao;
    private double velocidade;

    public Corrida(){
        this.kmsPercorridos = 0;
        this.elevacao = 0;
        this.velocidade = 0;
    }

    public Corrida(double kmsPercorridos, double elevacao, double velocidade) {
        this.kmsPercorridos = kmsPercorridos;
        this.elevacao = elevacao;
        this.velocidade = velocidade;
    }

    public Corrida clone(){
        return new Corrida();
    }

    public double getKmsPercorridos() {
        return this.kmsPercorridos;
    }

    public void setKmsPercorridos(double kmsPercorridos) {
        this.kmsPercorridos = kmsPercorridos;
    }

    public double getElevacao() {
        return this.elevacao;
    }

    public void setElevacao(double elevacao) {
        this.elevacao = elevacao;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double caloriasGastas(){
        return this.getCaloriasPorUnidadeTreino() * this.kmsPercorridos * (this.elevacao * 0.25);
    }

}
