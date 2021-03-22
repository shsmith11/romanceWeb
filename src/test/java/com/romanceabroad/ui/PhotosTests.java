package com.romanceabroad.ui;

import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PhotosTests extends BaseTest{
    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;


    @Test (priority = 1, enabled = testCase1, groups = {"IE, Smoke, Functional"})
    public void isPhotoPage(){
        photosPage.openPage(PagesLinks.photosUrl);
        Assert.assertTrue(photosPage.getPageTitle());
    }

    @Test (priority = 1, enabled = testCase2, groups = {"AllBrowsers, Smoke, Functional"})
    public void isPicturesLoaded(){
        photosPage.openPage(PagesLinks.photosUrl);
        Assert.assertTrue(photosPage.loadAlbymPictures());
    }
}
