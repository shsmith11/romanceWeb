package com.romanceabroad.ui;

import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HowWeWorkTests extends BaseTest {
    public static final boolean testCase1 = true;

    @Test (priority = 5, enabled = testCase1, groups = {"AllBrowsers, Smoke, Functional"})
    public void isHowWeWorkPage(){
        howWeWorkPage.openPage(PagesLinks.howWeWorkUrl);
        Assert.assertEquals(driver.getTitle(), "Real Ukrainian women for marriage: legitimate dating site Marry Ukrainian Lady");
    }
}
