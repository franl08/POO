import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente implements Serializable {
    private String nome;
    private String codCliente;
    private Map<LocalDate, List<Exercicio>> meuExercicios;

    public Map<LocalDate, List<Exercicio>> getMeuExercicios(){
        Map<LocalDate, List<Exercicio>> ans = new HashMap<>();

        for(LocalDate l : this.meuExercicios.keySet()){
            List<Exercicio> toAdd = new ArrayList<>();
            for(Exercicio e : this.meuExercicios.get(l))
                toAdd.add(e.clone());
            ans.put(l, toAdd);
        }

        return ans;
    }

    public Map<String, List<Exercicio>> exerciciosPorProf(){
        Map<String, List<Exercicio>> ans = new HashMap<>();
        if(this.meuExercicios != null && !this.meuExercicios.isEmpty())
            for(List<Exercicio> es : this.meuExercicios.values())
                for(Exercicio e : es)
                    if(ans.containsKey(e.getProfessor()))
                        ans.get(e.getProfessor()).add(e.clone());
                    else{
                        List<Exercicio> toAdd = new ArrayList<>();
                        toAdd.add(e.clone());
                        ans.put(e.getProfessor(), toAdd);
                    }
        return ans;
    }
}
