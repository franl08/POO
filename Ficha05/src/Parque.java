import java.util.*;
import java.util.stream.Collectors;

public class Parque {
    private String name;
    private Map<String, Lugar> assocs;

    public Parque(){
        this.name = "";
        this.assocs = new HashMap<>();
    }

    public Parque(String name, Map<String, Lugar> assocs){
        this.name = name;
        this.setAssocs(assocs);
    }

    public Parque(Parque p){
        this.name = p.getName();
        this.setAssocs(p.getAssocs());
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAssocs(Map<String, Lugar> assocs){
        this.assocs = new HashMap<>();
        for(Map.Entry<String, Lugar> a : assocs.entrySet())
                this.assocs.put(a.getKey(), a.getValue().clone());
    }

    public Map<String, Lugar> getAssocs(){
        return this.assocs.entrySet().stream().collect(Collectors.toMap(t -> t.getValue().getMatricula(), t -> t.getValue().clone()));
    }

    public Set<String> matriculaOcupados(){
        Set<String> ans = new HashSet<>();
        for(Map.Entry<String, Lugar> m : this.assocs.entrySet())
            ans.add(m.getKey());
        return ans;
    }

    public void novoOcupado(Lugar l){
        this.assocs.put(l.getMatricula(), l);
    }

    public void removeLugar(String mat){
        this.assocs.remove(mat);
    }

    public void mudaTempo(String mat, int newTime){
        this.assocs.get(mat).setMinutos(newTime);
    }

    public int minutosTotais(){
        int ans = 0;
        for(Map.Entry<String, Lugar> m : this.assocs.entrySet())
            ans += m.getValue().getMinutos();
        return ans;
    }

    public boolean existMat(String mat){
        return this.assocs.containsKey(mat);
    }

    public List<String> tempMaiorEPerm(int t){
        List<String> st = new ArrayList<>();
        for(Map.Entry<String, Lugar> m : this.assocs.entrySet())
            if(m.getValue().getPermanente())
                if(m.getValue().getMinutos() > t) st.add(m.getKey());
        return st;
    }

    public Map<String, Lugar> copiaLugares(){
        Map<String, Lugar> cp = new HashMap<>();
        for(Map.Entry<String, Lugar> m : this.assocs.entrySet())
            cp.put(m.getKey(), m.getValue().clone());
        return cp;
    }

    public Lugar infMatricula(String mat){
        return this.assocs.get(mat).clone();
    }
}
