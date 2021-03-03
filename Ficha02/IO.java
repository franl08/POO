package Ficha02;

import java.util.Scanner;

public class IO {

    // Exercise 1.
    public static void ex1 (int ex){
        System.out.println("Insert the size of the array: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            System.out.println("Insert the " + (i+1) + " element of the array.");
            array[i] = in.nextInt();
        }
        switch(ex){
            case 1:
                int min = Ex1.minArr(array);
                System.out.println("The minimum of the inserted array is: " + min);
                break;
            case 2:
                System.out.println("Insert the initial and final index: ");
                int init = in.nextInt();
                int end = in.nextInt();
                String res = Ex1.between(array, init, end);
                System.out.println(res);
                break;
            case 3:
                System.out.println("Insert the size of the other array: ");
                int size2 = in.nextInt();
                int[] array2 = new int[size2];
                for (int i = 0; i < size2; i++){
                    System.out.println("Insert the " + (i+1) + " element of the array.");
                    array2[i] = in.nextInt();
                }
                String res2 = Ex1.common(array, array2);
                System.out.println(res2);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args){
        ex1(3);
    }
}
