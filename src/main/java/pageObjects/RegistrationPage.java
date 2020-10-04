package pageObjects;

import data.Data;
import data.Helpers;
import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);

    }
    // 1 page
    public WebElement buttonJoinForFree (){return driver.findElement(By.xpath(Locators.buttonJoinForFree));}
    public WebElement inputSignUpFormLoginXpath (){return driver.findElement(By.xpath(Locators.inputSignUpFormLoginXpath));}
    public WebElement inputSignUpFormPassXpath (){return driver.findElement(By.xpath(Locators.inputSignUpFormPassXpath));}
    public WebElement buttonNextSignUpFormXpath () {return driver.findElement(By.xpath(Locators.buttonNextSignUpFormXpath));}
    // 2 page
    public WebElement inputSignUpFormUserNameXpath() { return driver.findElement(By.xpath(Locators.inputSignUpFormUserNameXpath));}
    public WebElement dropDownSignUpFormDayXpath (){return driver.findElement(By.xpath(Locators.dropDownSignUpFormDayXpath));}
    public WebElement dropDownSignUpFormMonthXpath (){return driver.findElement(By.xpath(Locators.dropDownSignUpFormMonthXpath));}
    public WebElement dropDownSignUpFormYearXpath (){return driver.findElement(By.xpath(Locators.dropDownSignUpFormYearXpath));}
    public WebElement dropDownOpenedSignUpFormDayXpath (){return driver.findElement(By.xpath(Locators.dropDownOpenedSignUpFormDayXpath));}
    public WebElement dropDownOpenedSignUpFormMonthXpath (){return driver.findElement(By.xpath(Locators.dropDownOpenedSignUpFormMonthXpath));}
    public WebElement dropDownOpenedSignUpFormYearXpath (){return driver.findElement(By.xpath(Locators.dropDownOpenedSignUpFormYearXpath));}

    public WebElement inputPhoneXpath () {return driver.findElement(By.xpath(Locators.inputPhoneXpath));}
    public WebElement inputLocationXpath() { return driver.findElement(By.xpath(Locators.inputLocationXpath));}
    public WebElement inputLocationEnteredCityXpath (){return driver.findElement(By.xpath(Locators.inputLocationEnteredCityXpath));}
    public WebElement checkBoxSignUp (){return driver.findElement(Locators.CHECKBOX_SIGNUP_FORM_XPATH);}

    //Registration Page

    public WebElement inputRegFormEmailXpath (){return driver.findElement(By.xpath(Locators.inputRegFormEmailXpath));}
    public WebElement inputRegFormUserNameXpath (){return driver.findElement(By.xpath(Locators.inputRegFormUserNameXpath));}
    public WebElement inputRegFormPassXpath (){return driver.findElement(By.xpath(Locators.inputRegFormPassXpath));}

    public WebElement selectRegFormDayXpath (){return driver.findElement(By.xpath(Locators.selectRegFormDayXpath));}
    public WebElement selectRegFormMonthXpath (){return driver.findElement(By.xpath(Locators.selectRegFormMonthXpath));}
    public WebElement selectRegFormYearXpath (){return driver.findElement(By.xpath(Locators.selectRegFormYearXpath));}

    public WebElement inputRegFormPhoneXpath () {return driver.findElement(By.xpath(Locators.inputRegFormPhoneXpath));}
    public WebElement inputRegFormLocationXpath() { return driver.findElement(By.xpath(Locators.inputRegFormLocationXpath));}
    public WebElement inputRegFormLocationPreselectedXpath (){return driver.findElement(By.xpath(Locators.inputRegFormLocationPreselectedXpath));}
    public WebElement checkBoxRegFormNewsXpath (){return driver.findElement(By.xpath(Locators.checkBoxRegFormNewsXpath));}
    public WebElement checkBoxRegFormConfirmXpath (){return driver.findElement(By.xpath(Locators.checkBoxRegFormConfirmXpath));}




    public void openFormPopUpFromHome(){
        openPage(PagesLinks.mainUrl);
        buttonJoinForFree().click();
    }
    public void inputEmail(String email,WebElement inputEmail){
        inputEmail.sendKeys(email);
    }
    public void inputPass(String pass,WebElement inputPass){
        inputPass.sendKeys(pass);
    }
    public void inputUser(String user, WebElement inputUser){
        inputUser.sendKeys(user);
    }
    public void inputSelectDateOnForm(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.dropDownSignUpFormYearXpath)));
        dropDownSignUpFormDayXpath().click();
        dropDownOpenedSignUpFormDayXpath().click();
        dropDownSignUpFormMonthXpath().click();
        dropDownOpenedSignUpFormMonthXpath().click();
        dropDownSignUpFormYearXpath().click();
        dropDownOpenedSignUpFormYearXpath().click();
    }
    public void selectDateOnReg(){
        Select selectRegistrationFormDay = new Select(selectRegFormDayXpath());
        Select selectRegistrationFormMonth = new Select(selectRegFormMonthXpath());
        Select selectRegistrationFormYear = new Select(selectRegFormYearXpath());
        selectRegistrationFormDay.selectByValue(Data.dayReg);
        selectRegistrationFormMonth.selectByValue(Data.monthReg);
        selectRegistrationFormYear.selectByValue(Data.yearReg);
    }
    public void inputPhone(String phone, WebElement inputPhone){
        inputPhone.sendKeys(phone);
    }
    public void inputLocation(){ // Tampa, FL, US
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(inputLocationXpath(),"title"));
        inputLocationXpath().click();
        inputLocationXpath().sendKeys(Keys.CONTROL+ "A");
        inputLocationXpath().sendKeys(Keys.BACK_SPACE);
        inputLocationXpath().sendKeys(Data.locationReg);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.inputLocationEnteredCityXpath)));
        inputLocationEnteredCityXpath().click();
    }
    public void inputCheckBox(WebElement checkBox){
        if (!checkBox.isSelected()) {
            checkBox.click();
         }
    }


}

