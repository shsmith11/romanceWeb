import com.tngtech.java.junit.dataprovider.DataProviders;
import data.Data;
import data.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RegistrationTest extends BaseTest{

    @DataProvider(name = "Registration2")
    public static Object[][] testRegistration2(){
        return new Object[][]{
                {Data.emailReg, Data.userReg, true},
                {"email_bad",  Data.userReg, false},
                {Data.emailReg , Data.userReg, true},
        };
    }

    @DataProvider(name = "RegistrationEmailsOnly")
    public static Object[][] testRegistrationEmails() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("registration_romance_emails.csv")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0]});
        });
        return out.toArray(new Object[out.size()][]);
    }
    @DataProvider(name = "Registration")
    public static Object[][] testRegistration() throws Exception{
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("registration_romance.csv")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @Test (dataProvider = "Registration2")        // sign up through "JOIN FOR FREE NOW" button at home page with POPUP frames
    public void signUpDataValidationPopUpHome(String email, String user, boolean requirement) {
        userRegistrationPage.openPage(PagesLinks.mainUrl);
        userRegistrationPage.openFormPopUpFromHome();
        //1page

        userRegistrationPage.inputEmail(email, userRegistrationPage.inputSignUpFormLoginXpath()); //Random email
        userRegistrationPage.inputPass(userRegistrationPage.inputSignUpFormPassXpath()); //Random pass
        if (!requirement) {
            Assert.assertTrue(userRegistrationPage.errorTooltipNextSignUpFormXpath().isDisplayed());
            System.out.println("Negative test passed. Error tooltip occurred");
        } else {
            userRegistrationPage.buttonNextSignUpFormXpath().click();
            softAssert.assertTrue(userRegistrationPage.checkBoxSignUp().isDisplayed(), "First page is not passed");
            //2page
            userRegistrationPage.inputUser(user, userRegistrationPage.inputSignUpFormUserNameXpath()); //Random user
            userRegistrationPage.inputSelectDateOnForm();
            userRegistrationPage.inputPhone(userRegistrationPage.inputPhonePopUpRegXpath()); //Change in Data class if need.
            userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxSignUp());
            userRegistrationPage.inputLocation(); // Entered Tampa, FL, US. Change in Data class if need.

            Assert.assertTrue(userRegistrationPage.checkBoxSignUp().isSelected(), "Tried check checkbox selected");
        }
    }

    @Test (dataProvider = "Registration", dataProviderClass = DataProviders.class)        // sign up through "Registration page"
    public void signUpDataValidationRegistrationPage(String email,String pass,String user,String day,String month,String year,String phone, String location){
        userRegistrationPage.openPage(PagesLinks.registrationUserPage);
        userRegistrationPage.inputEmail(email, userRegistrationPage.inputRegFormEmailXpath()); //Random email
        userRegistrationPage.inputPass(pass,userRegistrationPage.inputRegFormPassXpath()); //Random pass
        userRegistrationPage.inputUser(user,userRegistrationPage.inputRegFormUserNameXpath());
        //date
        userRegistrationPage.inputPhone(phone, userRegistrationPage.inputPhoneRegXpath()); //Change in Data class if need.
        userRegistrationPage.selectDateOnReg(day, month, year); // Random date.  Change in Data class if need.
        userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxRegFormNewsXpath());
        userRegistrationPage.inputCheckBox(userRegistrationPage.checkBoxRegFormConfirmXpath());
        userRegistrationPage.inputLocation(location); // Entered Tampa, FL, US. Change in Data class if need.

        Assert.assertTrue(userRegistrationPage.checkBoxRegFormConfirmXpath().isSelected(), "Checking checkbox has been selected");
    }



}
