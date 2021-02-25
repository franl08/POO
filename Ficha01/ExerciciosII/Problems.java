package ExerciciosII;

public class Problems {

    // Exercise 1
    public static double celsiusToFarenheit(double celsius){
        return ((celsius * 1.8) + 32);
    }

    // Exercise 2
    public static int max(int a, int b){
        if (a > b) return a;
        else return b;
    }

    // Exercise 3
    public static String createState(String name, double balance){
        return("Account name: " + name + "; Balance: " + balance);
    }

    // Exercise 4
    public static double convertEuros(double euros, double tax){
        return (euros * tax);
    }

    // Exercise 5
    public static String ordAver(int num1, int num2){
        int average = (num1 + num2) / 2;
        String res;
        if (num1 > num2){
            res = ("The correct order is: " + num1 + " -> " + num2 + ". And the average is " + average);
        }
        else res = ("The correct order is: " + num2 + " -> " + num1 + ". And the average is " + average);
        return res;
    }

    // Exercise 6
    public static long fact(long num){
        long res = 1;
        if (num > 2) {
            for (long i = 1; i < num; i++){
                res = res * i;
                System.out.println("Res antes de sair: " + res);
            }
        }
        return res;   
    }
}
