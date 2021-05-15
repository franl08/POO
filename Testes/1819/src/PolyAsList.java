import java.util.List;

public class PolyAsList implements Poly{
    private List<Double> polyn;

    public void addMonomio(double coef, int grau){
        if(polyn.size() > grau){
            double tmp = polyn.get(grau) + coef;
            polyn.set(grau, tmp);
        }
        else{
            for(int i = polyn.size() - 1; i < grau; i++)
                polyn.add(0.0);
            polyn.add(coef);
        }
    }

    public double calcula(double x){
        double res = 0;
        for(int i = 0; i < polyn.size(); i++)
            res += polyn.get(i) * Math.pow(x, i);
        return res;
    }

    public Poly derivada(){
        Poly p = new PolyAsList();
        for(int i = 0; i < polyn.size(); i++)
            p.addMonomio(polyn.get(i) * i, i - 1);
        return p;
    }
}
