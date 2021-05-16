import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Contribuinte extends Entidade{
    private List<Contribuinte> dependentes;

    public Contribuinte(String nif, String nome, Map<LocalDate, Fatura> faturas, List<Contribuinte> dependentes) {
        super(nif, nome, faturas);
        this.dependentes = dependentes;
    }

    public Contribuinte(Contribuinte c){
        super(c.getNif(), c.getNome(), c.getFaturas());
        this.setDependentes(c.getDependentes());
    }

    public Contribuinte clone(){
        return new Contribuinte(this);
    }

    public List<Contribuinte> getDependentes(){
        List<Contribuinte> ans = new ArrayList<>();
        if(this.dependentes != null){
            ans.addAll(this.dependentes);
        }
        return ans;
    }

    public void setDependentes(List<Contribuinte> dependentes){
        if(dependentes != null)
            for(Contribuinte c : dependentes)
                this.dependentes.add(c.clone());
    }
}
