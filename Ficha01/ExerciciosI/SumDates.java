package Ficha01.ExerciciosI;

public class SumDates{

    public static void sumDates(int day1, int hour1, int min1, int sec1, int day2, int hour2, int min2, int sec2){
        sec1 += sec2;
        min1 += sec1 / 60;
        sec1 = sec1 % 60;

        min1 += min2;
        hour1 += min1 / 60;
        min1 = min1 % 60;

        hour1 += hour2;
        day1 += hour1 / 24;
        hour1 = hour1 / 24;

        day1 += day2;

        System.out.println(day1 + "D " + hour1 + "H " + min1 + "M " + sec1 + "S ");
    }
    public static void main(String[] args){
       int day1 = Integer.parseInt(args[0]);
       int hour1 = Integer.parseInt(args[1]);
       int min1 = Integer.parseInt(args[2]);
       int sec1 = Integer.parseInt(args[3]);
       int day2 = Integer.parseInt(args[4]);
       int hour2 = Integer.parseInt(args[5]);
       int min2 = Integer.parseInt(args[6]);
       int sec2 = Integer.parseInt(args[7]);
       sumDates(day1, hour1, min1, sec1, day2, hour2, min2, sec2);
    }
}