package Ficha01.ExerciciosI;
import java.lang.Math;

public class Temps {
    public static void main (String[] args){
        if(args.length < 2){
            System.out.println("You need to insert more than 1 number.");
        }
        else{
            int act, prev, var, tmp, actIndex, sum;
            var = tmp = actIndex = 0;
            prev = act = sum = Integer.parseInt(args[0]);
            for (int i = 1; i < args.length; i++){
                act = Integer.parseInt(args[i]);
                tmp = act - prev;
                if (Math.abs(tmp) > Math.abs(var)){
                    var = tmp;
                    actIndex = i;
                }
                sum = sum + act;
                prev = i;
            }
            int average = sum / args.length;
            System.out.println("Average of the " + args.length + " temperatures was of " + average + "degrees.");
            if (var >= 0) System.out.println("The biggest variation was between day number " + (actIndex - 1) + " and " + (actIndex) + ", the temperature increased " + var + " degrees between these days.");
            else System.out.println("The biggest variation was between day number " + (actIndex - 1) + " and " + (actIndex) + ", the temperature decreased " + (Math.abs(var)) + " degrees between these days.");
        }
    }
}
