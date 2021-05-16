import java.util.ArrayList;
import java.util.List;

public class Triangulo extends Poligono{

    public Triangulo(List<Ponto> pontos) {
        super(pontos);
    }

    public Triangulo(Ponto x, Ponto y, Ponto z){
        super();
        List<Ponto> tmp = new ArrayList<>();
        tmp.add(x.clone()); tmp.add(y.clone()); tmp.add(z.clone());
        this.setPontos(tmp);
    }

    public double area(){
        double b = this.pontos.get(0).distancia(this.pontos.get(1));
        double a = this.pontos.get(1).distancia(this.pontos.get(2));
        return ((b*a)/2);
    }

    public Triangulo(Triangulo t){
        super(t.getPontos());
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }
}
