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

    // Exercise 2.
    public static void ex2 (int n){
        int num, res;
        double resD;
        String resS;
        Scanner in = new Scanner(System.in);
        int[][] array = new int[5][5];
        
        for (int i = 0; i < 5; i++){
            System.out.println("Please insert the grades of student number " + (i + 1));
            for (int j = 0; j < 5; j++){
                System.out.println("Grade of the UC number " + (j + 1) + ":");
                int value = in.nextInt();
                array[i][j] = value;
            }
        }
        switch(n){
            case 1:
                System.out.println("Please insert the index of the UC.");
                num = in.nextInt();
                res = Ex2.sumUC(num, array);
                System.out.println("Sum of all grades = " + res);
                break;
            case 2:
                System.out.println("Please insert the index of the student.");
                num = in.nextInt();
                resD = Ex2.averageStu(num, array);
                System.out.println("Average = " + resD);
                break;
            case 3:
                System.out.println("Please insert the index of the UC.");
                num = in.nextInt();
                resD = Ex2.averageUC(num, array);
                System.out.println("Average = " + resD);
                break;
            case 4:
                res = Ex2.maximum(array);
                System.out.println("Best grade: " + res);
                break;
            case 5:
                res = Ex2.minimum(array);
                System.out.println("Worst grade: " + res);
                break;
            case 6:
                System.out.println("Insert a grade.");
                num = in.nextInt();
                resS = Ex2.biggerThan(num, array);
                System.out.println("Grades bigger than " + num + ": " + resS);
                break;
            case 7:
                for(int i = 0; i < 5; i++){
                    System.out.println("Grades of student number " + (i + 1));
                    System.out.println(Ex2.grades(i, array));
                }
                break;
            case 8:
                num = Ex2.indexMax(array);
                System.out.println("Index of the UC with better average: " + num);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args){
        
    }
}
