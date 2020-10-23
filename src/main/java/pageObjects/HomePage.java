package pageObjects;

import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Arrays;
import java.util.List;


public class HomePage extends BasePage{

    public WebElement iFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutube));}
    //public WebElement iFrameVideoYoutubeUnstarted (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubeUnstarted));}
    public WebElement iFrameVideoYoutubePlaying (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubePlaying));}
    public WebElement buttonIFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.buttonIFrameVideoYoutube));}
    public WebElement textSection (){return driver.findElement(By.xpath(Locators.textSection));}

    public HomePage(WebDriver driver) {
        super(driver);
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
        action.moveToElement(iFrameVideoYoutube()).perform();
        driver.switchTo().frame(iFrameVideoYoutube());
        return buttonIFrameVideoYoutube().isEnabled();
    }
    public void clickablePlayButtonCheck() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(iFrameVideoYoutube()));
        action.moveToElement(iFrameVideoYoutube()).perform();
        driver.switchTo().frame(iFrameVideoYoutube());
        action.moveToElement(buttonIFrameVideoYoutube()).click().perform();
    }
    public boolean isVideoPlaying(){
        explicitWait.until(ExpectedConditions.elementToBeClickable(iFrameVideoYoutubePlaying()));
        return iFrameVideoYoutubePlaying().isEnabled();
    }

    public int wordCounter(){
        List<String> words;
        words = Arrays.asList(textSection().getText().split(" "));
        for (int i = 0; i < words.size(); i++) {
            words.set(i, i+" - " + words.get(i));
        }
        System.out.println(words+" TOTAL WORDS - " + words.size());
        return words.size();
    }

}
