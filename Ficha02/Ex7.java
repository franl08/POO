package Ficha02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Ex7 {
    public static int[] readNums(){
        int[] nums = new int[5];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++)
            nums[i] = in.nextInt();
        return nums;
    }

    public static boolean testNums(int[] nums){
        boolean flag = true;
        for (int i = 0; i < 5 && flag; i++){
            if (nums[i] > 50 || nums[i] < 1) flag = false;
            else{
                for(int j = 0; j < i && flag; j++)
                    if (nums[j] == nums[i]) flag = false;
            }
        }
        return flag;
    }

    public static int[] readStars(){
        int[] stars = new int[2];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 2; i++) 
            stars[i] = in.nextInt();
        return stars;
    }

    public static boolean testStars(int[] stars){
        boolean flag = true;
        for (int i = 0; i < 2 && flag; i++){
            if (stars[i] > 12 || stars[i] < 1) flag = false;
            else{
                for (int j = 0; j < i && flag; j++)
                    if(stars[i] == stars[j]) flag = false;
            }
        }
        return flag;
    }

    public static int[] generateNums(){
        int[] nums = new int[5];
        Arrays.fill(nums, 0);
        for (int i = 0; i < 5; ){
            int temp = randomNum();
            if(Arrays.binarySearch(nums, temp) < 0)
                nums[i++] = temp;
        }
        return nums;
    }

    public static int randomNum(){
        Random n = new Random();
        return (n.nextInt(50) + 1);
    }

    public static int[] generateStars(){
        int[] stars = new int[2];
        Arrays.fill(stars, 0);
        stars[0] = randomStar();
        stars[1] = randomStar();
        while(stars[1] == stars[0]) stars[1] = randomStar();
        return stars;
    }

    public static int randomStar(){
        Random s = new Random();
        return (s.nextInt(12) + 1);
    }

    public static int[] compareNums(int[] nums, int[] numKey){
        int[] temp = new int[5];
        int commons = 0;
        for (int i = 0; i < 5; i++)
            if(Arrays.binarySearch(nums, numKey[i]) >= 0)
                temp[commons++] = numKey[i];
        int[] common = new int[commons];
        System.arraycopy(temp, 0, common, 0, commons);
        return common;    
    }

    public static int[] compareStars(int[] stars, int[] starsKey){
        int[] temp = new int[2];
        int commons = 0;
        for (int i = 0; i < 2; i++)
            if(Arrays.binarySearch(stars, starsKey[i]) >= 0)
                temp[commons++] = starsKey[i];
        int[] common = new int[commons];
        System.arraycopy(temp, 0, common, 0, commons);
        return common;
    }

    public static boolean correct(int[] nums, int[] stars){
        return (nums.length == 5 && stars.length == 2);
    }
}
