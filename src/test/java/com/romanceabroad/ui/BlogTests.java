package com.romanceabroad.ui;

import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlogTests extends BaseTest{
    public static final boolean testCase10 = true;
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;

    @Test(priority = 2, enabled = testCase10, groups = {"ie", "user", "admin"})
    public void collectAllArticlesLinksMenu(){
        blogPage.openPage(PagesLinks.blogUrl);
        Assert.assertTrue(blogPage.countArticlesItemsCheck(), "Something went wrong.");

    } @Test(priority = 2, enabled = testCase10, groups = {"ie", "user", "admin"})
    public void checkBlogArticlesMenuItemsNamesAndTitlesAndText(){
        blogPage.openPage(PagesLinks.blogUrl);
        Assert.assertTrue(blogPage.countArticlesAndTitlesMatched(blogPage.collectAllArticlesAndTitlesMenu()), "Something went wrong.");
    }

}
