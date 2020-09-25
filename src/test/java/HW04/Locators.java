package HW04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Locators {
    // MAIN PAGE LOCATORS
    //Nav bar locators
    public static String navMenuItemHome ="//ul/li[@class='nav-item']/a[@href='#']";
    public static String navMenuItemTourToUkraine ="(//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'])[2]";

    //body locators
    public static String buttonJoinForFree="//*[@id='show-registration-block']";
    public static String buttonRequestTourInfo ="//*[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']";
    public static String textSectionThirdParagraph ="//*[@id='about']//p[3]";
    public static String textSectionHeader ="//section[@id='about']//div/h2[@class='section-heading ']";
    public static String carouselInner ="//*[@id='carouselExampleIndicators']/div[@class='carousel-inner']";
    public static String textSectionBoldText ="//*[contains(text(),'Request Tour Info')]";
    public static String linkFacebookFooter ="//a[contains(@href,'faceMainbook')]";

    //Sign form page 1 locators
    public static String inputSignUpFormLoginXpath = "//input[@id='email']";
    public static String inputSignUpFormPassXpath = "//input[@id='password']";
    public static String buttonNextSignUpFormXpath = "//*[@data-action='next-page'][text()='Next']";
    //Sign form page 2 locators
    public static String inputSignUpFormUserNameXpath = "//*[@id='nickname']";
    public static String DropDownOpenedSignUpFormDayXpath = "//*[@class='dropdown-menu show']/li[@data-value="+ Helpers.randomInt(1,30) +"]";  //1 .. 30
    public static String DropDownOpenedSignUpFormMonthXpath = "//*[@class='dropdown-menu show']/li[@data-type="+ Helpers.randomInt(0,11) +"]"; //0 .. 11
    public static String DropDownOpenedSignUpFormYearXpath = "//*[@class='dropdown-menu show']/li[@data-value="+ Helpers.randomInt(1940,2002) +"]"; //1940 .. 2002
    public static String DropDownSignUpFormDayXpath = "//*[@id='daySelect']";
    public static String DropDownSignUpFormMonthXpath = "//*[@id='monthSelect']";
    public static String inputPhoneXpath = "//input[@name='data[phone]']";
    public static String inputLocationXpath = "//ul/li[@city='356107']";   // city Tampa,fl,US. need .sendkey "tampa"
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


}
