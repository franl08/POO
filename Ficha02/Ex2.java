package Ficha02;
import java.util.Arrays;

public class Ex2 {
    public static int sumUC (int n, int[][] array){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += array[i][n];
        }
        return sum;
    }

    public static double averageStu(int n, int[][] array){
        int sum = 0;
        for (int i = 0; i < 5; i++){
            sum += array[n][i];
        }
        return(sum / 5);
    }

    public static double averageUC(int n, int[][] array){
        int sum = 0;
        for (int i = 0; i < 5; i++){
            sum += array[i][n];
        }
        return (sum / 5);
    }

    public static int maximum(int[][] array){
        int max = array[0][0];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (array[i][j] > max) max = array[i][j];
        return max;
    }

    public static int minimum(int[][] array){
        int min = array[0][0];
        for (int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                if (array[i][j] < min) min = array[i][j];
        return min;
    }

    public static String biggerThan(int n, int[][] array){
        int[] result = new int[25];
        int ac = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (array[i][j] > n){
                    result[ac] = array[i][j];
                    ac++;
                }
        int[] res = new int[ac];
        System.arraycopy(result, 0, res, 0, ac);
        return (Arrays.toString(res));
    }

    public static String grades(int[][] array){         
        return(Arrays.deepToString(array));
    }
    
    public static int indexMax(int[][] array){
        double max, act;
        int index;
        max = averageUC(0, array);
        index = 0;
        for (int i = 1; i < 5; i++){
            act = averageUC(i, array);
            if (act > max){
                max = act;
                index = i;
            }
        }
        return index;
    }
}