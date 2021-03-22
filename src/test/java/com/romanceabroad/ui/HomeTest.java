package com.romanceabroad.ui;

import data.PagesLinks;
import data.PagesNames;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class HomeTest extends BaseTest {

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = false;
    public static final boolean testCase5 = false;
    public static final boolean testCase6 = true;

    @Test (priority = 1, enabled = testCase1, groups = {"IE"})
    public void isHomePage(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.assertTrue(homePage.isHome());
    }
    @Test (priority = 3, enabled = testCase2, groups = {"AllBrowsers, Smoke"})
    public void iFrameButtonTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.assertTrue(homePage.isClickable());
    }
    @Test (priority = 4, enabled = testCase3, groups = {"Chrome, Smoke, Functional"})
    public void iFrameButtonTestAction(){
        homePage.openPage(PagesLinks.mainUrl);
        homePage.clickablePlayButtonCheck();
        Assert.assertTrue(homePage.isVideoPlaying());
    }
    @Test (priority = 1, enabled = testCase4, groups = {"AllBrowsers, Smoke, Functional"})
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
    @Test (priority = 5, enabled = testCase5, groups = {"AllBrowsers, Smoke, Functional"})
    public void justFaiTest(){
        homePage.openPage(PagesLinks.mainUrl);
        Assert.fail();
    }
    @Test (priority = 5, enabled = testCase6, groups = {"AllBrowsers, Smoke, Functional"})
    public void wordCountExample(){   //example of List and loops
        homePage.openPage(PagesLinks.mainUrl);
        softAssert.assertTrue(homePage.wordCounter()>10);
    }
    @Test (priority = 5, enabled = testCase6, groups = {"Functional"})
    public void getTextFromFile() throws IOException {
        homePage.textFromFile();
    }
}
