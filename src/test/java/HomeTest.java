import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void isHomePage(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHome());
    }
    @Test
    public void iFrameButtonTest(){
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isClickable());
    }
    @Test
    public void iFrameButtonTestAction(){
        HomePage homePage = new HomePage(driver);
        homePage.clickablePlayButtonCheck();
        Assert.assertTrue(homePage.isVideoPlaying());
    }

}
