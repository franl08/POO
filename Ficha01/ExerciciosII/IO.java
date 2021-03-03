package ExerciciosII;

import java.util.Scanner;
import java.util.Date;

// Exercise doesn't work 100% correctly, because 5000! is too big.
public class IO {

    public static void celToFar(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert a temperature in Celsius degrees: ");
        double celsius = input.nextDouble();
        double far = Problems.celsiusToFarenheit(celsius);
        System.out.println("Your temperature in Farenheit is: " + far + " degrees");
        input.close();
    }
    
    public static void max2Nums(){
        Scanner input = new Scanner (System.in);
        System.out.println("Please insert one integer: ");
        int num1 = input.nextInt();
        System.out.println("Please insert other integer: ");
        int num2 = input.nextInt();
        int res = Problems.max(num1, num2);
        System.out.println("The biggest number between those two is: " + res);
        input.close();
    }

    public static void account(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert your account name: ");
        String name = input.nextLine();
        System.out.println("Please insert yout account balance: ");
        int balance = input.nextInt();
        String res = Problems.createState(name, balance);
        System.out.println(res);
        input.close();
    }

    public static void euroToPounds(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert a value in Euros: ");
        double euro = input.nextDouble();
        System.out.println("Please insert a tax rate: ");
        double tax = input.nextDouble();
        double res = Problems.convertEuros(euro, tax);
        System.out.println("Your value with your tax rate is: " + res);
        input.close();
    }

    public static void orderAndAverage(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert an integer: ");
        int num1 = input.nextInt();
        System.out.println("Please insert another integer: ");
        int num2 = input.nextInt();
        String res = Problems.ordAver(num1, num2);
        System.out.println(res);
        input.close();
    }

    public static void factorial(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert a non-negative integer: ");
        long num = input.nextLong();
        if (num < 0){
            System.out.println("The inserted number is negative.");
            return;
        }
        long res = Problems.fact(num);
        System.out.println("The factorial is: " + res);
        input.close();
    }

    public static void wastedTime(){
        Date actualDate = new Date();
        System.out.println("Date before calculate the factorial: " + actualDate);
        long start = System.currentTimeMillis();
        long res = Problems.fact(5000);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("The factorial of 5000 is " + res + " and it took " + elapsed + " ms to calculate it.");
    }
    public static void main(String[] args){
        int test = Integer.parseInt(args[0]);
        switch(test){
            case 1:
                celToFar();
                break;
            case 2:
                max2Nums();
                break;
            case 3:
                account();
                break;
            case 4:
                euroToPounds();
                break;
            case 5:
                orderAndAverage();
                break;
            case 6:
                factorial();
                break;
            case 7:
                wastedTime();
                break;
            default:
                break;
        }
    }
}
