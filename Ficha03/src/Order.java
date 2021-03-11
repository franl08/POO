import java.util.Date;
import java.util.ArrayList;

public class Order {
    private String name;
    private long nif;
    private String home;
    private long ordNumber;
    private Date ordDate;
    private ArrayList<OrderLine> lines;

    public Order(String name, long nif, String home, long ordNumber, Date ordDate, ArrayList<OrderLine> lines) {
        this.name = name;
        this.nif = nif;
        this.home = home;
        this.ordNumber = ordNumber;
        this.ordDate = ordDate;
        this.lines = lines;
    }

    public Order(){
        this.name = "";
        this.nif = 0;
        this.home = "";
        this.ordNumber = 0;
        this.ordDate = null;
        this.lines = new ArrayList<OrderLine>(0);
    }

    public Order(Order e){
        this.name = e.getName();
        this.nif = e.getNif();
        this.home = e.getHome();
        this.ordNumber = e.getOrdNumber();
        this.ordDate = e.getOrdDate();
        this.lines = new ArrayList<OrderLine>(e.getLines().size());
        for (OrderLine l : e.getLines()) this.lines.add(l);
    }

    public Order clone (Order e){
        return new Order(e);
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Order e = (Order) o;
        return (this.name.equals(e.getName()) && this.nif == e.getNif() && this.home.equals(e.getHome()) && this.ordNumber == e.getOrdNumber() && this.ordDate.equals(e.getOrdDate()) && this.lines.equals(e.getLines()));
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Order: {");
        sb.append("Name: ").append(name);
        sb.append(" | NIF: ").append(nif);
        sb.append(" | Home: ").append(home);
        sb.append(" | Order Number: ").append(ordNumber);
        if (this.ordDate != null) sb.append(" | Order Date: ").append(ordDate.toString());
        else sb.append(" | Order Date: Without Orders");
        sb.append(" | Lines: ").append(lines);
        sb.append("}");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public long getOrdNumber() {
        return ordNumber;
    }

    public void setOrdNumber(long ordNumber) {
        this.ordNumber = ordNumber;
    }

    public Date getOrdDate() {
        return ordDate;
    }

    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }

    public ArrayList<OrderLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<OrderLine> lines) {
        this.lines = new ArrayList<OrderLine>();
        for (OrderLine l : lines) this.lines.add(l);
    }

    public double totalValue() {
        double value = 0;
        for (int i = 0; i < this.lines.size(); i++) value += this.lines.get(i).orderLineValue();
        return value;
    }

    public double totalDiscount(){
        double value = 0;
        for (int i = 0; i < this.lines.size(); i++) value += this.lines.get(i).discountValue();
        return value;
    }

    public int totalProducts(){
        int total = 0;
        for (int i = 0; i < this.lines.size(); i++) total += this.lines.get(i).getQuantity();
        return total;
    }

    public boolean existsInOrder(String reference){
        boolean found = false;
        for (int i = 0; i < this.lines.size() && !found; i++)
            if (this.lines.get(i).getReference().equals(reference)) found = true;
        return found;
    }

    public void addLine(OrderLine line){
        this.lines.add(line);
    }

    public void removeProduct(String reference){
        boolean removed = false;
        for (int i = 0; i < this.lines.size() && !removed; i++){
            if (this.lines.get(i).getReference().equals(reference)) {
                this.lines.remove(i);
                removed = true;
            }
        }
    }
}
