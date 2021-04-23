import java.util.*;
import java.util.stream.Collectors;

public class DriveIt {
    private Map<String, Veiculo> veics;
    public boolean desconto;

    public DriveIt(){
        this.veics = new HashMap<>();
        this.desconto = false;
    }

    public DriveIt(Map<String, Veiculo> m, boolean desconto){
        this.setVeics(m);
        this.desconto = desconto;
    }

    public DriveIt(Map<String, Veiculo> m){
        this.setVeics(m);
        this.desconto = false;
    }

    public DriveIt(DriveIt di){
        this.setVeics(di.getVeics());
        this.desconto = di.getDesconto();
    }

    public DriveIt clone(){
        return new DriveIt(this);
    }

    public void setVeics(Map<String, Veiculo> m){
        this.veics = new HashMap<>();
        for(Map.Entry<String, Veiculo> me : m.entrySet())
            this.veics.put(me.getKey(), me.getValue());
    }

   public Map<String, Veiculo> getVeics(){
        return this.veics.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public boolean getDesconto() {
        return this.desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        DriveIt di = (DriveIt) o;
        return (veics.equals(di.getVeiculos()));
    }

    public boolean existeVeiculo(String cod){
        return this.veics.containsKey(cod);
    }

    public int quantos(){
        return this.veics.size();
    }

    public Veiculo getVeiculo(String cod){
        return this.veics.get(cod);
    }

    public void adiciona(Veiculo v){
        this.veics.put(v.getMatricula(), v);
    }

    public List<Veiculo> getVeiculos(){
        return new ArrayList<>(this.veics.values());
    }

    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v : vs)
            this.adiciona(v.clone());
    }

    public void registarAluguer(String codVeiculo, int numKms){
        if(this.veics.get(codVeiculo) != null)
            this.veics.get(codVeiculo).addViagem(numKms);
    }

    public void classificarVeiculo(String cod, int classificacao){
        if(this.veics.get(cod) != null && classificacao >= 0 && classificacao <= 10)
            this.veics.get(cod).addClassificacao(classificacao);
    }

    public int custoRealKm(String cod){
        return (int) this.veics.get(cod).getCustoRealKM();
    }

    public int quantosT(String tipo){
        int ans = 0;
        for(Map.Entry<String, Veiculo> m : this.veics.entrySet())
            if(m.getValue().getClass().toString().split(" ")[1].equals(tipo)) ans++;
        return ans;
    }

    public List<Veiculo> veiculosOrdenadosCusto(){
        return this.veics.values().stream().sorted(Comparator.comparingDouble(Veiculo::getPrecokm).reversed()).collect(Collectors.toList());
    }

    public Veiculo veiculoMaisBarato(){
        if(this.veics.size() > 0){
            List<Veiculo> vs = veiculosOrdenadosCusto();
            return vs.get(vs.size() - 1);
        }
        return null;
    }

    public Veiculo menosUtilizado(){
        if(this.veics.size() > 0){
            int min = Integer.MAX_VALUE;
            Veiculo ans = null;
            for(Veiculo v : this.veics.values())
                if(v.getKms() < min){
                    min = v.getKms();
                    ans = v;
                }
            return ans;
        }
        return null;
    }

    public void alteraPromocao(boolean estado){
        this.setDesconto(estado);
        this.veics.values().stream().filter(v -> v instanceof VeiculoOcasiao).forEach(v -> ((VeiculoOcasiao)v).setEmDesconto(estado));
    }

    public void defOcupacao() {
        for (Veiculo v : this.veics.values())
            if (v.getClass().toString().split(" ")[1].equals("AutocarroInteligente")) {
                AutocarroInteligente ai = (AutocarroInteligente) v;
                ai.setOcupacao((int) (85 * ai.getLotacao()) / 100);
            }
    }

    public double valorMedioKM(){
        defOcupacao();
        int ac = 0;
        for(Veiculo v : this.veics.values())
            ac += v.getCustoRealKM();
        return (double) ac / this.veics.size();
    }
}

