package pageObjects;
import data.PagesLinks;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected String url = PagesLinks.homeUrl;
    protected FluentWait<WebDriver> fluentWait;
    protected WebDriverWait explicitWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        explicitWait = new WebDriverWait(driver, 10);
        this.fluentWait = new FluentWait<WebDriver>(this.driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(80))
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
        }

    public void openPage(String url){
        driver.get(url);
    }
}
