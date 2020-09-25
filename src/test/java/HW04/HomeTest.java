package HW04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void isHomePage(){
        driver.findElement(By.xpath(Locators.navMenuItemHome)).click();
        Assert.assertEquals(driver.getTitle(), "The Best Free Ukrainian Dating Site| Romanceabroad.Com");
    }
    @Test         // sign up through "JOIN FOR FREE NOW" button at home page
    public void signUpDataValidationFirstPage(){
        driver.findElement(By.xpath(Locators.buttonJoinForFree)).click();
        driver.findElement(By.xpath(Locators.inputSignUpFormLoginXpath)).sendKeys("emailtest@"+ Helpers.randomInt(0,10000) +"gmail.com");
        driver.findElement(By.xpath(Locators.inputSignUpFormPassXpath)).sendKeys("Superpass1");
        driver.findElement(By.xpath(Locators.buttonNextSignUpFormXpath)).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.checkboxXpath)));
        WebElement checkBox = driver.findElement(Locators.CHECKBOX_SIGNUP_FORM_XPATH);
        Assert.assertTrue(checkBox.isDisplayed(), "Checking checkbox visibility");
    }
}
