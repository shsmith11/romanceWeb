import data.PagesLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    HomePage homePage;

   public void startUp(){
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
       driver = new ChromeDriver();
       homePage = new HomePage(driver);
       driver.manage().window().maximize();
      // explicitWait = new WebDriverWait(driver, 10);
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
