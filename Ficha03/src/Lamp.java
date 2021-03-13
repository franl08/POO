public class Lamp  {
    private LampMode mode;
    private long tempConsume;
    private long totalConsume;
    private long initTime;
    private int consPerMs;

    public Lamp(LampMode mode, long tempConsume, long totalConsume) {
        this.mode = mode;
        this.initTime = System.nanoTime();
        this.tempConsume = tempConsume;
        this.totalConsume = totalConsume;
    }

    public Lamp(LampMode mode, long totalConsume) {
        this.mode = mode;
        this.initTime = System.nanoTime();
        this.tempConsume = 0;
        this.totalConsume = totalConsume;
    }
    public Lamp() {
        this.mode = LampMode.OFF;
        this.initTime = System.nanoTime();
        this.tempConsume = 0;
        this.totalConsume = 0;
    }

    public Lamp (Lamp l){
        this.mode = l.getMode();
        this.initTime = l.getInitTime();
        this.consPerMs = l.getConsPerMs();
        this.totalConsume = l.getTotalConsume();
        this.tempConsume = l.getTempConsume();
    }

    public LampMode getMode() {
        return this.mode;
    }

    public void setMode(LampMode mode) {
        this.mode = mode;
    }

    public long getTempConsume() {
        return this.tempConsume;
    }

    public void setTempConsume(long tempConsume) {
        this.tempConsume = tempConsume;
    }

    public long getTotalConsume() {
        return this.totalConsume;
    }

    public void setTotalConsume(long totalConsume) {
        this.totalConsume = totalConsume;
    }

    public long getInitTime() {
        return this.initTime;
    }

    public void setInitTime() {
        this.initTime = System.nanoTime();
    }

    public int getConsPerMs() {
        return this.consPerMs;
    }

    public void setConsPerMs(int consPerMs) {
        this.consPerMs = consPerMs;
    }

    public Lamp clone(Lamp l){
        return new Lamp(l);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lamp l = (Lamp) o;
        return (this.tempConsume == l.getTempConsume() && this.totalConsume == l.getTotalConsume() && this.consPerMs == l.getConsPerMs() && this.mode == l.getMode() && this.initTime == l.getInitTime());
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Lamp: {");
        sb.append("Mode: ").append(mode);
        sb.append(", Consume since last reset: ").append(tempConsume);
        sb.append(", Total Consume: ").append(totalConsume);
        sb.append(", Current consume per ms: ").append(consPerMs);
        sb.append("}");
        return(sb.toString());
    }

    public void lampOn(){
        updateCons();
        this.initTime = System.nanoTime();
        this.mode = LampMode.MAX;
        this.consPerMs = 2;
    }

    public void lampOff(){
        updateCons();
        this.initTime = System.nanoTime();
        this.mode = LampMode.OFF;
        this.consPerMs = 0;
    }

    public void lampEco(){
        updateCons();
        this.initTime = System.nanoTime();
        this.mode = LampMode.ECO;
        this.consPerMs = 1;
    }

    public void updateCons(){
        this.tempConsume += ((System.nanoTime() - this.initTime) / 1000 * this.consPerMs);
        this.totalConsume += ((System.nanoTime() - this.initTime) / 1000 * this.consPerMs);
    }

    public void resetCons(){
        this.tempConsume = 0;
    }

}
