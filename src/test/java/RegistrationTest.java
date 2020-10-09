import data.Data;
import data.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BaseTest{
    @BeforeMethod
    public void preSetPage() {
        openPage(PagesLinks.registrationUserPage);
    }
    @Test         // sign up through "JOIN FOR FREE NOW" button at home page with POPUP frames
    public void signUpDataValidationPopUpHome() {
        openPage(PagesLinks.mainUrl);
        RegistrationPage registrationForm = new RegistrationPage(driver);
        registrationForm.openFormPopUpFromHome();
        //1page
        registrationForm.inputEmail(Data.emailReg, registrationForm.inputSignUpFormLoginXpath()); //Random email
        registrationForm.inputPass(Data.passReg, registrationForm.inputSignUpFormPassXpath()); //Random pass
        registrationForm.buttonNextSignUpFormXpath().click();
        //2page
        registrationForm.inputUser(Data.userReg, registrationForm.inputSignUpFormUserNameXpath()); //Random user
        registrationForm.inputSelectDateOnForm();
        registrationForm.inputPhone(Data.phoneReg, registrationForm.inputPhoneXpath()); //Change in Data class if need.
        registrationForm.inputLocation(); // Entered Tampa, FL, US. Change in Data class if need.
        registrationForm.inputCheckBox(registrationForm.checkBoxSignUp());

        Assert.assertTrue(registrationForm.checkBoxSignUp().isDisplayed(), "Tried check checkbox visibility");
    }

    @Test         // sign up through "Registration page"
    public void signUpDataValidationRegistrationPage(){
        userRegistrationPage.inputEmail(Data.emailReg, userRegistrationPage.inputRegFormEmailXpath());//Random email
        userRegistrationPage.inputUser(Data.userReg, userRegistrationPage.inputRegFormUserNameXpath()); //Random user
        userRegistrationPage.inputPass(Data.passReg, userRegistrationPage.inputRegFormPassXpath());//Random pass
        //date

        userRegistrationPage.inputPhone(Data.phoneReg, userRegistrationPage.inputRegFormPhoneXpath()); //Change in Data class if need.
        userRegistrationPage.selectDateOnReg(); // Random date.  Change in Data class if need.
        userRegistrationPage.inputLocation(); // Entered Tampa, FL, US. Change in Data class if need.
        userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxRegFormNewsXpath());
        userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxRegFormConfirmXpath());

        Assert.assertTrue(userRegistrationPage.checkBoxRegFormConfirmXpath().isSelected(), "Checking checkbox has been selected");
    }



}
