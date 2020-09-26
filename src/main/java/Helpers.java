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

    public static String randomEmailString(){
        int length = 6;
        boolean useLetters = true;
        boolean useNumbers = false;
        return "sh11"+ RandomStringUtils.random(length, useLetters, useNumbers)+"@test.com";
    }

}
