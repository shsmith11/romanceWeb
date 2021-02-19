package data;

import java.util.HashMap;

final public class Data {

    public static String[] months = {"Jan","Feb","Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec"};

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
    public static String monthReg = Data.months[Helpers.randomArrArg(Data.months)];
    public static String yearReg = Helpers.toString(Helpers.randomInt(1940,Helpers.getCurrentYear()-18));

    //Search Data
    public static int minAgePrettywomanPage = 24;
    public static int maxAgePrettywomanPage = 67;
    public static int imageOnPage = 12;
    public static int trys = 10;
    public static int tryMS = 100;


    //Expected Nav Menu Data
    public static HashMap<Enum,String> expectedH1 = new HashMap<>();
    public static HashMap<Enum,String> expectedTitles = new HashMap<>();



    public static HashMap<Enum,String> getExpectedTitles() {
        // key: menu item, value: title
        expectedTitles.put(PagesNames.HOME,"The Best Free Ukrainian Dating Site| Romanceabroad.Com");
        expectedTitles.put(PagesNames.WORK,"Real Ukrainian women for marriage: legitimate dating site Marry Ukrainian Lady");
        expectedTitles.put(PagesNames.PRETTY,"Meet single Ukrainian women online: dating and marriage at Marry Ukrainian Lady");
        expectedTitles.put(PagesNames.PHOTOS,"Ukrainian women photos: ladies pictures at Marry Ukrainian Lady");
        expectedTitles.put(PagesNames.GIFTS,"Pilot Group: Gift store - Categories");
        expectedTitles.put(PagesNames.UKRAINE,"Pilot Group: Gift store - Item");
        expectedTitles.put(PagesNames.BLOG,"Blog");
        return expectedTitles;
    }
    public static HashMap<Enum,String> getExpectedH1() {
        // key: menu item, value: h1
        expectedH1.put(PagesNames.HOME,"UKRAINIAN GIRLS DATING SITE");
        expectedH1.put(PagesNames.WORK,"Ukrainian women for marriage");
        expectedH1.put(PagesNames.PRETTY,"Single Ukrainian women online");
        expectedH1.put(PagesNames.PHOTOS,"Ukrainian women photos");
        expectedH1.put(PagesNames.GIFTS,"");
        expectedH1.put(PagesNames.UKRAINE,"TOURS TO UKRAINE");
        expectedH1.put(PagesNames.BLOG,"Blog");
        return expectedH1;
    }
}
