import java.time.LocalDate;
import java.util.Comparator;

public class ComparaDatas implements Comparator<Fatura> {

    public int compare(Fatura a, Fatura b){
        LocalDate c = a.getData();
        LocalDate d = b.getData();

        return c.compareTo(d);
    }
}
