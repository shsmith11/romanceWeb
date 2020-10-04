import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class HomeTest extends BaseTest {

    @Test
    public void isHomePage(){
        Assert.assertTrue(homePage.isHome());
    }
    @Test
    public void iFrameButtonTest(){
        Assert.assertTrue(homePage.isClickable());
    }
    @Test
    public void iFrameButtonTestAction(){
        homePage.clickablePlayButtonCheck();
        Assert.assertTrue(homePage.isVideoPlaying());
    }
    @Test
    public void navMenuOpenLinksCheck(){
        homePage.getAllNavMenuPagesTitles();
        Assert.assertFalse(homePage.checkAllTitlesFromNavMenu());
    }
}
