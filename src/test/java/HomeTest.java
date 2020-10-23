import data.Data;
import data.PagesLinks;
import data.PagesNames;
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
        leftCornerMenuPage.getAllNavMenuItems();
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.HOME));
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.WORK));
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.PRETTY));
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.PHOTOS));
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.GIFTS));
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.UKRAINE));
        Assert.assertTrue(leftCornerMenuPage.checkAllNavMenuItems(PagesNames.BLOG));
    }
    @Test
    public void justFaiTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.fail();
    }
    @Test
    public void wordCountExample(){   //example of List and loops
        homePage.openPage(PagesLinks.mainUrl);
        softAssert.assertTrue(homePage.wordCounter()>10);
    }
}
