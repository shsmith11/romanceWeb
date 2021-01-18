package com.romanceabroad.ui;

import data.Data;
import data.Helpers;
import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> listReason = driver.findElements(By.xpath(Locators.selectReason));
    public List<WebElement> listErrorMsg = driver.findElements(By.xpath(Locators.errorMsg));
    public WebElement selectReasonXpath (){return driver.findElement(By.xpath(Locators.selectReason));}
    public WebElement errorMsg (){return driver.findElement(By.xpath(Locators.errorMsg));}
    public By ERROR_MSG = By.xpath(Locators.errorMsg);
    public WebElement inputYourNameXpath (){return driver.findElement(By.xpath(Locators.inputYourName));}
    public WebElement inputYourEmailXpath (){return driver.findElement(By.xpath(Locators.inputYourEmail));}
    public WebElement inputSubjectXpath (){return driver.findElement(By.xpath(Locators.inputSubject));}
    public WebElement textAreaYourMsgXpath (){return driver.findElement(By.xpath(Locators.textAreaYourMsg));}
    public WebElement inputSecurityCaptchaXpath (){return driver.findElement(By.xpath(Locators.inputSecurityCaptcha));}
    public WebElement buttonSendXpath (){return driver.findElement(By.xpath(Locators.buttonSend));}

    Select selectReasonDrop;

    public void selectReason() {
        Helpers.getDropDownListByRandomValue(selectReasonXpath(), "value");
    }

    public void generateSecurityCode(){
        inputSecurityCaptchaXpath().sendKeys("874833");
    }

    public void enterAllTextFormData(){
        Helpers.inputTextData(20, inputSubjectXpath()); //Subject length 20
        Helpers.inputTextData(50, textAreaYourMsgXpath()); //Message length 20
        generateSecurityCode();
    }
    public void enterEmail(String email){    // overload example
        Helpers.inputUser(email, inputYourEmailXpath());
    }
    public void enterEmail(){               // overload example
        enterEmail(Data.emailReg);
    }
    public void enterUser(String user){    // overload example
        Helpers.inputUser(user, inputYourNameXpath());
    }
    public void enterUser(){               // overload example
        enterUser(Data.userReg);
    }
    public void submitForm(){
        buttonSendXpath().click();
    }

    public boolean errorMsgCheck() {
        fluentWait.until(x -> x.findElement(ERROR_MSG).isDisplayed());
        boolean passed = true;
        if (errorMsg().getText().length() > 0) {
            String[]  errArr = errorMsg().getText().split(" ",0);
            for (String k:errArr) {
                System.out.println(k);
                if (k.contains("email") || k.contains("name") || k.contains("subject") || k.contains("message") || k.contains("banned")) {
                    passed = false;
                    System.out.println(k +" - "+passed);
                }
            }
        }
        return passed;
    }

}