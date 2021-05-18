import java.util.Comparator;

public class ComparaTipoArea implements Comparator<Imovel> {
    public int compare(Imovel i1, Imovel i2){
        int r = i1.getClass().getSimpleName().compareTo(i2.getClass().getSimpleName());

        if(r == 0)
            r = Double.compare(i1.getArea(), i2.getArea());

        return  r;
    }
}
