import java.util.ArrayList;

public class VeiculoPremium extends Veiculo implements BonificaKms{
    private double taxaDeLuxo;
    private int pontosKm;

    public VeiculoPremium() {
        super();
        this.taxaDeLuxo = 0;
        this.pontosKm = 0;
    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaDeLuxo = 0;
        this.pontosKm = 0;
    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, double taxaDeLuxo) {
        super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosKm = 0;
    }

    public VeiculoPremium(Veiculo v, double taxaDeLuxo) {
        super(v);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosKm = 0;
    }

    public VeiculoPremium(Veiculo v, double taxaDeLuxo, int pontosKm){
        super(v);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosKm = pontosKm;
    }

    public VeiculoPremium(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, double taxaDeLuxo, int pontosKm) {
        super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaDeLuxo = taxaDeLuxo;
        this.pontosKm = pontosKm;
    }


    public VeiculoPremium(Veiculo v) {
        super(v);
        this.taxaDeLuxo = 0;
        this.pontosKm = 0;
    }

    public VeiculoPremium(VeiculoPremium vp){
        super(vp);
        this.taxaDeLuxo = vp.getTaxaDeLuxo();
        this.pontosKm = vp.getPontosKm();
    }

    public VeiculoPremium clone(){
        return new VeiculoPremium(this);
    }

    public double getTaxaDeLuxo() {
        return this.taxaDeLuxo;
    }

    public void setTaxaDeLuxo(double taxaDeLuxo) {
        this.taxaDeLuxo = taxaDeLuxo;
    }

    public boolean equals(Object o){
        if(o == this) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        VeiculoPremium vp = (VeiculoPremium) o;
        return(super.equals(o) && vp.getTaxaDeLuxo() == this.taxaDeLuxo);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Premium:{\n")
                .append(super.toString())
                .append("\nTaxa de Luxo: ").append(taxaDeLuxo)
                .append("\n}\n");
        return sb.toString();
    }

    @Override
    public double getCustoRealKM(){
        return custoRealKM() * this.taxaDeLuxo;
    }

    public void setPontosKm(int pontosKm){
        this.pontosKm = pontosKm;
    }

    public int getPontosKm(){
        return this.pontosKm;
    }
}
