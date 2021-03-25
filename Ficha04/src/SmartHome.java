import java.util.ArrayList;
import java.util.List;

public class SmartHome {
    List<Lamp> lamps;

    public SmartHome(List<Lamp> lamps) {
        this.setLamps(lamps);
    }

    public SmartHome(SmartHome s){
        this.setLamps(s.getLamps());
    }

    public SmartHome(){
        this.lamps = new ArrayList<>();
    }

    public String toString(){
        return this.lamps.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        SmartHome s = (SmartHome) o;
        return (this.lamps.equals(s.getLamps()));
    }

    public List<Lamp> getLamps() {
        return this.lamps;
    }

    public void setLamps(List<Lamp> lamps) {
        this.lamps = new ArrayList<Lamp>();
        for (Lamp l : lamps) this.lamps.add(l.clone());
    }

    public void addLamp(Lamp l){
        this.lamps.add(l);
    }

    public void tOnLampNormal (int index){
        this.lamps.get(index).lampOn();
    }

    public void tOnLampEco (int index){
        this.lamps.get(index).lampEco();
    }

    public int howMuchEco(){
        return (int) this.lamps.stream().filter(l -> l.getMode().equals(LampMode.ECO)).count();
    }

    public void removeLamp(int index){
        this.lamps.remove(index);
    }

    public void allEco(){
        this.lamps.forEach(Lamp::lampEco);
    }

    public void allMax(){
        this.lamps.forEach(Lamp::lampOn);
    }

    public double totalConsume(){
        double res = 0;
        for (Lamp l : this.lamps)
            res += l.getTotalConsume();
        return res;
    }

    public void reset(){
        this.lamps.forEach(Lamp::resetCons);
    }

}
