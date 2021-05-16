import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Negocio implements Serializable {
    private Map<String, Contribuinte> contribuintes;

    public Map<String, Contribuinte> getContribuintes(){
        Map<String, Contribuinte> ans = new HashMap<>();
        if(this.contribuintes != null){
            for(String s : this.contribuintes.keySet())
                ans.put(s, this.contribuintes.get(s).clone());
        }
        return ans;
    }

    public void printFamiliasNumerosas(String nomeFich) throws IOException {
        PrintWriter file = new PrintWriter(nomeFich);

        for (Contribuinte c : this.contribuintes.values()) {
            if (c instanceof FamiliaNumerosa) {
                file.write("Nome: " + c.getNome() + c.getNif() + ((FamiliaNumerosa) c).reducaoImposto());
            }
        }

        file.flush();
        file.close();
    }
}
