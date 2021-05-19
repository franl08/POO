import java.util.ArrayList;
import java.util.List;

public class PoligonoConvexo extends Poligono{

    public PoligonoConvexo(List<Ponto> pts) throws NaoConvexoException{
        super(pts);
        if(!this.eConvexo()) throw new NaoConvexoException();
    }

    public PoligonoConvexo() {

    }

    public double area() {
        return 0;
    }

    // DEVE ESTAR ERRADO!!!
    public List<Triangulo> triangula(){
        List<Triangulo> tris = new ArrayList<>();
        for(int i = 0; i < this.getPontos().size();){
            Ponto x = this.getPontos().get(i++).clone();
            Ponto y = this.getPontos().get(i++).clone();
            Ponto z = this.getPontos().get(i++).clone();
            Triangulo t = new Triangulo(x, y, z);
            tris.add(t);
        }
        return tris;
    }

    public boolean eConvexo(){return false;}
}
