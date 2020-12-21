import data.Data;
import data.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BaseTest{

    @Test         // sign up through "JOIN FOR FREE NOW" button at home page with POPUP frames
    public void signUpDataValidationPopUpHome() {
        RegistrationPage popUpRegistrationForm = new RegistrationPage(driver);
        popUpRegistrationForm.openPage(PagesLinks.mainUrl);
        popUpRegistrationForm.openFormPopUpFromHome();
        //1page
        Helpers.inputEmail(Data.emailReg, popUpRegistrationForm.inputSignUpFormLoginXpath()); //Random email
        Helpers.inputPass(Data.passReg, popUpRegistrationForm.inputSignUpFormPassXpath()); //Random pass
        popUpRegistrationForm.buttonNextSignUpFormXpath().click();
        softAssert.assertTrue(popUpRegistrationForm.checkBoxSignUp().isDisplayed(), "First page is not passed");
        //2page
        Helpers.inputUser(Data.userReg, popUpRegistrationForm.inputSignUpFormUserNameXpath()); //Random user
        popUpRegistrationForm.inputSelectDateOnForm();
        popUpRegistrationForm.inputPhone(Data.phoneReg, popUpRegistrationForm.inputPhoneXpath()); //Change in Data class if need.
        popUpRegistrationForm.inputCheckBox(popUpRegistrationForm.checkBoxSignUp());
        popUpRegistrationForm.inputLocation(); // Entered Tampa, FL, US. Change in Data class if need.


        Assert.assertTrue(popUpRegistrationForm.checkBoxSignUp().isSelected(), "Tried check checkbox selected");
    }

    @Test         // sign up through "Registration page"
    public void signUpDataValidationRegistrationPage(){
        userRegistrationPage.openPage(PagesLinks.registrationUserPage);
        Helpers.inputEmail(Data.emailReg, userRegistrationPage.inputRegFormEmailXpath());//Random email
        Helpers.inputUser(Data.userReg, userRegistrationPage.inputRegFormUserNameXpath()); //Random user
        Helpers.inputPass(Data.passReg, userRegistrationPage.inputRegFormPassXpath());//Random pass
        //date
        userRegistrationPage.inputPhone(Data.phoneReg, userRegistrationPage.inputRegFormPhoneXpath()); //Change in Data class if need.
        userRegistrationPage.selectDateOnReg(); // Random date.  Change in Data class if need.
        userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxRegFormNewsXpath());
        userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxRegFormConfirmXpath());
        userRegistrationPage.inputLocation(); // Entered Tampa, FL, US. Change in Data class if need.

        Assert.assertTrue(userRegistrationPage.checkBoxRegFormConfirmXpath().isSelected(), "Checking checkbox has been selected");
    }



}
