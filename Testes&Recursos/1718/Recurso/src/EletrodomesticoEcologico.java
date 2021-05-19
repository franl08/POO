import java.io.Serializable;
import java.time.LocalDateTime;

public class EletrodomesticoEcologico extends Eletrodomestico implements Serializable {

    public void setPeriodo(LocalDateTime don, LocalDateTime doff){
        if(LocalDateTime.now().isAfter(don) && LocalDateTime.now().isBefore(doff)) this.EletrodomesticoON();
        else this.EletrodomesticoOFF();
    }

}
