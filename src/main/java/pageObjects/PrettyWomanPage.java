package pageObjects;
import data.Helpers;
import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PrettyWomanPage extends BasePage {

    public WebElement dropDownMinAge (){return driver.findElement(By.xpath(Locators.dropDownMinAge));}
    public WebElement dropDownMaxAge (){return driver.findElement(By.xpath(Locators.dropDownMaxAge));}
    public WebElement buttonSearch(){return driver.findElement(By.xpath(Locators.buttonSearch));}
    public By BLOCK_MIN_MAX = By.xpath(Locators.blockMinMaxAge);
    public WebElement imageBlock() { return driver.findElement(By.xpath(Locators.imageBlock));}

    Select selectMinAge;
    Select selectMaxAge;

    public PrettyWomanPage(WebDriver driver) {
        super(driver);
    }

    public Select selectMinAge(){
        if (selectMinAge == null) {
            return new Select(dropDownMinAge());
        } else return selectMinAge;

    }
    public Select selectMaxAge(){
        if (selectMaxAge == null) {
            return new Select(dropDownMaxAge());
        } else return selectMaxAge;

    }
    public String pageTitleExpected(){
        fluentWait.until(x -> x.findElement(BLOCK_MIN_MAX).isDisplayed());
        return "Meet single Ukrainian women online: dating and marriage at Marry Ukrainian Lady";
    }

    public void setMinMaxAgeSelect(int min, int max){
        fluentWait.until(x -> x.findElement(BLOCK_MIN_MAX).isDisplayed());
        selectMinAge().selectByValue(Helpers.toString(min));
        selectMaxAge().selectByValue(Helpers.toString(max));
    }
    public boolean imageSearchResult() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(imageBlock()));
        List<WebElement> imagesList = driver.findElements(By.xpath(Locators.imageSearchResult));;
        return imagesList.size()>0;
    }

    public String getExpectedPeopleFoundOnPage(){
        return "People found: 68"; // TODO put here Data from API in future
    }

}
