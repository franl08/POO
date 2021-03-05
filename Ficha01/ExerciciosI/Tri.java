package Ficha01.ExerciciosI;
import java.util.Scanner;

public class Tri {
    public static void per (double base, double height){
        float hip = Math.sqrt((base * base) + (height * height));
        float per = (base + height + hip);
        System.out.printf("Perimeter: %.5f%n", per);
        
    }

    public static void area (double base, double height){
        float area = (base * height) / 2;
        System.out.printf("Area: %.5f%n", area);
    }
    public static void main (String[] args){
        Scanner tri = new Scanner(System.in);
        while (true){
            System.out.println("Insert Base and Height: ");
            float base = tri.nextFloat();
            float height = tri.nextFloat();
            if (base != 0){
                per(base, height);
                area(base, height);
            }
            else break;
        }
    }
}
