import data.PagesLinks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactUsPage;

public class ContactUsTests extends BaseTest{

    public static final boolean testCase1 = true;
    public static final boolean testCase2 = true;
    public static final boolean testCase3 = true;

    @Test (priority = 2, enabled = testCase1, groups = {"ie", "user", "admin"})
    public void ContactAdminPageEnteredDataVerification(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.openPage(PagesLinks.contactUs);
        contactUsPage.selectReason();
        contactUsPage.enterUser("1");
        contactUsPage.enterEmail("eee1svsdv.com");
        contactUsPage.enterAllTextFormData();
        contactUsPage.submitForm();
        Assert.assertTrue(contactUsPage.errorMsgCheck());

    }
    @Test (priority = 2, enabled = testCase2, groups = {"ie", "user", "admin"})
    public void ContactAdminPageErrorMsgVerification(){

    }
}
