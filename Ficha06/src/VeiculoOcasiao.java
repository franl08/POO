import java.util.ArrayList;
import java.util.Map;

public class VeiculoOcasiao extends Veiculo{
    private boolean emDesconto;

    public VeiculoOcasiao(){
        super();
        this.emDesconto = false;
    }

    public VeiculoOcasiao(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
        this.emDesconto = false;
    }

    public VeiculoOcasiao(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, boolean emDesconto) {
        super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
        this.emDesconto = emDesconto;
    }

    public VeiculoOcasiao(Veiculo v, boolean emDesconto) {
        super(v);
        this.emDesconto = emDesconto;
    }

    public VeiculoOcasiao(Veiculo v) {
        super(v);
        this.emDesconto = false;
    }

    public VeiculoOcasiao(VeiculoOcasiao vo){
        super(vo.getMarca(), vo.getModelo(), vo.getMatricula(), vo.getAno(), vo.getVelociademedia(), vo.getPrecokm(), vo.getClassificacao(), vo.getKms(), vo.getKmsUltimo());
        this.emDesconto = vo.getEmDesconto();
    }

    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return (super.equals(o) && this.emDesconto == vo.getEmDesconto());
    }

    public boolean getEmDesconto(){
        return this.emDesconto;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Ocasião:{\n")
                .append(super.toString())
                .append("\nEm desconto: ").append(emDesconto)
                .append("\n}\n");
        return sb.toString();
    }

    public void setEmDesconto(boolean emDesconto){
        this.emDesconto = emDesconto;
    }

    @Override
    public double getCustoRealKM(){
        return(emDesconto ? custoRealKM() * 0.75 : custoRealKM());
    }
}
