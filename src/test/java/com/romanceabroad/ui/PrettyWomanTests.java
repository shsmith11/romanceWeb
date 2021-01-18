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


    @Test
    public void isPrettyWomanPage(){
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        Assert.assertEquals(driver.getTitle(),prettyWomanPage.pageTitleExpected());
    }

    @Test
    public void checkSearchButtonResult() {
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        prettyWomanPage.setMinMaxAgeSelect();
        prettyWomanPage.buttonSearch().click();
        prettyWomanPage.setSortMode();
        Assert.assertTrue(prettyWomanPage.imageSearchResult());

    }
    @Test (dataProvider = "SearchData")
    public void checkSearchButtonResultAdvanced(String minAge, String maxAge, String sortMode) {
        prettyWomanPage.openPage(PagesLinks.prettyWomanUrl);
        prettyWomanPage.setMinMaxAgeSelect(minAge,maxAge);
        prettyWomanPage.buttonSearch().click();
        prettyWomanPage.setSortMode(sortMode);
        Assert.assertTrue(prettyWomanPage.imageSearchResult());
    }
}
