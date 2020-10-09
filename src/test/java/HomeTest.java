import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {
    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.mainUrl);
    }
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
        leftCornerMenuPage.getAllNavMenuPagesTitles();
        Assert.assertFalse(leftCornerMenuPage.checkAllTitlesFromNavMenu());
    }
}
