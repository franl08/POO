public class SmartSpeaker extends SmartDevice{
    public static final int MAX = 20;
    private String channel;
    private int volume;

    public SmartSpeaker(){
        super();
        this.channel = "";
        this.volume = 0;
    }

    public SmartSpeaker(String id, boolean on, String channel, int volume){
        super(id, on);
        this.channel = channel;
        this.setVolume(volume);
    }

    public SmartSpeaker(String id, String channel, int volume){
        super(id);
        this.channel = channel;
        this.setVolume(volume);
    }

    public SmartSpeaker(String id){
        super(id);
        this.channel = "";
        this.volume = 0;
    }

    public SmartSpeaker(SmartSpeaker ss){
        super(ss.getID(), ss.getOn());
        this.setVolume(ss.getVolume());
        this.channel = ss.getChannel();
    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }

    public void setVolume(int volume){
        if (volume > 20) this.volume = 20;
        else this.volume = Math.max(volume, 0);
    }

    public int getVolume(){
        return this.volume;
    }

    public void setChannel(String channel){
        this.channel = channel;
    }

    public String getChannel(){
        return this.channel;
    }

    public void volumeUp(){
        if (this.volume < 20) this.volume++;
    }

    public void volumeDown(){
        if(this.volume > 0) this.volume--;
    }
}
