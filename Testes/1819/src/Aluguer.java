import java.io.Serializable;
import java.time.LocalDate;

public class Aluguer implements Serializable {
    private String codCliente;
    private String codImovel;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public String getCodImovel(){
        return this.codImovel;
    }
}
