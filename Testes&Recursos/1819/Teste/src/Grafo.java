import java.util.*;

public class Grafo {
    private Map<String, Set<String>> adj;

    public void addArco(String vOrigem, String vDest){
        Set<String> s1, s2;
        s1 = adj.get(vOrigem);
        s2 = adj.get(vDest);

        if(s1 == null) s1 = new HashSet<>();

        if(s2 == null) s2 = new HashSet<>();

        s1.add(vDest);

        adj.put(vOrigem, s1);
        adj.put(vDest, s2);
    }

    public int size(){
        int ans = 0;
        int m = 0;
        if(!adj.isEmpty()){
            for(String s : adj.keySet())
                m += adj.get(s).size();
            ans = m + adj.size();
        }
        return ans;
    }

    public boolean haCaminho(String vOrigem, String vDest){
        boolean ans = adj.containsKey(vOrigem) && adj.containsKey(vDest);

        if(ans){
            ans = false;
            String act;
            Set<String> tmp, visitados = new HashSet<>();
            List<String> porVisitar = new ArrayList<>();

            porVisitar.add(vOrigem);

            while(porVisitar.size() > 0 && !ans){
                act = porVisitar.remove(0);
                visitados.add(act);
                tmp = adj.get(act);

                if(tmp.contains(vDest)) ans = true;

                else{
                    porVisitar.addAll(tmp);
                }
            }
        }

        return ans;
    }
}
