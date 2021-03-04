package Ficha02;
import java.util.Arrays;

public class Ex5 {
    public static String nonRep(String[] array){
        String[] restr = new String[array.length];
        Arrays.fill(restr, "\0");
        restr[0] = array[0];
        int index = 1;
        for(int i = 1; i < array.length; i++){
            boolean found = false;
            for(int j = 0; !(restr[j].equals("\0")) && !found; j++){
                if (array[i].equals(restr[j])) found = true;
            }
            if(!found){
                restr[index++] = array[i];
            }
        }
        String[] res = new String[index];
        System.arraycopy(restr, 0, res, 0, index);
        return(Arrays.toString(res));
    }

    public static String biggest(String[] array){
        String biggest = array[0];
        for (int i = 1; i < array.length; i++)
            if ((array[i].compareTo(biggest)) > 0) biggest = array[i];
        return ("Biggest string inserted is: " + biggest);
    }

    public static String moreThanOnce(String[] array){
        String[] r = new String[array.length];
        int index = 0;
        for (int i = 1; i < array.length; i++){
            boolean found = false;
            for (int j = 0; j < i; j++){
                if(array[i].equals(array[j])){
                    for (int k = 0; k < index && !found; k++){
                        if (array[i].equals(r[k])) found = true;
                    }
                    if(!found){
                        r[index++] = array[i];
                    }
                }
            }
        }
        String[] res = new String[index];
        System.arraycopy(r, 0, res, 0, index);
        return (Arrays.toString(res));
    }

    public static String howMany(String[] array, String str){
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (str.equals(array[i])) count++;
        return ("Repeated " + count + " time(s).");
    }
}
