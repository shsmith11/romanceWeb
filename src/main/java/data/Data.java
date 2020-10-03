package data;

final public class Data {

    // login Data

    public static String emailLogin="sh11usertest";
    public static String passLogin="test11!";



    // Registration Data
    public static String phoneReg ="3056667788";
    public static String locationReg ="tampa";
    public static String emailReg = Helpers.randomEmailString();
    public static String passReg = Helpers.randomPassword();
    public static String userReg = Helpers.randomUserString();
    public static String dayReg = Helpers.toString(Helpers.randomInt(1,30));
    public static String monthReg = Helpers.toString(Helpers.randomInt(0,11));
    public static String yearReg = Helpers.toString(Helpers.randomInt(1940,Helpers.getCurrentYear()-18));

    //Search Data
    public static int minAgePrettywomanPage = 24;
    public static int maxAgePrettywomanPage = 70;



}
