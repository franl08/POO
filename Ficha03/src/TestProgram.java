import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert question number: ");
        int q = in.nextInt();
        switch(q){
            case 1:
                Circle circle1 = new Circle();
                System.out.println("Correct values: predefined circle, x = y = 0 && radius = 1");
                System.out.println(circle1.toString());
                double radius = 3.4, x = 2.9, y = 4.1;
                Circle circle2 = new Circle(2.9, 4.1, 3.4);
                System.out.println("Correct values: circle2, x = 2.9, y = 4.1, radius = 3.4");
                System.out.println(circle2.toString());
                System.out.println("Area = " + circle2.area() + ", Perimeter = " + circle2.perimeter());
                Circle circle3 = new Circle(circle2);
                System.out.println("Correct values: copy of circle2, x = 2.9, y = 4.1, radius = 3.4");
                System.out.println(circle3.toString());
                circle3.changeCenter(2, 3);
                System.out.println("Correct values: moved circle3, x = 2, y = 3, radius = 3.4");
                System.out.println(circle3.toString());
                circle3.setX(3);
                circle3.setY(7);
                circle3.setRadius(4);
                System.out.println("Correct values: setters circle3, x = 3, y = 7, radius = 4");
                System.out.println(circle3.toString());
                break;
            default:
                break;
        }
    }
}
