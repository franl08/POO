import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private String nome;
    private String codCliente;
    private List<Aluguer> meusAlugueres;

    public List<Aluguer> getMeusAlugueres(){
        List<Aluguer> ans = new ArrayList<>();
        for(Aluguer a : this.meusAlugueres){
            ans.add(a.clone());
        }
        return ans;
    }

    public String getCodCliente(){
        return this.codCliente;
    }
}
