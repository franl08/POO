package Ficha01.ExerciciosI;

public class Day{
    public static void main(String[] args){
        int day = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        weekDay(day, month, year);
    }
    
    public static boolean isLeap (int year){
        return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));
    }

    public static void weekDay(int day, int month, int year){
        if (year > 1900 && year < 2100){
            if (month == 2 && day > 29 || day > 31){
                System.out.println("Invalid day");
            }
            else {
                int res = year - 1900;
                res = res * 365;
                res = res + ((year - 1900) / 4);
                boolean leap = isLeap(year);
                if (leap) res--;
                for (int i = month; i > 0; i--){
                    if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) res = res + 31;
                    else if (i == 2) res = res + 28;
                    else res = res + 30;
                }
                res = res % 7;
                switch (res){
                    case 0:
                        System.out.println("Sunday");
                        break;
                    case 1:
                        System.out.println("Monday");
                        break;
                    case 2:
                        System.out.println("Tuesday");
                        break;
                    case 3:
                        System.out.println("Wednesday");
                        break;
                    case 4: 
                        System.out.println("Thursday");
                        break;
                    case 5:
                        System.out.println("Friday");
                        break;
                    case 6:
                        System.out.println("Saturday");
                        break;
                }
            }
        }
        else System.out.println("Out of bounds.");
    }
}