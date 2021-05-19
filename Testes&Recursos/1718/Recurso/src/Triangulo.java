import java.util.List;

public class Triangulo extends PoligonoConvexo{

    public Triangulo(List<Ponto> pts) throws NaoConvexoException {
        super(pts);
    }

    public Triangulo(Ponto x, Ponto y, Ponto z){
        super();
        this.addPonto(x);
        this.addPonto(y);
        this.addPonto(z);
    }

    @Override
    public double area() {
        double a = this.getPontos().get(0).distancia(this.getPontos().get(1));
        double b = this.getPontos().get(1).distancia(this.getPontos().get(2));
        double c = this.getPontos().get(2).distancia(this.getPontos().get(0));
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
