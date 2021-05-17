import java.util.*;
import java.util.stream.Collectors;

public class ListaEleitoral {
    private String partidoPolitico;
    private Set<Candidato> eleitos; // candidatos da lista já eleitos
    private List<Candidato> porEleger; // candidatos ainda por eleger

    public ListaEleitoral(String partidoPolitico, Collection<Candidato> candidatos){
        this.partidoPolitico = partidoPolitico;
        this.eleitos = new HashSet<>();
        this.porEleger = candidatos.stream().map(Candidato::clone).collect(Collectors.toList());
    }

    public Candidato aEleger(){
        Candidato ans = null;
        if(this.porEleger != null && !this.porEleger.isEmpty())
            ans = this.porEleger.get(0).clone();
        return ans;
    }

    public void elege(){
        if(this.porEleger != null && !this.porEleger.isEmpty())
            this.eleitos.add(this.porEleger.remove(0));
    }

    public void elege(int n){
        boolean flag = true;
        List<Candidato> novosCands = new ArrayList<>();
        for(int i = 0; i < n && flag; i++){
            if(this.porEleger == null || this.porEleger.get(i) == null)
                flag = false;
        }
        if(flag)
            for(int j = 0; j < n; j++)
                elege();
    }

    public Collection<Candidato> candidatos(){
        Collection<Candidato> ans = new ArrayList<>();
        if(this.eleitos != null)
            for(Candidato c : this.eleitos)
                ans.add(c.clone());
        if(this.porEleger != null)
            for(Candidato c : this.porEleger)
                ans.add(c.clone());
        return ans;
    }

    public TreeSet<Candidato> eleitos(){
        TreeSet<Candidato> ans = new TreeSet<>();
        if(this.eleitos != null)
            for(Candidato c : this.eleitos)
                ans.add(c.clone());
        return ans;
    }

    public TreeSet<Candidato> eleitosPorIdade(){
        TreeSet<Candidato> ans = new TreeSet<>(new Candidato.compareIdades());
        if(this.eleitos != null)
            for(Candidato c : this.eleitos)
                ans.add(c.clone());
        return ans;
    }

}
