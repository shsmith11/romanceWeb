import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest{
    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.logInUrl);
    }

    @Test
    public void signInIncorrectErrorShowsUp(){
        Assert.assertTrue(loginPage.signInIncorrect());
    }
}
