package com.romanceabroad.ui;
import data.Data;
import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    public WebElement inputEmail(){return driver.findElement(By.xpath(Locators.inputEmail));}
    public WebElement inputPass(){return driver.findElement(By.xpath(Locators.inputPass));}
    public WebElement buttonLOgIn(){return driver.findElement(By.xpath(Locators.buttonLOgIn));}

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public boolean negativeSignInIncorrect(){
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.buttonLOgIn)));
        inputEmail().sendKeys(Data.emailLogin);
        inputPass().sendKeys(Data.passLogin);
        buttonLOgIn().click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.popUpErrorBar)));
        return driver.findElement(By.xpath(Locators.popUpErrorBar)).isDisplayed();
    }


}

