import data.PagesLinks;
import org.testng.annotations.BeforeMethod;

public class GiftsTests extends BaseTest{
    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.giftsUrl);
    }
}
