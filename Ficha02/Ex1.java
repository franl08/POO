package Ficha02;
import java.util.Arrays;

public class Ex1 {
    // Ex.1 a)
    public static int minArr(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    public static String between(int[] array, int init, int end){
        String res;
        if ((init > end) || (end >= array.length)) res = "Invalid index";
        else{
            int size = end - init + 1;
            int[] vec = new int[size];
            for (int i = init, j = 0; i <= end; i++, j++){
                vec[j] = array[i];
            }
            res = Arrays.toString(vec);
        }
        return res;
    }

    public static String common(int[] array1, int[] array2){
        int i, j, k, ac, insert, rep, size;
        if (array1.length >= array2.length) size = array1.length;
        else size = array2.length;
        int[] comm = new int[size];
        rep = 0;
        for (i = 0; i < array1.length; i++){
            int temp = array1[i];
            for(k = 0, ac = i; k < i && ac == i; k++){
                if (temp == comm[k]) ac--;
            }
            if (ac == i){
                for (j = 0, insert = 0; j < array2.length && insert == 0; j++){
                    if (temp == array2[j]){
                        comm[i] = temp;
                        insert++;
                        rep++;
                    }
                }
            }
        }
        int[] res = new int[rep];
        System.arraycopy(comm, 0, res, 0, rep);
        return (Arrays.toString(res));
    }
}
