package Ficha01.ExerciciosI;
import java.lang.Math;
import java.util.Scanner;

public class Tri {
    public static void per (double base, double height){
        double hip = Math.sqrt((base * base) + (height * height));
        double per = (base + height + hip);
        per = (double)Math.round(per * 100000d) / 100000d;
        System.out.println("Perimeter: " + per);
    }

    public static void area (double base, double height){
        double area = (base * height) / 2;
        area = (double)Math.round(area * 100000d) / 100000d;
        System.out.println("Area: " + area);
    }
    public static void main (String[] args){
        Scanner tri = new Scanner(System.in);
        while (true){
            System.out.println("Insert Base and Height: ");
            double base = tri.nextDouble();
            double height = tri.nextDouble();
            if (base != 0){
                per(base, height);
                area(base, height);
            }
            else break;
        }
    }
}
