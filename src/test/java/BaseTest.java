import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    WebDriver driver;
    protected WebDriverWait explicitWait;

   public void startUp(){
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
       driver = new ChromeDriver();
       explicitWait = new WebDriverWait(driver, 10);
   }
   public void openPage(String url){
        driver.get(url);
   }

    @BeforeMethod
    public void startUpMainPage() {
        startUp();
        openPage(PagesLinks.mainUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
       //  driver.close();
    }

}
