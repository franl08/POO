import java.lang.reflect.Array;
import java.util.ArrayList;

public class Phone {
    private String brand;
    private String model;
    private int displayX;
    private int displayY;
    private long messageStorage;
    private long photoStorage;
    private long appStorage;
    private long appAndPhotoStorage = appStorage + photoStorage;
    private long usedStorage;
    private long nPhotos;
    private int nApps;
    private ArrayList<String> appsName;
    private ArrayList<String> messages;

    public Phone(String brand, String model, int displayX, int displayY, long messageStorage, long photoStorage, long appStorage, ArrayList<String> appsName) {
        this.brand = brand;
        this.model = model;
        this.displayX = displayX;
        this.displayY = displayY;
        this.messageStorage = messageStorage;
        this.photoStorage = photoStorage;
        this.appStorage = appStorage;
        this.nPhotos = 0;
        this.nApps = 0;
        this.usedStorage = 0;
        this.appsName = new ArrayList<String>(nApps);
        this.messages = new ArrayList<String>(messages.size());
    }

    public Phone(String brand, String model, int displayX, int displayY, long messageStorage, long photoStorage, long appStorage, long usedStorage, long nPhotos, int nApps, ArrayList<String> appsName, ArrayList<String> messages) {
        this.brand = brand;
        this.model = model;
        this.displayX = displayX;
        this.displayY = displayY;
        this.messageStorage = messageStorage;
        this.photoStorage = photoStorage;
        this.appStorage = appStorage;
        this.usedStorage = usedStorage;
        this.nPhotos = nPhotos;
        this.nApps = nApps;
        this.appsName = new ArrayList<String>(nApps);
        for (String app : appsName) appsName.add(app);
        this.messages = new ArrayList<String>(messages.size());
        for(String msg : messages) messages.add(msg);
    }

    public Phone(Phone phone){
        this.brand = phone.getBrand();
        this.model = phone.getModel();
        this.displayX = phone.getDisplayX();
        this.displayY = phone.getDisplayY();
        this.messageStorage = phone.getMessageStorage();
        this.photoStorage = phone.getPhotoStorage();
        this.appStorage = phone.getAppStorage();
        this.nPhotos = phone.getNPhotos();
        this.nApps = phone.getNApps();
        this.appsName = new ArrayList<String>(nApps);
        for (String app : phone.appsName) this.appsName.add(app);
        this.messages = new ArrayList<String>(messages.size());
        for(String msg : phone.messages) this.messages.add(msg);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplayX() {
        return displayX;
    }

    public void setDisplayX(int displayX) {
        this.displayX = displayX;
    }

    public int getDisplayY() {
        return displayY;
    }

    public void setDisplayY(int displayY) {
        this.displayY = displayY;
    }

    public long getMessageStorage() {
        return messageStorage;
    }

    public void setMessageStorage(long messageStorage) {
        this.messageStorage = messageStorage;
    }

    public long getPhotoStorage() {
        return photoStorage;
    }

    public void setPhotoStorage(long photoStorage) {
        this.photoStorage = photoStorage;
    }

    public long getAppStorage() {
        return appStorage;
    }

    public void setAppStorage(long appStorage) {
        this.appStorage = appStorage;
    }

    public long getUsedStorage() {
        return usedStorage;
    }

    public void setUsedStorage(long usedStorage) {
        this.usedStorage = usedStorage;
    }

    public long getNPhotos() {
        return nPhotos;
    }

    public void setNPhotos(long nPhotos) {
        this.nPhotos = nPhotos;
    }

    public int getNApps() {
        return nApps;
    }

    public void setNApps(int nApps) {
        this.nApps = nApps;
    }

    public ArrayList getAppsName(){
        return this.appsName;
    }

    public void setAppsName(ArrayList<String> appsName){
        this.appsName = new ArrayList<String>(this.nApps);
        for(String app : appsName) this.appsName.add(app);
    }

    public ArrayList getMessages(){
        return this.messages;
    }

    public void setMessages(ArrayList<String> messages){
        this.messages = new ArrayList<String>(messages.size());
        for (String msg : messages) this.messages.add(msg);
    }

    public Phone clone(Phone phone){
        return (new Phone(this));
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Phone = {");
        sb.append("Brand = ").append(brand);
        sb.append(", Model = ").append(model);
        sb.append(", Display = ").append(displayX);
        sb.append("X").append(displayY);
        sb.append(", StorageMessages = ").append(messageStorage);
        sb.append(", StorageApps&&Photos = ").append(appAndPhotoStorage);
        sb.append(", StoragePhotos = ").append(photoStorage);
        sb.append(", StorageApps = ").append(appStorage);
        sb.append(", UsedStorage = ").append(usedStorage);
        sb.append(", NumberOfPhotos = ").append(nPhotos);
        sb.append(", NumberOfApps = ").append(nApps);
        sb.append(", AppsNames = ").append(appsName.toString());
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Phone p = (Phone) o;
        return (this.getBrand().equals(p.getBrand()) && this.getAppStorage() == p.getAppStorage() && this.getMessageStorage() == p.getMessageStorage()
        && this.getDisplayX() == p.getDisplayX() && this.getDisplayY() == p.getDisplayY() && this.getAppsName().toString().equals(this.getAppsName().toString()) && this.getMessages().toString().equals(p.getMessages().toString())
        && this.getNApps() == p.getNApps() && this.getNPhotos() == p.getNPhotos() && this.getModel().equals(p.getModel()) && this.getPhotoStorage() == p.getPhotoStorage() && this.getUsedStorage() == p.getUsedStorage());
    }
    public boolean haveSpace(int nBytes){
        return (nBytes + this.usedStorage < this.appAndPhotoStorage + this.messageStorage);
    }

    public void installApp (String name, int size){
        this.nApps++;
        this.appStorage += size;
        this.appsName.add(name);
    }

    public void newMsg(String msg){
        this.messageStorage += msg.length();
        this.messages.add(msg);
    }

    public double averageAppSize(){
        double res = (double) this.appStorage / this.nApps;
        return res;
    }

    public String biggestMsg(){
        int biggest = Integer.MIN_VALUE;
        String answer = "";
        for (String msg : this.messages)
            if(msg.length() > biggest){
                answer = msg;
                biggest = msg.length();
            }
        return answer;
    }

    public void removeApp(String name, int size){
        this.appStorage -= size;
        this.nApps--;
        this.appsName.remove(name);
    }
}
