import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FamiliaNumerosa extends Contribuinte implements Bonificado{

    public FamiliaNumerosa(String nif, String nome, Map<LocalDate, Fatura> faturas, List<Contribuinte> dependentes) {
        super(nif, nome, faturas, dependentes);
    }

    public double reducaoImposto() {
        return 0;
    }
}
