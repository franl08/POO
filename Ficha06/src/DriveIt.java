import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DriveIt {
    private Map<String, Veiculo> veics;

    public DriveIt(){
        this.veics = new HashMap<>();
    }

    public DriveIt(Map<String, Veiculo> m){
        this.setVeics(m);
    }

    public DriveIt(DriveIt di){
        this.setVeics(di.getVeics());
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
        List<Veiculo> ans = new ArrayList<>();
        for(Map.Entry<String, Veiculo> m : this.veics.entrySet())
            ans.add(m.getValue());
        return ans;
    }

    public void adiciona(Set<Veiculo> vs){
        for(Veiculo v : vs)
            this.adiciona(v);
    }

    public void registarAluguer(String codVeiculo, int numKms){
        if(this.veics.get(codVeiculo) != null)
            this.veics.get(codVeiculo).addViagem(numKms);
    }

    public void classificarVeiculo(String cod, int classificacao){
        if(this.veics.get(cod) != null)
            this.veics.get(cod).addClassificacao(classificacao);
    }

    public int custoRealKm(String cod){
        return (int) this.veics.get(cod).custoRealKM();
    }

}

