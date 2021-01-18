package com.romanceabroad.ui;
import data.Data;
import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeftCornerMenuPage extends BasePage{
    public LeftCornerMenuPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> navMenuItemsList(){
        openPage(PagesLinks.mainUrl);
        return driver.findElements(By.xpath(Locators.navMenuItems));
    }
    public WebElement headersPages(){return driver.findElement(By.xpath("//h1"));}
    ArrayList<String> actualTitles;
    ArrayList<String> actualUrl;
    ArrayList<String> actualH1;
    HashMap<String, ArrayList<String>>  navMenuData = new HashMap<>(); ;


    public boolean checkAllNavMenuItems(Enum pageKey){
        int assertState = 0;
        for (int i = 0; i < navMenuItemsList().size(); i++) {
            if (navMenuData.get("titles").get(i).contains(Data.getExpectedTitles().get(pageKey))) {assertState++;}
            if (navMenuData.get("h1").get(i).contains(Data.getExpectedH1().get(pageKey))) {assertState++;}
            if (navMenuData.get("urls").get(i).contains(PagesLinks.getNavMenuLinks().get(pageKey))){assertState++;}
            if (assertState>0) {
                System.out.println("iteration " + i + ",  assertState:  " + assertState);
                System.out.println("Expected titles- " + Data.getExpectedTitles().get(pageKey));
                System.out.println("Actual titles- " + navMenuData.get("titles").get(i));
                System.out.println("Expected h1- " + Data.getExpectedH1().get(pageKey));
                System.out.println("Actual h1- " + navMenuData.get("h1").get(i));
                System.out.println("Expected urls- " + PagesLinks.getNavMenuLinks().get(pageKey));
                System.out.println("Actual urls- " + navMenuData.get("urls").get(i));
                System.out.println("________________________");
            }
            if (assertState <2) {assertState = 0;} else break;
        }
        return (assertState>=2);
    }

    public void getAllNavMenuItems() {
        navMenuItemsList();
        actualTitles = new ArrayList<>();
        actualUrl = new ArrayList<>();
        actualH1 = new ArrayList<>();
        for (int i = 0; i < navMenuItemsList().size(); i++) {
            System.out.println(i + "/" + navMenuItemsList().size() + " - " + navMenuItemsList().get(i).getText());
            navMenuItemsList().get(i).click();
            actualTitles.add(driver.getTitle());
            actualUrl.add(driver.getCurrentUrl());
            try {
                fluentWait.until(x->x.findElement(By.xpath("//h1")).isDisplayed());
                actualH1.add(headersPages().getText());
            }
            catch (NoSuchElementException e){
                actualH1.add("");
            }
            navMenuItemsList();
        }
        navMenuData.put("titles", actualTitles);
        navMenuData.put("urls", actualUrl);
        navMenuData.put("h1", actualH1);
        for(String key: navMenuData.keySet()){
            System.out.println(key  +" :: "+ navMenuData.get(key));
        }
        //fluentWait.until(x->x.findElement(By.xpath("//h1")));
    }
}
