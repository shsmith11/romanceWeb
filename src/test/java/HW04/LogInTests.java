package HW04;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest{
    @BeforeMethod
    public void openUrl(){openPage(PagesLinks.signInUrl);}

    @Test
    public void isPhotoPage(){
        Assert.assertEquals(driver.getTitle(), "Pilot Group : Photo gallery");
    }
    @Test
    public void signInIncorrectErrorShowsUp(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.buttonLOgIn)));
        driver.findElement(By.xpath(Locators.inputEmail)).sendKeys("sss@ddd.com");
        driver.findElement(By.xpath(Locators.inputPass)).sendKeys("sss");
        driver.findElement(By.xpath(Locators.buttonLOgIn)).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.popUpErrorBar)));
        Boolean errorBar = driver.findElement(By.xpath(Locators.popUpErrorBar)).isDisplayed();
        Assert.assertNotNull(errorBar);
        System.out.println("attribute is   "+errorBar);



    }
}
