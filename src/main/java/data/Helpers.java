package data;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Helpers {

    static public int randomInt(int begin, int end){
        Random rand = new Random();
        return rand.nextInt(end-begin)+begin;
    }

    public static String randomUserString(){
        int length = 5;
        boolean useLetters = true;
        boolean useNumbers = false;
        return "SH11"+ RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String randomPassword(){
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String randomEmailString(){
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = false;
        return "sh11"+ RandomStringUtils.random(length, useLetters, useNumbers)+"@test.com";
    }

    public static String toString(int randomInt) {
        return Integer.toString(randomInt);
    }
    public static int getCurrentDay(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.DAY_OF_MONTH); // 17
    }
    public static int getCurrentMonth(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.MONTH); // 17
    }
    public static int getCurrentYear(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        return cal.get(Calendar.YEAR); // 17
    }


}
