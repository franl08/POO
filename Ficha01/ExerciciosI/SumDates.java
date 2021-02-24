package Ficha01.ExerciciosI;

public class SumDates{

    public static void sumDates(int day1, int hour1, int min1, int sec1, int day2, int hour2, int min2, int sec2){
        int finalDay, finalHour, finalMin, finalSec;
        finalDay = finalHour = finalMin = 0;
        finalSec = sec1 + sec2;
         while (finalSec > 59){
            finalMin++;
            finalSec = finalSec - 60;
        }
        finalMin = finalMin + min1 + min2;
        while (finalMin > 59){
            finalHour++;
            finalMin = finalMin - 60;
        }
        finalHour = finalHour + hour1 + hour2;
        while (finalHour > 23){
            finalDay++;
            finalHour = finalHour - 24;
        }
        finalDay = finalDay + day1 + day2;
        System.out.println(finalDay + "D " + finalHour + "H " + finalMin + "M " + finalSec + "S ");
    }
    public static void main(String[] args){
       int day1 = Integer.parseInt(args[0]);
       int hour1 = Integer.parseInt(args[1]);
       int min1 = Integer.parseInt(args[2]);
       int sec1 = Integer.parseInt(args[3]);
       int day2 = Integer.parseInt(args[4]);
       int hour2 = Integer.parseInt(args[5]);
       int min2 = Integer.parseInt(args[6]);
       int sec2 = Integer.parseInt(args[5]);
       sumDates(day1, hour1, min1, sec1, day2, hour2, min2, sec2);
    }
}