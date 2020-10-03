import data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PrettyWomanPage;

public class PrettyWomanTests extends BaseTest {

    @Test
    public void isPrettyWomanPage(){
        PrettyWomanPage prettyWomanPage = new PrettyWomanPage(driver);
        Assert.assertEquals(driver.getTitle(),prettyWomanPage.pageTitleExpected());
    }

    @Test
    public void checkSearchButtonResult() throws InterruptedException {
        PrettyWomanPage prettyWomanPage = new PrettyWomanPage(driver);
        prettyWomanPage.setMinMaxAgeSelect(Data.minAgePrettywomanPage,Data.maxAgePrettywomanPage);
        prettyWomanPage.buttonSearch().click();
        Assert.assertTrue(prettyWomanPage.imageSearchResult());  // need get data from DB or API

    }
}
