package com.romanceabroad.ui;

import data.Helpers;
import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class HomePage extends BasePage{

    public WebElement iFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutube));}
    //public WebElement iFrameVideoYoutubeUnstarted (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubeUnstarted));}
    public WebElement iFrameVideoYoutubePlaying (){return driver.findElement(By.xpath(Locators.iFrameVideoYoutubePlaying));}
    public By TEXT_SECTION = By.xpath(Locators.textSection);
    public WebElement buttonIFrameVideoYoutube (){return driver.findElement(By.xpath(Locators.buttonIFrameVideoYoutube));}
    public WebElement textSection (){return driver.findElement(By.xpath(Locators.textSection));}

    public HomePage(WebDriver driver) {
        super(driver, explicitWait);
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
        fluentWait.until(x -> x.findElement(TEXT_SECTION).isDisplayed());
        Helpers.ajaxScrollDown(iFrameVideoYoutube());
        action.moveToElement(iFrameVideoYoutube()).perform();
        driver.switchTo().frame(iFrameVideoYoutube());
        return buttonIFrameVideoYoutube().isEnabled();
    }
    public void clickablePlayButtonCheck() {
        fluentWait.until(x -> x.findElement(TEXT_SECTION).isDisplayed());
        Helpers.ajaxScrollDown(iFrameVideoYoutube());
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
    public void textFromFile() throws IOException {
        Files.readAllLines(Paths.get("HWs.txt")).stream().forEach(s-> {
            String text = s.toUpperCase();
            System.out.println("Child method TEXT - "+ text);
        });
    }

}
