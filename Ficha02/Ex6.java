package Ficha02;
import java.util.Arrays;

public class Ex6 {
    public static String sumMatrix(int[][] mat, int[][] mat2){
        if ((mat.length != mat2.length) || (mat[0].length != mat2[0].length))
            return ("The matrices don't have the same dimension.");
        int[][] res = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                res[i][j] = mat[i][j] + mat2[i][j];
        return(Arrays.deepToString(res));
    }

    public static String areEqual(int[][] mat, int[][] mat2){
        String resFal = "The matrices are not equal.";
        String resTrue = "The matrices are equal.";
        if ((mat.length != mat2.length) || (mat[0].length != mat2[0].length))
            return resFal;
        boolean flag = true;
        for (int i = 0; i < mat.length && flag; i++)
            for(int j = 0; j < mat[0].length && flag; j++)
                if(mat[i][j] != mat2[i][j]) flag = false;
        if(!flag) return resFal;
        return resTrue;
    }

    public static int symmetric(int num){
        return -num;
    }

    public static String oppositeMat(int[][] mat){
        int[][] res = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                res[i][j] = symmetric(mat[i][j]);
        return (Arrays.deepToString(res));
    }
}
