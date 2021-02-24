package Ficha01.ExerciciosI;

public class Grades {
    public static void main(String[] args){
        int firstInt, secInt, thirdInt, fourthInt;
        firstInt = secInt = thirdInt = fourthInt = 0;
        String g = " grades.";

        for (int i = 0; i < args.length; i++){
            int temp = Integer.parseInt(args[i]);
            if (temp >= 0 && temp < 5) firstInt++;
            else if (temp >= 5 && temp < 10) secInt++;
            else if (temp >= 10 && temp < 15) thirdInt++;
            else if (temp >= 15 && temp <= 20) fourthInt++;
            else{
                System.out.println("Grade number " + i + "is invalid.");
                return;
            }
        }

        System.out.println("In [0,5[ we have: " + firstInt + g);
        System.out.println("In [5,10[ we have: " + secInt + g);
        System.out.println("In [10,15[ we have: " + thirdInt + g);
        System.out.println("In [15,20] we have: " + fourthInt + g);
    }
}
