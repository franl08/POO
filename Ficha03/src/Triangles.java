public class Triangles {
    private Points p1;
    private Points p2;
    private Points p3;

    public Triangles(){
        this.p1 = new Points();
        this.p2 = new Points();
        this.p3 = new Points();
    }

    public Triangles(Points t, Points r, Points i){
        this.p1 = t;
        this.p2 = r;
        this.p3 = i;
    }

    public Triangles(Triangles t){
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public Triangles clone(Triangles t){
        return new Triangles(t);
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Triangle: {");
        sb.append("First Point: ").append(this.p1.toString());
        sb.append(" | Second Point: ").append(this.p2.toString());
        sb.append(" | Third Point: ").append(this.p3.toString());
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || this.getClass() != o.getClass());
        Triangles t = (Triangles) o;
        return ((this.p1.equals(t.getP1()) || this.p1.equals(t.getP2()) || this.p1.equals(t.getP3()))
                && (this.p2.equals(t.getP2()) || this.p2.equals(t.getP3()) || this.p2.equals(t.getP1()))
                && (this.p3.equals((t.getP3())) || this.p3.equals(t.getP2()) || this.p3.equals(t.getP1())));
    }

    public Points getP1() {
        return p1;
    }

    public void setP1(Points p1) {
        this.p1 = p1;
    }

    public Points getP2() {
        return p2;
    }

    public void setP2(Points p2) {
        this.p2 = p2;
    }

    public Points getP3() {
        return p3;
    }

    public void setP3(Points p3) {
        this.p3 = p3;
    }

    public double area(){
        double dis1 = p1.distancia(p2);
        double dis2 = p2.distancia(p3);
        double dis3 = p3.distancia(p1);
        double temp = (dis1 + dis2 + dis3) / 2;
        return Math.sqrt(temp * (temp - dis1) * (temp - dis2) * (temp - dis3));
    }

    public double perimeter(){
        double dis1 = p1.distancia(p2);
        double dis2 = p2.distancia(p3);
        double dis3 = p3.distancia(p1);
        return (dis1 + dis2 + dis3);
    }

    public double height(){
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        double[] ys = {p1.getY(), p2.getY(), p3.getY()};
        for (double y: ys){
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }
        return maxY - minY;
    }
}
