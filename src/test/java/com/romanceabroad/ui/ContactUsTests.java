package com.romanceabroad.ui;

import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTest{

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;
    @Parameters({"email"})
    @Test (priority = 2, enabled = testCase1, groups = {"ie", "user", "admin"})
    public void ContactAdminPageEnteredDataVerification(@Optional("email11@gmail.com") String email){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.openPage(PagesLinks.contactUs);
        contactUsPage.selectReason();
        contactUsPage.enterUser();
        contactUsPage.enterEmail(email);
        contactUsPage.enterAllTextFormData();
        contactUsPage.submitForm();
        Assert.assertTrue(contactUsPage.errorMsgCheck());

    }
    @Test (priority = 2, enabled = testCase2, groups = {"ie", "user", "admin"})
    public void ContactAdminPageErrorMsgVerification(){

    }
}
