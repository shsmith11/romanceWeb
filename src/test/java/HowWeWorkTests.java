import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseTest {

    @Test
    public void isHowWeWorkPage(){
        howWeWorkPage.openPage(PagesLinks.howWeWorkUrl);
        Assert.assertEquals(driver.getTitle(), "Real Ukrainian women for marriage: legitimate dating site Marry Ukrainian Lady");
    }
}
