public class Car {
    private CarState state;
    private String brand;
    private String model;
    private int year;
    private double consume;
    private long totalKm;
    private double averageConsume;
    private long lastKm;
    private double lastAverage;
    private int regeneration;

    public Car(String brand, String model, int year, double consume, int regeneration) {
        this.state = CarState.OFF;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.consume = consume;
        this.totalKm = 0;
        this.averageConsume = 0;
        this.lastKm = 0;
        this.lastAverage = 0;
        this.regeneration = regeneration;
    }

    public Car(CarState state, String brand, String model, int year, double consume, long totalKm, double averageConsume, long lastKm, double lastAverage, int regeneration) {
        this.state = state;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.consume = consume;
        this.totalKm = totalKm;
        this.averageConsume = averageConsume;
        this.lastKm = lastKm;
        this.lastAverage = lastAverage;
        this.regeneration = regeneration;
    }

    public Car (Car c){
        this.state = c.getState();
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.year = c.getYear();
        this.consume = c.getConsume();
        this.totalKm = c.getTotalKm();
        this.averageConsume = c.getAverageConsume();
        this.lastKm = c.getLastKm();
        this.lastAverage = c.getLastAverage();
        this.regeneration = c.getRegeneration();
    }

    public Car clone(Car c){
        return (new Car(c));
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Car: {");
        sb.append("State: ").append(state);
        sb.append(", Brand: ").append(brand);
        sb.append(", Model: ").append(model);
        sb.append(", Year: ").append(year);
        sb.append(", Consume: ").append(consume);
        sb.append(", TotalKm: ").append(totalKm);
        sb.append(", AverageConsume: ").append(averageConsume);
        sb.append(", Last Trip Km: ").append(lastKm);
        sb.append(", Last Trip Average Consume: ").append(lastAverage);
        sb.append(", Energy Regeneration: ").append(regeneration);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Car c = (Car) o;
        return (this.state == c.getState() && this.brand.equals(c.getBrand()) && this.model.equals(c.getModel()) && this.year == c.getYear() && this.consume == c.getConsume()
                && this.totalKm == c.getTotalKm() && this.averageConsume == c.getAverageConsume() && this.lastKm == c.getLastKm() && this.lastAverage == c.getLastAverage()
                && this.regeneration == c.getRegeneration());
    }

    public CarState getState() {
        return this.state;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getConsume() {
        return this.consume;
    }

    public void setConsume(double consume) {
        this.consume = consume;
    }

    public long getTotalKm() {
        return this.totalKm;
    }

    public void setTotalKm(long totalKm) {
        this.totalKm = totalKm;
    }

    public double getAverageConsume() {
        return this.averageConsume;
    }

    public void setAverageConsume(double averageConsume) {
        this.averageConsume = averageConsume;
    }

    public long getLastKm() {
        return this.lastKm;
    }

    public void setLastKm(long lastKm) {
        this.lastKm = lastKm;
    }

    public double getLastAverage() {
        return this.lastAverage;
    }

    public void setLastAverage(double lastAverage) {
        this.lastAverage = lastAverage;
    }

    public int getRegeneration() {
        return this.regeneration;
    }

    public void setRegeneration(int regeneration) {
        this.regeneration = regeneration;
    }

    public void turnOn(){
        this.state = CarState.ON;
        this.resetLastTrip();
    }

    public void turnOff(){
        this.state = CarState.OFF;
    }

    public void resetLastTrip(){
        this.lastKm = 0;
        this.lastAverage = 0;
    }

    public void moveCar(double meters, double vel){
        if (this.state == CarState.ON){
            double km = meters / 1000;
            double cons = km * ((vel * this.consume) / 100);
            this.lastKm += km;
            this.totalKm += km;
            this.averageConsume += cons / km;
            this.lastAverage += cons / km;
        }
    }

    public void breakCar(double meters){
        if (this.state == CarState.ON){
            double km = meters / 1000;
            double reg = this.regeneration * km;
            this.lastKm += km;
            this.totalKm += km;
            this.averageConsume -= (reg / km);
            this.lastAverage = (reg / km);
        }
    }
}
