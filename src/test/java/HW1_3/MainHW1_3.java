package HW1_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainHW1_3 {

    private String mainUrl = "http://romanceabroad.com";
    private String tourToUkraineUrl = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    private String expectedUrl = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    WebDriver driver;

    //Selectors Main page  xPath
    private final String navMenuItemTourToUkraine ="(//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'])[2]";
    private final String buttonJoinForFree="//*[@id='show-registration-block']";
    private final String buttonRequestTourInfo ="//*[@href='https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc']";
    private final String textSectionThirdParagraph ="//*[@id='about']//p[3]";
    private final String textSectionHeader ="//section[@id='about']//div/h2[@class='section-heading ']";
    private final String carouselInner ="//*[@id='carouselExampleIndicators']/div[@class='carousel-inner']";
    private final String textSectionBoldText ="//*[contains(text(),'Request Tour Info')]";
    private final String linkFacebookFooter ="//a[contains(@href,'faceMainbook')]";
    //Selectors Pretty Woman  xPath
    private final String buttonSearch ="//*[@id='main_search_button_user_advanced']";
    private final String loginLinkRightHeader ="//*[@class='menu-top-right-block']/*[@id='ajax_login_link']";
    //Selectors Main page  CSS
    private final String buttonVideoPlay =".ytp-large-play-button.ytp-button";
    private final String buttonYoutubeFooter ="/img/youtube-ico.jpg";
    private final String linkMailToFooter ="a[href$='.com']";
    private final String buttonRequestTourInfoCSS ="https://romanceabroad.com/REQUEST_TOUR_INFO+Application_Form.doc";
    //Selectors Pretty Woman CSS
    private final String buttonFindPeopleHeader ="#main_search_button_user_line";
    private final String buttonNextPageHeader =".fa.fa-caret-right";
    private final String buttonNextPageFooter =".pagination>li.next";
    private final String buttonLastPage =".pagination>li.next+li";
    private final String iconListView =" a[title='List view']";
    private final String dropDownOptionName ="#sorter-select-657>option[value='name']";

    private final String buttonLogin = "//*[@name='logbtn']";

    protected WebDriverWait explicitWait;


    @BeforeMethod
    public void startUpMainPage(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(mainUrl);
        explicitWait = new WebDriverWait(driver, 10);
       // driver.manage().window().maximize();
    }
    @Test
    public void testMainPage() {
        driver.findElement(By.xpath(navMenuItemTourToUkraine)).click();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl, "Not macth");
    }@Test
    public void testMainPageElement() throws InterruptedException {
        driver.get(tourToUkraineUrl);
        driver.findElement(By.xpath(loginLinkRightHeader)).click();
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonLogin)));
        Assert.assertTrue(driver.findElement(By.xpath(buttonLogin)).isDisplayed(), "not displayed");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}
