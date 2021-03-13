import java.lang.Math;

/*
Class Circle for Exercise 1.
@author Francisco Neves
 */
public class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(Circle circle){
        this.x = circle.getX();
        this.y = circle.getY();
        this.radius = circle.getRadius();
    }

    public Circle clone(Circle circle){
        return new Circle (this);
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

    public double getRadius() {
        return this.radius;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || this.getClass() != o.getClass()) return false;
        Circle c = (Circle) o;
        return (this.x == c.getX() && this.y == c.getY() && this.radius == c.radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void changeCenter (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double area(){
        return (Math.PI * Math.pow(this.radius, 2));
    }

    public double perimeter(){
        return (2 * (Math.PI) * (this.radius));
    }

    public String toString(){
        final StringBuffer sb = new StringBuffer("Circle = {");
        sb.append("x = ").append(x);
        sb.append(", y = ").append(y);
        sb.append(", radius = ").append(radius);
        sb.append("}");
        return (sb.toString());
    }
}
