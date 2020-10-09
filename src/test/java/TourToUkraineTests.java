import data.PagesLinks;
import org.testng.annotations.BeforeMethod;

public class TourToUkraineTests extends BaseTest{
    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.tourToUkraineUrl);
    }
}
