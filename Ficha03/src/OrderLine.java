import javax.management.Descriptor;

public class OrderLine {
    private String reference;
    private String description;
    private double origPrice;
    private long quantity;
    private int tax;
    private int discount;

    public OrderLine(String reference, String description, double origPrice, long quantity, int tax, int discount) {
        this.reference = reference;
        this.description = description;
        this.origPrice = origPrice;
        this.quantity = quantity;
        this.tax = tax;
        this.discount = discount;
    }

    public OrderLine() {
        this.reference = "";
        this.description = "";
        this.origPrice = 0;
        this.quantity = 0;
        this.tax = 0;
        this.discount = 0;
    }

    public OrderLine (OrderLine ol){
        this.reference = ol.getReference();
        this.description = ol.getDescription();
        this.origPrice = ol.getOrigPrice();
        this.quantity = ol.getQuantity();
        this.tax = ol.getTax();
        this.discount = ol.getDiscount();
    }

    public OrderLine clone (OrderLine ol){
        return new OrderLine(ol);
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Order Line: {");
        sb.append("Reference: ").append(reference);
        sb.append(" | Description: ").append(description);
        sb.append(" | Price without taxes: ").append(origPrice);
        sb.append("€ | Tax: ").append(tax);
        sb.append("% | Seller Discount: ").append(discount);
        sb.append("%}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        OrderLine x = (OrderLine) o;
        return (this.reference.equals(x.getReference()) && this.description.equals(x.getDescription()) && this.origPrice == x.getOrigPrice() && this.tax == x.getTax() && this.discount == x.getDiscount());
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOrigPrice() {
        return this.origPrice;
    }

    public void setOrigPrice(double origPrice) {
        this.origPrice = origPrice;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public int getTax() {
        return this.tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double orderLineValue(){
        double disc = this.origPrice * this.discount / 100;
        double price = this.origPrice * this.tax / 100;
        return this.quantity * (price - disc);
    }

    public double discountValue(){
        return this.quantity * (this.origPrice * this.discount / 100);
    }
}
