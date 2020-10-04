package pageObjects;

import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    public WebElement iFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutube));}
    public WebElement iFrameVideoYoutubeUnstarted (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubeUnstarted));}
    public WebElement iFrameVideoYoutubePlaying (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubePlaying));}
    public WebElement buttonIFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.buttonIFrameVideoYoutube));}
    public List<WebElement> navMenuItemsList(){return driver.findElements(By.xpath(Locators.navMenuItems));}
    public WebElement navMenuClosed(){return driver.findElement(By.xpath(Locators.navMenuClosed));}
    public WebElement title(){return driver.findElement(By.xpath("//title"));}

    ArrayList<String> titles;

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
    public void getAllNavMenuPagesTitles(){
        navMenuItemsList();
        titles = new ArrayList<>();
        for (int i = 0; i < navMenuItemsList().size(); i++) {
            System.out.println(i+"/"+ navMenuItemsList().size()+" - "+ navMenuItemsList().get(i).getText());
            navMenuItemsList().get(i).click();
            //explicitWait.until(ExpectedConditions.visibilityOf(navMenuClosed()));
            titles.add(driver.getTitle());
            driver.navigate().back(); //  or call method - openPage(PagesLinks.mainUrl);
        }
    }
    public boolean checkAllTitlesFromNavMenu(){
        boolean failTitle=false;
        for (int i = 0; i < titles.size(); i++) {
            if(titles.get(i)!=null && titles.get(i)!=""){
                failTitle = false;
                System.out.println(titles.get(i));
            } else {failTitle = true;}
        }
        return failTitle;
    }
}
