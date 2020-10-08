import data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrettyWomanTests extends BaseTest {

    @Test
    public void isPrettyWomanPage(){
        Assert.assertEquals(driver.getTitle(),prettyWomanPage.pageTitleExpected());
    }

    @Test
    public void checkSearchButtonResult() {
        prettyWomanPage.setMinMaxAgeSelect(Data.minAgePrettywomanPage,Data.maxAgePrettywomanPage);
        prettyWomanPage.buttonSearch().click();
        Assert.assertTrue(prettyWomanPage.imageSearchResult());  // need get data from DB or API

    }
}
