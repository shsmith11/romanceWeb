import data.PagesLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.*;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    protected HomePage homePage;
    protected LeftCornerMenuPage leftCornerMenuPage;
    protected HowWeWorkPage howWeWorkPage;
    protected LoginPage loginPage;
    protected BlogPage blogPage;
    protected PhotosPage photosPage;
    protected PrettyWomanPage prettyWomanPage;
    protected RegistrationPage userRegistrationPage;


   public void startUp(){
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
       driver = new ChromeDriver();
       homePage = new HomePage(driver);
       leftCornerMenuPage = new LeftCornerMenuPage(driver);
       howWeWorkPage = new HowWeWorkPage(driver);
       loginPage = new LoginPage(driver);
       prettyWomanPage = new PrettyWomanPage(driver);
       photosPage = new PhotosPage(driver);
       blogPage = new BlogPage(driver);
       userRegistrationPage = new RegistrationPage(driver);
       driver.manage().window().maximize();

   }


    @BeforeMethod
    public void startUpMainPage() {
        startUp();
        driver.manage().window().maximize();
   }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(5000);
       driver.quit();
    }

}
