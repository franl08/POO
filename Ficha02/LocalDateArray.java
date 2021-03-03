import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class LocalDateArray {
    private LocalDate[] dates;
    private int numElems;

    public LocalDateArray(int size){
        this.dates = new LocalDate[size];
        this.numElems = 0;
    }

    public void insertDate(LocalDate date){
        if(this.numElems < this.dates.length) 
            this.dates[numElems++] = date;
    }

    public LocalDate closestDate(LocalDate date){
        long shortest = Math.abs(DAYS.between(date, dates[0]));
        LocalDate closest = this.dates[0];
        for (int i = 0; i < this.numElems; i++){
            LocalDate act = this.dates[i];
            long actDif = Math.abs(DAYS.between(date, dates[i]));
            if (actDif < shortest){
                shortest = actDif;
                closest = act;

            }
        }
        return closest;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < this.numElems; i++){
            LocalDate date = this.dates[i];
            sb.append(date.toString()).append("\n");
        }
        return sb.toString();
    }

}
