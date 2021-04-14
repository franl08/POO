import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CasaInteligente {
    private String address;
    private Set<SmartDevice> devices;
    private Set<String> rooms;
    private Map<String, Set<SmartDevice>> roomsNdevices;

    public CasaInteligente(){
        this.address = "";
        this.rooms = new HashSet<>();
        this.devices = new HashSet<>();
        this.roomsNdevices = new HashMap<>();
    }

    public CasaInteligente(String address){
        this.address = address;
        this.rooms = new HashSet<>();
        this.devices = new HashSet<>();
        this.roomsNdevices = new HashMap<>();
    }

    public boolean existsDevice(String id){
        for (SmartDevice sd : this.devices)
            if (sd.getID().equals(id)) return true;
        return false;
    }

    public void addDevice(SmartDevice sd){
        this.devices.add(sd.clone());
    }

    public SmartDevice getDevice(String id){
        for (SmartDevice sd : this.devices)
            if (sd.getID().equals(id)) return sd.clone();
        return null;
    }

    public void setAllOn(boolean on){
        for (SmartDevice sd : this.devices) sd.setOn(on);
    }

    public void addRoom(String name){
        this.rooms.add(name);
    }

    public boolean hasRoom(String name){
        return this.rooms.contains(name);
    }

    public void addToRoom(String name, String id){
        if(this.roomsNdevices.containsKey(name)) this.roomsNdevices.get(name).add(getDevice(id));
        else{
            Set<SmartDevice> sd = new HashSet<>();
            sd.add(getDevice(id));
            this.roomsNdevices.put(name, sd);
        }
    }

    public boolean roomHasDevice(String name, String id){
        if (this.roomsNdevices.containsKey(name)){
            for (SmartDevice sd : this.roomsNdevices.get(name))
                if (sd.getID().equals(id)) return true;
        }
        return false;
    }
}
