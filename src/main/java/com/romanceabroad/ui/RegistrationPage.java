package com.romanceabroad.ui;

import data.Data;
import data.Helpers;
import data.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationPage extends BasePage{
    Select selectRegistrationFormDay;
    Select selectRegistrationFormMonth;
    Select selectRegistrationFormYear;

    public RegistrationPage(WebDriver driver) {
        super(driver, explicitWait);
    }
    // 1 page
    public WebElement buttonJoinForFree (){return driver.findElement(By.xpath(Locators.buttonJoinForFree));}
    public By BY_BUTTON_JOIN_FOR_FREE = By.xpath(Locators.buttonJoinForFree);
    public WebElement inputSignUpFormLoginXpath (){return driver.findElement(By.xpath(Locators.inputSignUpFormLoginXpath));}
    public WebElement inputSignUpFormPassXpath (){return driver.findElement(By.xpath(Locators.inputSignUpFormPassXpath));}
    public WebElement buttonNextSignUpFormXpath () {return driver.findElement(By.xpath(Locators.buttonNextSignUpFormXpath));}
    // 2 page
    public WebElement inputSignUpFormUserNameXpath() { return driver.findElement(By.xpath(Locators.inputSignUpFormUserNameXpath));}
    public WebElement dropDownSignUpFormDayXpath (){return driver.findElement(By.xpath(Locators.dropDownSignUpFormDayXpath));}
    public WebElement dropDownSignUpFormMonthXpath (){return driver.findElement(By.xpath(Locators.dropDownSignUpFormMonthXpath));}
    public WebElement dropDownSignUpFormYearXpath (){return driver.findElement(By.xpath(Locators.dropDownSignUpFormYearXpath));}
    public List<WebElement> dropDownOpenedSignUpFormDayXpath (){return driver.findElements(By.xpath(Locators.dropDownOpenedSignUpFormDayXpath));}
    public List<WebElement> dropDownOpenedSignUpFormMonthXpath (){return driver.findElements(By.xpath(Locators.dropDownOpenedSignUpFormMonthXpath));}
    public List<WebElement> dropDownOpenedSignUpFormYearXpath (){return driver.findElements(By.xpath(Locators.dropDownOpenedSignUpFormYearXpath));}

    public WebElement inputPhoneRegXpath () {return driver.findElement(By.xpath(Locators.inputPhoneRegXpath));}
    public WebElement inputPhonePopUpRegXpath () {return driver.findElement(By.xpath(Locators.inputPhonePopUpRegXpath));}
    public WebElement inputLocationXpath() { return driver.findElement(By.xpath(Locators.inputLocationXpath));}
    public By INPUT_LOCATION_ = By.xpath(Locators.inputLocationXpath);
    public WebElement inputLocationEnteredCityXpath (){return driver.findElement(By.xpath(Locators.inputLocationEnteredCityXpath));}
    public By INPUT_LOCATION_ENTERED_CITY = By.xpath(Locators.inputLocationEnteredCityXpath);

    public WebElement checkBoxSignUp (){return driver.findElement(Locators.CHECKBOX_SIGNUP_FORM_XPATH);}

    //Registration Page

    public WebElement inputRegFormEmailXpath (){return driver.findElement(By.xpath(Locators.inputRegFormEmailXpath));}
    public WebElement inputRegFormUserNameXpath (){return driver.findElement(By.xpath(Locators.inputRegFormUserNameXpath));}
    public WebElement inputRegFormPassXpath (){return driver.findElement(By.xpath(Locators.inputRegFormPassXpath));}
    public WebElement errorTooltipNextSignUpFormXpath (){return driver.findElement(By.xpath(Locators.errorTooltipNextSignUpFormXpath));}

    public WebElement selectRegFormDayXpath (){return driver.findElement(By.xpath(Locators.selectRegFormDayXpath));}
    public WebElement selectRegFormMonthXpath (){return driver.findElement(By.xpath(Locators.selectRegFormMonthXpath));}
    public WebElement selectRegFormYearXpath (){return driver.findElement(By.xpath(Locators.selectRegFormYearXpath));}

    public WebElement inputRegFormPhoneXpath () {return driver.findElement(By.xpath(Locators.inputRegFormPhoneXpath));}
    public WebElement inputRegFormLocationXpath() { return driver.findElement(By.xpath(Locators.inputRegFormLocationXpath));}
    public WebElement inputRegFormLocationPreselectedXpath (){return driver.findElement(By.xpath(Locators.inputRegFormLocationPreselectedXpath));}
    public WebElement checkBoxRegFormNewsXpath (){return driver.findElement(By.xpath(Locators.checkBoxRegFormNewsXpath));}
    public WebElement checkBoxRegFormConfirmXpath (){return driver.findElement(By.xpath(Locators.checkBoxRegFormConfirmXpath));}




    public void openFormPopUpFromHome(){
        fluentWait.until(x -> x.findElement(BY_BUTTON_JOIN_FOR_FREE).isDisplayed());
        buttonJoinForFree().click();
    }

    public void inputSelectDateOnForm(){
        inputSelectDateOnForm(Data.dayReg, Data.monthReg, Data.yearReg);
    }
    public void inputSelectDateOnForm(String day, String month, String year){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.dropDownSignUpFormYearXpath)));
        dropDownSignUpFormDayXpath().click();
        dateMatchingCheck(dropDownOpenedSignUpFormDayXpath(), day, "days");
        dropDownSignUpFormMonthXpath().click();
        dateMatchingCheck(dropDownOpenedSignUpFormMonthXpath(), month, "months");
        dropDownSignUpFormYearXpath().click();
        dateMatchingCheck(dropDownOpenedSignUpFormYearXpath(), year, "years");

    }
    public void dateMatchingCheck(List<WebElement> dateList, String date, String dateType){
        for (int i = 0; i < dateList.size(); i++) {
            if (dateList.get(i).getText().contains(date)){
                System.out.println(dateType+" matched - "+date+" = "+dateList.get(i).getText());
                dateList.get(i).click();
                break;
            }
            System.out.println(dateType+" doesn't match. Provided: "+ date+ ". list argument is " + dateList.get(i).getText());
        }
    }
    public void selectDateOnReg(){
        selectDateOnReg(Data.dayReg, Data.monthReg, Data.yearReg);
    }
    public void selectDateOnReg(String day, String month, String year){
        selectRegistrationFormDay = new Select(selectRegFormDayXpath());
        selectRegistrationFormMonth = new Select(selectRegFormMonthXpath());
        selectRegistrationFormYear = new Select(selectRegFormYearXpath());
        selectRegistrationFormDay.selectByVisibleText(day);
        selectRegistrationFormMonth.selectByVisibleText(month);
        selectRegistrationFormYear.selectByVisibleText(year);
    }
    public void inputEmail(WebElement emailInput){
        inputEmail(Data.emailReg, emailInput);
    }
    public void inputEmail(String email, WebElement emailInput){
        Helpers.inputEmail(email, emailInput);
    }
    public void inputPass(WebElement passInput){
        inputPass(Data.passReg, passInput);
    }
    public void inputPass(String pass, WebElement passInput){
        Helpers.inputEmail(pass, passInput);
    }
    public void inputUser(WebElement userInput){
        inputUser(Data.userReg, userInput);
    }
    public void inputUser(String user, WebElement userInput){
        Helpers.inputEmail(user, userInput);
    }
    public void inputPhone(WebElement inputPhone){
        inputPhone(Data.phoneReg, inputPhone);
    }
    public void inputPhone(String phone, WebElement inputPhone){
        inputPhone.sendKeys(phone);
    }

    public void inputLocation(){
        inputLocation(Data.locationReg);
    }
    public void inputLocation(String city){ // Tampa
        try {explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(inputLocationXpath(),"title"));
            inputLocationXpath().click();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            inputLocationXpath().sendKeys(Keys.CONTROL+ "A");
            inputLocationXpath().sendKeys(Keys.BACK_SPACE);
        }
        catch (TimeoutException err) {
            inputLocationXpath().click();
        }
        inputLocationXpath().sendKeys(city);
        fluentWait.until(x -> x.findElement(INPUT_LOCATION_ENTERED_CITY).isDisplayed());
        inputLocationEnteredCityXpath().click();
    }
    public void inputCheckBox(WebElement checkBox){
        if (!checkBox.isSelected()) {
            checkBox.click();
         }
    }


}


