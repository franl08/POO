import java.util.*;
import java.util.stream.Collectors;

public class Grafo {
    private Map<Integer, Set<Integer>> adj; // "lista" de adjacência

    public Grafo() {
        this.adj = new HashMap<>();
    }

    public Grafo(Map<Integer, Set<Integer>> adj) {
        this.setAdj(adj);
    }

    public void setAdj(Map<Integer, Set<Integer>> adj) {
        this.adj = new HashMap<>();
        for (Integer aux : adj.keySet()) {
            Set<Integer> is = adj.get(aux);
            for (Integer i : is)
                this.adj.put(i, is);
        }
    }

    public void addArco(Integer vOrig, Integer vDest) {
        this.adj.putIfAbsent(vOrig, new HashSet<>());
        this.adj.putIfAbsent(vDest, new HashSet<>());
        this.adj.get(vOrig).add(vDest);
    }

    public boolean isSink(Integer v) {
        return this.adj.containsKey(v) && this.adj.get(v).isEmpty();
    }

    public boolean isSource(Integer v) {
        return this.adj.containsKey(v) && this.adj.values().stream().noneMatch(e -> e.contains(v));
    }

    public int size(){
        return this.adj.size() + this.adj.values().stream().mapToInt(Set::size).sum();
    }

    public boolean haCaminho(Integer vOrig, Integer vDest){
        return this.adj.containsKey(vOrig) && this.adj.get(vOrig).contains(vDest);
    }

    public List<Integer> getCaminho(Integer vOrig, Integer vDest){
        if(!this.adj.containsKey(vOrig)) return null;
        if(vOrig.equals(vDest)){
            List<Integer> l = new ArrayList<>();
            l.add(vOrig);
            return l;
        }
        for(Integer n : this.adj.get(vOrig)){
            if(haCaminho(n, vDest)){
                List<Integer> l = getCaminho(n, vDest);
                l.add(0, vOrig);
                return l;
            }
        }
        return  null;
    }

    public Set<Map.Entry<Integer, Integer>> fanOut(Integer v){
        return this.adj.get(v).stream().map(e -> new AbstractMap.SimpleEntry<>(v,e)).collect(Collectors.toSet());
    }

    public boolean subGrafo(Grafo g){
        return g.adj.keySet().containsAll(this.adj.keySet()) && g.adj.entrySet().stream().allMatch(e -> !this.adj.containsKey(e.getKey()) || e.getValue().containsAll(this.adj.get(e.getKey())));
    }

}