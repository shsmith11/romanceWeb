package com.romanceabroad.ui;

import data.Data;
import data.Helpers;
import data.Locators;
import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PrettyWomanTests extends BaseTest {
    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    public static final boolean testCase4 = true;

    @DataProvider(name = "SearchData")
    public Object[][] SearchPrettyWoman() {
       // HashMap<String, String> randomedMinMax = prettyWomanPage.getRandomMinMaxAgeDropDown();
        return new Object[][]{
               // {randomedMinMax.get("min"), randomedMinMax.get("max"), "Default"},
                {"18", "80", "Default"},
                {"18", "25", "Name"},
                {"30", "40", "Views"},
                {"60", "80", "Registration date"},
        };
    }


    @Test (priority = 1, enabled = testCase1, groups = {"AllBrowsers, Smoke, Functional"})
    public void isPrettyWomanPage(){
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        Assert.assertEquals(driver.getTitle(),prettyWomanPage.pageTitleExpected());
    }

    @Test (priority = 1, enabled = testCase2, groups = {"AllBrowsers, Smoke, Functional"})
    public void checkSearchButtonResult() {
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        prettyWomanPage.setMinMaxAgeSelect();
        prettyWomanPage.buttonSearch().click();
        prettyWomanPage.setSortMode();
        Assert.assertTrue(prettyWomanPage.imageSearchResult());

    }
    @Test (dataProvider = "SearchData", priority = 2, enabled = testCase3, groups = {"AllBrowsers, Functional"})
    public void checkSearchButtonResultAdvanced(String minAge, String maxAge, String sortMode) {
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        prettyWomanPage.setMinMaxAgeSelect(minAge,maxAge);
        prettyWomanPage.buttonSearch().click();
        prettyWomanPage.setSortMode(sortMode);
        Assert.assertTrue(prettyWomanPage.imageSearchResult());
    }
    @Test (priority = 2, enabled = testCase4, groups = {"AllBrowsers, Smoke, Functional"})
    public void checkUserAgesAtGallery() throws InterruptedException {
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        prettyWomanPage.setMinMaxAgeSelect("18","80");
        prettyWomanPage.buttonSearch().click();
        prettyWomanPage.dataPageCollector();
    }
}
