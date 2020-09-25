package HW04;

import java.util.Random;

public class Helpers {

    static public int randomInt(int begin, int end){
        Random rand = new Random();
        return rand.nextInt(end-begin)+begin;
    }


}
