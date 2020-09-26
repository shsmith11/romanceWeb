import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseTest {

    @BeforeMethod
    public void openUrl(){openPage(PagesLinks.howWeWorkUrl);}

    @Test
    public void isHowWeWorkPage(){
        Assert.assertEquals(driver.getTitle(), "Real Ukrainian women for marriage: legitimate dating site Marry Ukrainian Lady");
    }
}
