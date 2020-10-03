import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HowWeWorkPage;

public class HowWeWorkTests extends BaseTest {

    @Test
    public void isHowWeWorkPage(){
        HowWeWorkPage howWeWorkPage = new HowWeWorkPage(driver);
        howWeWorkPage.openPage(PagesLinks.howWeWorkUrl);
        Assert.assertEquals(driver.getTitle(), "Real Ukrainian women for marriage: legitimate dating site Marry Ukrainian Lady");
    }
}
