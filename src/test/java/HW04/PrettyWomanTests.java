package HW04;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrettyWomanTests extends BaseTest {
    @BeforeMethod
    public void openUrl(){openPage(PagesLinks.prettyWomanUrl);}

    @Test
    public void isPrettyWomanPage(){
        Assert.assertEquals(driver.getTitle(), "Meet single Ukrainian women online: dating and marriage at Marry Ukrainian Lady");
    }

    @Test
    public void checkSearchButtonResult(){
        //driver.findElement(By.xpath(Locators.dropDownMinAge)).click();
        driver.findElement(By.xpath(Locators.dropDownMinAgeSelected)).click();
        //driver.findElement(By.xpath(Locators.dropDownMaxAge)).click();
        driver.findElement(By.xpath(Locators.dropDownMaxAgeSelected)).click();
        driver.findElement(By.xpath(Locators.inputSearchButton)).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main_users_results']")));
        String peopleFoundOnPage = driver.findElement(By.xpath(Locators.textPeopleFoundOnPage)).getText();


        Assert.assertEquals(peopleFoundOnPage ,"People found: 61");  // need get data from DB or API

    }
}
