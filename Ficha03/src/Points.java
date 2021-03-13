public class Points {
    private double x;
    private double y;

    public Points(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Points() {
        this.x = 0;
        this.y = 0;
    }

    public Points(double x) {
        this.y = this.x = x;
    }

    public Points (Points p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public Points clone(Points p){
        return new Points(p);
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Point: {");
        sb.append("x: ").append(x);
        sb.append(" | y: ").append(y);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Points p = (Points) o;
        return (this.x == p.getX() && this.y == p.getY());
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void somaPonto (Points p){
        this.x += p.getX();
        this.y += p.getY();
    }
    public double distancia(Points p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) +
                Math.pow(this.y - p.getY(), 2));
    }
}
