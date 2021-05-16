import java.util.ArrayList;
import java.util.List;

public abstract class Poligono {
    List<Ponto> pontos;

    public Poligono(List<Ponto> pontos){
        this.setPontos(pontos);
    }

    public Poligono(){
        this.pontos = new ArrayList<>();
    }
    public Poligono(Poligono p){
        this.setPontos(p.getPontos());
    }

    public abstract Poligono clone();

    public List<Ponto> getPontos(){
        List<Ponto> ans = new ArrayList<>();
        if(this.pontos != null)
            for(Ponto p : this.pontos)
                ans.add(p.clone());
        return ans;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = new ArrayList<>();
        for(Ponto p : pontos)
            this.pontos.add(p.clone());
    }

    public boolean eFechada(){
        if(this.pontos == null) return false;
        else return(this.pontos.get(0).equals(this.pontos.get(this.pontos.size() - 1)));
    }

    public double perimetro(){
        double ans = 0;
        if(this.pontos != null)
            for(int i = 0; i < this.pontos.size() - 1; i++)
                ans += this.pontos.get(i).distancia(this.pontos.get(i + 1));
        return ans;
    }

    public abstract double area();
}
