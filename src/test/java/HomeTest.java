import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {

    @Test
    public void isHomePage(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.assertTrue(homePage.isHome());
    }
    @Test
    public void iFrameButtonTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.assertTrue(homePage.isClickable());
    }
    @Test
    public void iFrameButtonTestAction(){
        homePage.openPage(PagesLinks.mainUrl);
        homePage.clickablePlayButtonCheck();
        Assert.assertTrue(homePage.isVideoPlaying());
    }
    @Test
    public void navMenuOpenLinksCheck(){
        leftCornerMenuPage.openPage(PagesLinks.mainUrl);
        leftCornerMenuPage.getAllNavMenuPagesTitles();
        Assert.assertFalse(leftCornerMenuPage.checkAllTitlesFromNavMenu());
    }
    @Test
    public void justFaiTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.fail();
    }
    @Test
    public void wordCountExample(){
        homePage.openPage(PagesLinks.mainUrl);
        softAssert.assertTrue(homePage.wordCounter()>10);
    }
}
