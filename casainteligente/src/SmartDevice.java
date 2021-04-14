public class SmartDevice {
    private String ID;
    private boolean on;

    public SmartDevice(){
        this.ID = "";
        this.on = false;
    }

    public SmartDevice(String ID){
        this.ID = ID;
        this.on = false;
    }

    public SmartDevice(String ID, boolean on){
        this.ID = ID;
        this.on = on;
    }

    public  SmartDevice(SmartDevice sd){
        this.setID(sd.getID());
        this.setOn(sd.getOn());
    }

    public SmartDevice clone(){
        return new SmartDevice(this);
    }

    public String getID(){
        return this.ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public boolean getOn(){
        return this.on;
    }

    public void setOn(boolean on){
        this.on = on;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        else if (o == null || o.getClass() != this.getClass()) return false;
        SmartDevice sd = (SmartDevice) o;
        return (this.ID.equals(sd.getID()) && this.on == sd.getOn());
    }
}
