import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {
    TreeMap<String, Encomenda> encomendas;

    public GestaoEncomendas(){
        this.encomendas = new TreeMap<>();
    }

    public GestaoEncomendas(TreeMap<String, Encomenda> encomendas){
        this.setEncomendas(encomendas);
    }

    public GestaoEncomendas(GestaoEncomendas g){
        this.setEncomendas(g.getEncomendas());
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

    public void setEncomendas(Map<String, Encomenda> encomendas){
        this.encomendas = new TreeMap<>();
        for(String s : encomendas.keySet())
            this.encomendas.put(s, encomendas.get(s).clone());
    }

    public Map<String, Encomenda> getEncomendas(){
        Map<String, Encomenda> ans = new TreeMap<>();
        if(this.encomendas != null)
            for(String s : this.encomendas.keySet())
                ans.put(s, this.encomendas.get(s).clone());
        return ans;
    }

    public Set<String> todosCodigosEnc(){
        Set<String> ans = new HashSet<>();
        if(this.encomendas != null)
            ans.addAll(this.encomendas.keySet());
        return ans;
    }

    public void addEncomenda(Encomenda enc){
        if(this.encomendas == null) this.encomendas = new TreeMap<>();
        this.encomendas.put(enc.getIdEnc(), enc.clone());
    }

    public Encomenda getEncomenda(String codEnc){
        if(!this.encomendas.containsKey(codEnc)) return null;
        else{
            return this.encomendas.get(codEnc).clone();
        }
    }

    public void removeEncomenda(String codEnc){
        if(!this.encomendas.containsKey(codEnc)) return;
        this.encomendas.remove(codEnc);
    }

    public String encomendaComMaisProdutos(){
        int maxProds = 0;
        String cod = "n/a";
        if(this.encomendas != null)
            for(Encomenda e : this.encomendas.values())
                if(e.getEncomendas().size() > maxProds){
                    maxProds = e.getEncomendas().size();
                    cod = e.getIdEnc();
                }
        return cod;
    }

    public Set<String> encomendasComProduto(String codProd){
        Set<String> ans = new HashSet<>();
        for(Encomenda e : this.encomendas.values())
            for(LinhaEncomenda l : e.getEncomendas())
                if(l.getReferencia().equals(codProd))
                    ans.add(e.getIdEnc());
        return ans;
    }

    public Set<String> encomendasAposData(LocalDate ld){
        Set<String> ans = new HashSet<>();
        for(Encomenda e : this.encomendas.values())
            if(e.getData().isAfter(ld)) ans.add(e.getIdEnc());
        return ans;
    }

    public Set<Encomenda> encomendasValorDecrescente(){
        return this.encomendas.values().stream().sorted((e1, e2)->e2.getnEnc() - e1.getnEnc()).collect(Collectors.toSet());
    }

    public Map<String, List<String>> encomendasDeProduto(){
        Map<String, List<String>> ans = new HashMap<>();
        for(Encomenda e : this.encomendas.values())
            for(LinhaEncomenda l : e.getEncomendas())
                if(ans.containsKey(l.getReferencia()))
                    ans.get(l.getReferencia()).add(e.getIdEnc());
                else{
                    List<String> toAdd = new ArrayList<>();
                    toAdd.add(e.getIdEnc());
                    ans.put(l.getReferencia(), toAdd);
                }
        return ans;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        GestaoEncomendas ge = (GestaoEncomendas) o;
        return(this.encomendas.equals(ge.getEncomendas()));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Gestão de Encomendas:{\n")
                .append("Encomendas : ").append(encomendas.toString()).append("\n}");
        return sb.toString();
    }
}
