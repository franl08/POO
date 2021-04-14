public class SmartBulb extends SmartDevice{
    public static final int NEUTRAL = 1;
    public static final int WARM = 2;
    public static final int COLD = 0;
    private int tone;

    public SmartBulb(){
        super();
        this.tone = NEUTRAL;
    }

    public SmartBulb(String id, boolean on, int tone){
        super(id, on);
        this.setTone(tone);
    }

    public SmartBulb(String id, int tone){
        super(id);
        this.setTone(tone);
    }

    public SmartBulb(String id){
        super(id);
        this.tone = NEUTRAL;
    }

    public SmartBulb(SmartBulb sb){
        super(sb.getID(), sb.getOn());
        this.setTone(sb.getTone());
    }

    public SmartBulb clone(){
        return new SmartBulb(this);
    }

    public void setTone(int tone){
        if (tone >= 2) this.tone = WARM;
        else if (tone <= 0) this.tone = COLD;
        else this.tone = NEUTRAL;
    }

    public int getTone(){
        return this.tone;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || o.getClass() != this.getClass()) return false;
        SmartBulb sb = (SmartBulb) o;
        return (this.tone == sb.getTone() && this.getID().equals(sb.getID()) && this.getOn() == sb.getOn());
    }
}
