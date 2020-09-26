import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class HomeTest extends BaseTest {

    @Test
    public void isHomePage(){
        driver.findElement(By.xpath(Locators.navMenuItemHome)).click();
        Assert.assertEquals(driver.getTitle(), "The Best Free Ukrainian Dating Site| Romanceabroad.Com");
    }
    @Test         // sign up through "JOIN FOR FREE NOW" button at home page
    public void signUpDataValidationFirstPage(){
        driver.findElement(By.xpath(Locators.buttonJoinForFree)).click();
        driver.findElement(By.xpath(Locators.inputSignUpFormLoginXpath)).sendKeys(Helpers.randomEmailString());
        driver.findElement(By.xpath(Locators.inputSignUpFormPassXpath)).sendKeys(Helpers.randomUserString());
        driver.findElement(By.xpath(Locators.buttonNextSignUpFormXpath)).click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.checkboxXpath)));
        driver.findElement(By.xpath(Locators.inputSignUpFormUserNameXpath)).sendKeys(Helpers.randomUserString());
        driver.findElement(By.xpath(Locators.dropDownSignUpFormDayXpath)).click();
        driver.findElement(By.xpath(Locators.dropDownOpenedSignUpFormDayXpath)).click();
        driver.findElement(By.xpath(Locators.dropDownSignUpFormMonthXpath)).click();
        driver.findElement(By.xpath(Locators.dropDownOpenedSignUpFormMonthXpath)).click();
        driver.findElement(By.xpath(Locators.dropDownSignUpFormYearXpath)).click();
        driver.findElement(By.xpath(Locators.dropDownOpenedSignUpFormYearXpath)).click();
        driver.findElement(By.xpath(Locators.inputPhoneXpath)).sendKeys(Data.phoneLogin);
        driver.findElement(By.xpath(Locators.inputLocationXpath)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath(Locators.inputLocationXpath)).sendKeys("tampa");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.inputLocationEnteredCityXpath)));
        driver.findElement(By.xpath(Locators.inputLocationEnteredCityXpath)).click();
        WebElement checkBox = driver.findElement(Locators.CHECKBOX_SIGNUP_FORM_XPATH);
        checkBox.click();
        Assert.assertTrue(checkBox.isDisplayed(), "Checking checkbox visibility");
    }
}
