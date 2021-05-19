public class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Ponto(Ponto p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public Ponto clone(){
        return new Ponto(this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        else if(o == null || o.getClass() != this.getClass()) return false;
        Ponto p = (Ponto) o;
        return(p.getX() == this.x && p.getY() == this.y);
    }

    public double distancia(Ponto p){
        return Math.sqrt(Math.pow((p.getX() - this.x), 2) + Math.pow((p.getY() - this.y), 2));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}