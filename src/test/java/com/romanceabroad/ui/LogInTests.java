package com.romanceabroad.ui;

import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest{
    public static final boolean testCase1 = true;

    @Test (priority = 1, enabled = testCase1, groups = {"AllBrowsers, Smoke, Functional"})
    public void signInIncorrectErrorShowsUp(){
        loginPage.openPage(PagesLinks.logInUrl);
        Assert.assertTrue(loginPage.negativeSignInIncorrect());
    }
}
