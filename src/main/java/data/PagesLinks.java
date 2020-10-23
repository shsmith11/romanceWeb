package data;
import java.util.HashMap;

final public class PagesLinks {
    public static HashMap<Enum,String>  navMenuLinks = new HashMap<>();
// NAV MENU links__________________________
    public static HashMap<Enum,String> getNavMenuLinks() {
        navMenuLinks.put(PagesNames.HOME,"https://romanceabroad.com/#");
        navMenuLinks.put(PagesNames.WORK,"https://romanceabroad.com/content/view/how-it-works");
        navMenuLinks.put(PagesNames.PRETTY,"https://romanceabroad.com/users/search");
        navMenuLinks.put(PagesNames.PHOTOS,"https://romanceabroad.com/media/index");
        navMenuLinks.put(PagesNames.GIFTS,"https://romanceabroad.com/store/category-sweets");
        navMenuLinks.put(PagesNames.UKRAINE,"https://romanceabroad.com/store/sweets/20-tour_to_ukraine");
        navMenuLinks.put(PagesNames.BLOG,"https://romanceabroad.com/content/view/blog");

        return navMenuLinks;
    }

    public static String mainUrl = "http://romanceabroad.com";
    public static String homeUrl = "http://romanceabroad.com/#";
    public static String howWeWorkUrl = "https://romanceabroad.com/content/view/how-it-works";
    public static String prettyWomanUrl = "https://romanceabroad.com/users/search";
    public static String photosUrl = "https://romanceabroad.com/media/index";
    public static String giftsUrl = "https://romanceabroad.com/store/category-sweets";
    public static String tourToUkraineUrl = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    public static String blogUrl = "https://romanceabroad.com/content/view/blog";
    public static String logInUrl = "https://romanceabroad.com/users/login_form";
//__________________________________________

    public static String registrationUserPage = "https://romanceabroad.com/users/registration/";


}
