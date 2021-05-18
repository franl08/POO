import java.util.HashMap;
import java.util.Map;

public class PolyAsMap implements Poly{
    Map<Integer, Double> polin;

    public PolyAsMap(){
        this.polin = new HashMap<>();
    }

    public Map<Integer, Double> getPolin(){
        Map<Integer, Double> ans = new HashMap<>();
        for(Integer i : this.polin.keySet())
            ans.put(i, this.polin.get(i));
        return ans;
    }

    public void setPolin(Map<Integer, Double> polin){
        for(Integer i : polin.keySet())
            this.polin.put(i, polin.get(i));
    }

    public void addMonomio(int grau, double coeficiente){
        if(this.polin.isEmpty())
            for (int i = 0; i < grau; i++)
                this.polin.put(i, 0.0);

        else
            for(int i = polin.size(); i < grau; i++)
                this.polin.put(i, 0.0);

        this.polin.put(grau, coeficiente);
    }

    public double calcula(double x){
        double ans = 0.0;
        if(!this.polin.isEmpty()){
            for(int i = 0; i < this.polin.size(); i++)
                ans += this.polin.get(i) * Math.pow(x, i);
        }
        return ans;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = this.polin.size() - 1; i >= 0; i--){
            if(this.polin.get(i) > 0.0)
                sb.append("+").append(this.polin.get(i)).append("x^").append(i).append(" ");
            else
                sb.append(this.polin.get(i)).append("x^").append(i).append(" ");
        }
        return sb.toString();
    }
}
