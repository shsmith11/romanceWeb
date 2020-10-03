package pageObjects;

import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public WebElement iFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutube));}
    public WebElement iFrameVideoYoutubeUnstarted (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubeUnstarted));}
    public WebElement iFrameVideoYoutubePlaying (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubePlaying));}
    public WebElement buttonIFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.buttonIFrameVideoYoutube));}


    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(PagesLinks.mainUrl);
    }

    public boolean isHome(){
        String expectedHomeTitle =  "The Best Free Ukrainian Dating Site| Romanceabroad.Com";
        try{
            explicitWait.until(ExpectedConditions.titleContains(expectedHomeTitle));
            return true;
        } catch (TimeoutException err) {
            return false;
        }
    }

    public boolean isClickable(){
        explicitWait.until(ExpectedConditions.elementToBeClickable(iFrameVideoYoutube()));
        driver.switchTo().frame(iFrameVideoYoutube());
        return buttonIFrameVideoYoutube().isEnabled();
    }
    public void clickablePlayButtonCheck() {
        Actions action = new Actions(driver);
        driver.switchTo().frame(iFrameVideoYoutube());
        action.moveToElement(buttonIFrameVideoYoutube()).click().perform();

    }
    public boolean isVideoPlaying(){
        explicitWait.until(ExpectedConditions.elementToBeClickable(iFrameVideoYoutubePlaying()));
        return iFrameVideoYoutubePlaying().isEnabled();
    }
}
