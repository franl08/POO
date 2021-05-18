import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParqueComRecusados extends Parque implements IParque{

    private Map<String, Set<String>> recusas;

    public Map<String, Set<String>> getRecusas(){
        Map<String, Set<String>> ans = new HashMap<>();
        if(this.recusas != null)
            for(String s : this.recusas.keySet())
                ans.put(s, this.recusas.get(s));
        return ans;
    }

    public void entra(String cartao, String matricula) throws SemPermissaoException{
        Set<String> toAdd;

        try{
            super.entra(cartao, matricula);
        }
        catch (SemPermissaoException s){
            toAdd = this.recusas.get(matricula);
            if(toAdd == null)
                toAdd = new HashSet<>();
            toAdd.add(cartao);
        }
    }
}
