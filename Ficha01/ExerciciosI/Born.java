package Ficha01.ExerciciosI;
import Day.java;

import java.util.Scanner;
import java.util.TimeZone;
import java.util.Calendar;

// I don't know if this is 100% correct

public class Born{

    public static void difDates(int day, int month, int year){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Lisbon"));
        int cDay = cal.get(Calendar.DAY_OF_MONTH);
        int cMonth = cal.get(Calendar.MONTH) + 1;
        int cYear = cal.get(Calendar.YEAR);
        int cHour = cal.get(Calendar.HOUR);
        System.out.println("Current time: " + cDay + "/" + cMonth + "/" + cYear);

        int dif1 = (day * 24);
        for (int i = 1; i < month; i++){
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                dif1 = dif1 + (31 * 24);
            }
            else if (i == 2){
                dif1 = dif1 + (28 * 24);                
            }
            else{
                dif1 = dif1 + (30 * 24);
            }
        }
        dif1 = dif1 + (365 * 24 * year);
        dif1 = dif1 + ((year / 4) * 24);

        int dif2 = 0;
        if (cDay != 1){
            dif2 = dif2 + ((cDay - 1) * 24);
        }
        for (int i = 1; i < cMonth; i++){
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                dif2 = dif2 + (31 * 24);
            }
            else if (i == 2){
                dif2 = dif2 + (28 * 24);                
            }
            else{
                dif2 = dif2 + (30 * 24);
            }
        }
        dif2 = dif2 + (365 * 24 * cYear);
        dif2 = dif2 + ((year / 4) * 24);
        int res = dif2 - dif1;
        System.out.println("Your age in hours is: " + res);
    }


    public static void main (String[] args){
        boolean leap = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Insert your birth year.");
        int year = input.nextInt();
        if (year > 0){
            System.out.println("Insert your birth month.");
            int month = input.nextInt();
            if (month <= 12 && month >= 1){
                System.out.println("Insert your birth day.");
                int day = input.nextInt();
                if (day > 28){
                    if (month == 2){
                        if (!(leap = Day.isLeap(year))){ 
                            System.out.println("Not a valid day.");
                            return;
                        }
                    }
                    if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 12)){
                        System.out.println("Not a valid day.");
                        return;
                    }
                }
                difDates(day, month, year);
            }
            else System.out.println("Not a valid month.");
        }
        else System.out.println("Not a valid year.");
    }
}