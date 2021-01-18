package com.romanceabroad.ui;

import data.PagesLinks;
import data.PagesNames;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = false;
    public static final boolean testCase5 = false;
    public static final boolean testCase6 = true;

    @Test (priority = 2, enabled = testCase1, groups = {"ie"})
    public void isHomePage(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.assertTrue(homePage.isHome());
    }
    @Test (priority = 2, enabled = testCase2, groups = {"user", "admin"})
    public void iFrameButtonTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.assertTrue(homePage.isClickable());
    }
    @Test (priority = 2, enabled = testCase3, groups = {"user", "admin"})
    public void iFrameButtonTestAction(){
        homePage.openPage(PagesLinks.mainUrl);
        homePage.clickablePlayButtonCheck();
        Assert.assertTrue(homePage.isVideoPlaying());
    }
    @Test (priority = 2, enabled = testCase4, groups = {"ie", "user", "admin"})
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
    @Test (priority = 2, enabled = testCase5, groups = {"ie", "user", "admin"})
    public void justFaiTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.fail();
    }
    @Test (priority = 2, enabled = testCase6, groups = {"ie", "user", "admin"})
    public void wordCountExample(){   //example of List and loops
        homePage.openPage(PagesLinks.mainUrl);
        softAssert.assertTrue(homePage.wordCounter()>10);
    }
}
