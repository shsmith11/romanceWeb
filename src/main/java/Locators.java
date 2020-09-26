import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locators {
    // MAIN PAGE LOCATORS
    //Header locators
   // public static String navMenuItemHome ="//ul/li[@class='nav-item']/a[@href='#']";

    //Nav bar locators
    public static String navMenuItemHome ="//ul/li[@class='nav-item']/a[@href='#']";
    public static String navMenuItemTourToUkraine ="(//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'])[2]";

    //body locators
    public static String buttonJoinForFree="//button[@id='show-registration-block']";
    public static String buttonRequestTourInfo ="//a[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']";
    public static String textSectionThirdParagraph ="//*[@id='about']//p[3]";
    public static String textSectionHeader ="//section[@id='about']//div/h2[@class='section-heading ']";
    public static String carouselInner ="//a[@id='carouselExampleIndicators']/div[@class='carousel-inner']";
    public static String textSectionBoldText ="//p//b[contains(text(),'Request Tour Info')]";
    public static String linkFacebookFooter ="//a[contains(@href,'faceMainbook')]";

    //Home page pop up Sign form page 1 locators
    public static String inputSignUpFormLoginXpath = "//input[@id='email']";
    public static String inputSignUpFormPassXpath = "//input[@id='password']";
    public static String buttonNextSignUpFormXpath = "//button[@data-action='next-page'][text()='Next']";
    //Home page pop up Sign form page 2 locators
    public static String inputSignUpFormUserNameXpath = "//input[@id='nickname']";
    public static String dropDownOpenedSignUpFormDayXpath = "//ul[@class='dropdown-menu show']//li[@data-value="+ Helpers.randomInt(1,30) +"]";  //1 .. 30
    public static String dropDownOpenedSignUpFormMonthXpath = "//ul[@class='dropdown-menu show']//li[@data-type="+ Helpers.randomInt(0,11) +"]"; //0 .. 11
    public static String dropDownOpenedSignUpFormYearXpath = "//ul[@class='dropdown-menu show']//li[@data-value="+ Helpers.randomInt(1940,2002) +"]"; //1940 .. 2002
    public static String dropDownSignUpFormDayXpath = "//div[@id='daySelect']";
    public static String dropDownSignUpFormMonthXpath = "//div[@id='monthSelect']";
    public static String dropDownSignUpFormYearXpath = "//div[@id='yearSelect']";
    public static String inputPhoneXpath = "//input[@name='data[phone]']";
    public static String inputLocationXpath = "//input[@name='region_name']";
    public static String inputLocationEnteredCityXpath = "//ul//li[@city='356107']";   // city Tampa,fl,US. need .sendkey "tampa"
    public static String checkboxXpath = "//input[@type='checkbox'][@name='data[confirmation]']";

    // Example of By class variable
    public static By CHECKBOX_SIGNUP_FORM_XPATH = By.xpath("//input[@type='checkbox'][@name='data[confirmation]']");

    // Example of WebElement class method
    public static WebElement checkboxSignUpFormWebElement(WebDriver driver) { return driver.findElement(By.xpath(checkboxXpath));}

    // PRETTY WOMAN page Locators
    public static String dropDownMinAge = "//select[@id='age_min']";
    public static String dropDownMinAgeSelected = "//select[@id='age_min']/option[@value='"+ 18 +"']";
    public static String dropDownMaxAge = "//select[@id='age_max']";
    public static String dropDownMaxAgeSelected = "//select[@id='age_max']/option[@value='"+ Helpers.randomInt(18,80)+"']";
    public static String textPeopleFoundOnPageNoFound = "//h2[@class='text-center p10']";
    public static String textPeopleFoundOnPage ="//div[@class='lh30']";
    public static String inputSearchButton = "//input[@id='main_search_button_user_advanced']";


    // PHOTO page Locators

    public static String divGalleryPhotos = "//div[@class='g-users-gallery__item col-xs-6 col-sm-4 col-md-3 col-lg-2 big']";
    public static String divGallery = "//div[@class='wrapper']";


    // LOG IN page locators

    public static String inputEmail = "//input[@id='email']";
    public static String inputPass = "//input[@id='password']";
    public static String buttonLOgIn = "//button[@name='logbtn']";
    public static String popUpErrorBar ="//div[@class='error alert-danger alert-warning_pop_']";

    //left corner menu
    public static String menuLeftTopCorner = "//div[@class='menu-item']";
    public static String menuLeftItemHome = "//a[@id='user_main-menu-home-item']";
    public static String menuLeftItemSignUp = "//a[@id='user_main-menu-registration-item']";
    public static String menuLeftItemLogIn = "//a[@id='user_main-menu-login-item']";
    public static String menuLeftItemNews = "//a[@id='user_main-menu-news-item']";
    public static String menuLeftItemPolls = "user_guest-main-polls-item";
}
