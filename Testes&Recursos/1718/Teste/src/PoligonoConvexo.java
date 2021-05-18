import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoligonoConvexo{
    List<Poligono> pols;


    public PoligonoConvexo(List<Poligono> pols) {
        this.setPols(pols);
    }

    public PoligonoConvexo(PoligonoConvexo p){
        this.setPols(p.getPols());
    }

    public Map<Poligono, Double> area(){
        Map<Poligono, Double> ans = new HashMap<>();
        if(this.pols != null){
            for(Poligono p : this.pols)
                ans.put(p.clone(), p.area());
        }
        return ans;
    }

    public PoligonoConvexo clone(){
        return new PoligonoConvexo(this);
    }


    public List<Poligono> getPols(){
        List<Poligono> ans = new ArrayList<>();
        if(this.pols != null)
            for(Poligono p : this.pols)
                ans.add(p.clone());
        return ans;
    }

    public void setPols(List<Poligono> pols){
        this.pols = new ArrayList<>();
        if(pols != null)
            for(Poligono p : pols)
                this.pols.add(p.clone());
    }
}
