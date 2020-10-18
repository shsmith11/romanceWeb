import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest{


    @Test
    public void signInIncorrectErrorShowsUp(){
        loginPage.openPage(PagesLinks.logInUrl);
        Assert.assertTrue(loginPage.signInIncorrect());
    }
}
