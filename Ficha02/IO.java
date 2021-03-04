package Ficha02;

import java.util.Scanner;
import java.util.Arrays;

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
                System.out.println(Ex2.grades(array));
                break;
            case 8:
                num = Ex2.indexMax(array);
                System.out.println("Index of the UC with better average: " + num);
                break;
            default:
                break;
        }
    }

    // Exercise 4.
    public static void arrInt(int n){
        System.out.println("Insert the size of the array: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            System.out.println("Insert the " + (i+1) + " element of the array.");
            array[i] = in.nextInt();
        }
        switch(n){
            case 1:
                Arrays.sort(array);
                String resS = Arrays.toString(array);
                System.out.println(resS);
                break;
            case 2:
                System.out.println("Insert the number you want to find: ");
                int val = in.nextInt();
                int res = Arrays.binarySearch(array, val);
                if (res < 0) System.out.println("Not found");
                else System.out.println("Found at index " + res);
                break;
            default:
                break;
        }
    }

    public static void ex5(int n){
        Scanner in = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        int size;
        System.out.println("Insert the size of the array: ");
        size = in.nextInt();
        String temp, res;
        String[] array = new String[size];
        for (int i = 0; i < size; i++){
            System.out.println("Insert string number " + (i + 1));
            temp = st.nextLine();
            array[i] = temp;
        }
        switch(n){
            case 1:
                res = (Ex5.nonRep(array));
                System.out.println(res);
                break;
            case 2:
                res = (Ex5.biggest(array));
                System.out.println(res);
                break;
            case 3:
                res = (Ex5.moreThanOnce(array));
                System.out.println(res);
                break;         
            case 4:
                System.out.println("Insert the string: ");
                temp = st.nextLine();
                res = (Ex5.howMany(array, temp));
                System.out.println(res);
                break;
            default:
                break;
        }
    }

    // Exercise 6.
    public static int[][] createMatrix(){
        Scanner in = new Scanner(System.in);
        System.out.println("Insert the number of columns.");
        int numCol = in.nextInt();
        System.out.println("Insert the number of lines.");
        int numLines = in.nextInt();
        int[][] matrix = new int[numLines][numCol];
        for (int i = 0; i < numLines; i++)
            for (int j = 0; j < numCol; j++){
                System.out.println("Insert number for line number " + (i + 1) + ", column number " + (j + 1));
                matrix[i][j] = in.nextInt();
            }
        return matrix;
    }

    public static void matrix(int n){
        int[][] mat = createMatrix();
        int[][] mat2;
        String res;
        switch(n){
            case 1:
                System.out.println("Now, you need to insert another matrix of the same dimension.");
                mat2 = createMatrix();
                res = Ex6.sumMatrix(mat, mat2);
                System.out.println(res);
                break;
            case 2:
                System.out.println("Now, you need to insert another matrix of the same dimension.");
                mat2 = createMatrix();
                res = Ex6.areEqual(mat, mat2);
                System.out.println(res);
                break;
            case 3:
                System.out.println("Opposite matrix: ");
                res = Ex6.oppositeMat(mat);
                System.out.println(res);
                break;
            default:
                break;
        }
    }

    // Exercise 7.
    


    public static void main(String[] args){
        matrix(3);
    }
}
