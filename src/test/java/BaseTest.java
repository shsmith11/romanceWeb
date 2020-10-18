

import data.PagesLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pageObjects.*;

import java.lang.reflect.Method;


public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected HomePage homePage;
    protected LeftCornerMenuPage leftCornerMenuPage;
    protected HowWeWorkPage howWeWorkPage;
    protected LoginPage loginPage;
    protected BlogPage blogPage;
    protected PhotosPage photosPage;
    protected PrettyWomanPage prettyWomanPage;
    protected RegistrationPage userRegistrationPage;

    public void startUp(){
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
    //public void openPage(String url){driver.get(url);}

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional ("chrome") String browser, Method method){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver. get("chrome://settings/clearBrowserData");
        }
        else if (browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
            driver = new EdgeDriver();
            //driver.manage().deleteAllCookies();
        }
        else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().deleteAllCookies();
        }

        startUp();
        driver.manage().window().maximize();
       }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(5000);
       driver.quit();
    }

}
