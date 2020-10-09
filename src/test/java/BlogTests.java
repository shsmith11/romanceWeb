import data.PagesLinks;
import org.testng.annotations.BeforeMethod;

public class BlogTests extends BaseTest{

    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.blogUrl);
    }
}
