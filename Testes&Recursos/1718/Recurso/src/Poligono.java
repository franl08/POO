import java.util.ArrayList;
import java.util.List;

public abstract class Poligono {
    private List<Ponto> pontos;

    public Poligono(){}
    public Poligono(List<Ponto> pts){}
    public List<Ponto> getPontos(){return new ArrayList<>();}
    public void addPonto(Ponto p){}
    public abstract double area();
}