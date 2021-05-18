import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entidade {
    private String nif;
    private String nome;
    private Map<LocalDate, Fatura> faturas;

    public Entidade(String nif, String nome, Map<LocalDate, Fatura> faturas){
        this.nif = nif;
        this.nome = nome;
        this.setFaturas(faturas);
    }

    public Entidade(Entidade e){
        this.nif = e.getNif();
        this.nome = e.getNome();
        this.setFaturas(e.getFaturas());
    }

    public void setFaturas(Map<LocalDate, Fatura> faturas){
        if(faturas != null){
            for(LocalDate ld : faturas.keySet())
                this.faturas.put(ld, faturas.get(ld).clone());
        }
    }

    public Map<LocalDate, Fatura> getFaturas(){
        Map<LocalDate, Fatura> ans = new HashMap<>();
        if(this.faturas != null){
            for(LocalDate ld : faturas.keySet())
                ans.put(ld, this.faturas.get(ld).clone());
        }
        return ans;
    }

    public String getNif(){
        return this.nif;
    }

    public String getNome(){
        return this.nome;
    }

    public Map<Actividade, List<Fatura>> porAtividade(){
        Map<Actividade, List<Fatura>> ans = new HashMap<>();
        if(this.faturas != null){
            for(Fatura f : this.faturas.values()){
                if(ans.containsKey(f.getActividade())) ans.get(f.getActividade()).add(f.clone());
                else{
                    List<Fatura> toAdd = new ArrayList<>();
                    toAdd.add(f.clone());
                    ans.put(f.getActividade(), toAdd);
                }
            }
        }
        return ans;
    }
}
