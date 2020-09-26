import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeftCornerMenuTest extends BaseTest{

    @BeforeMethod
    public void openUrl(){openPage(PagesLinks.prettyWomanUrl);}

    @Test
    public void menuHomeItem(){
        driver.findElement(By.xpath(Locators.menuLeftTopCorner)).click();
        driver.findElement(By.xpath(Locators.menuLeftItemHome)).click();
        boolean waitValue = explicitWait.until(ExpectedConditions.titleContains("The Best Free Ukrainian Dating Site| Romanceabroad.Com"));
        System.out.println("waitValue is   "+waitValue);
        Assert.assertEquals(waitValue, true);
    }
}
