import data.Data;
import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrettyWomanTests extends BaseTest {

    @Test
    public void isPrettyWomanPage(){
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        Assert.assertEquals(driver.getTitle(),prettyWomanPage.pageTitleExpected());
    }

    @Test
    public void checkSearchButtonResult() {
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        prettyWomanPage.setMinMaxAgeSelect(Data.minAgePrettywomanPage,Data.maxAgePrettywomanPage);
        prettyWomanPage.buttonSearch().click();
        Assert.assertTrue(prettyWomanPage.imageSearchResult());  // need get data from DB or API

    }
}
