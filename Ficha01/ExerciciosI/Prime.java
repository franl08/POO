package Ficha01.ExerciciosI;
import java.util.Scanner;


public class Prime {

    public static int isPrime(int num){
        if (num > 1){   
            for (int i = 2; i < num; i++){
                if (num % i == 0) return 0;
            }
            return 1;
        }
        return 0;
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Insert a positive number to see all primes before him. Insert a negative number to end the program.");
            int number = input.nextInt();
            if (number != -1 && number > 1){
                for (int i = 1; i < number; i++){
                    if(isPrime(i) == 1) System.out.println(i);
                }
            }
            else break;
        }
        input.close();
    }
}
