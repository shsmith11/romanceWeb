import data.Data;
import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LogInTests extends BaseTest{

    @Test
    public void signInIncorrectErrorShowsUp(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.buttonLOgIn)));
        driver.findElement(By.xpath(Locators.inputEmail)).sendKeys(Data.emailLogin);
        driver.findElement(By.xpath(Locators.inputPass)).sendKeys(Data.passLogin);
        driver.findElement(By.xpath(Locators.buttonLOgIn)).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.popUpErrorBar)));
        Boolean errorBar = driver.findElement(By.xpath(Locators.popUpErrorBar)).isDisplayed();
        Assert.assertNotNull(errorBar);
        System.out.println("value is   "+errorBar);
    }
}
