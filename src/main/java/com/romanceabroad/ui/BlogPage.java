package com.romanceabroad.ui;
import data.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BlogPage extends BasePage{
    public BlogPage(WebDriver driver) {
        super(driver);

    }
    public List<WebElement> getArticlesMenuList(){return driver.findElements(By.xpath(Locators.articlesMenuList));}
    public String articlesOnPageList(){
        List<WebElement> articles = driver.findElements(By.xpath(Locators.articlesOnPageList));
        System.out.println("number of paragraph - "+articles.size());
        String articlesSum = "";
        for (int i = 0; i < articles.size(); i++) {
            articlesSum= articlesSum + articles.get(i).getText()+" "+driver.getTitle();
        }
        System.out.println(articlesSum);
        return articlesSum;
    }
    public WebElement headersPages(){return driver.findElement(By.xpath("//h1"));}
    public By H1 = By.xpath("//h1");

    public boolean countArticlesItemsCheck(){
        if (collectAllArticlesLinksMenu() == getArticlesMenuList().size()){
            System.out.println("Number of links " + getArticlesMenuList().size());
            return true;
        } else return false;
    }
    public boolean countArticlesAndTitlesMatched(int matches){
        if (matches/getArticlesMenuList().size()>=5){
            System.out.println("Number of matches is acceptable");
            return true;
        } else return false;
    }
    public int collectAllArticlesAndTitlesMenu(){
        String title;
        String itemText;
        int matches = 0;
        for (int i = 0; i < getArticlesMenuList().size(); i++) {
            itemText = getArticlesMenuList().get(i).getText();
            System.out.println(i+" Menu item text: "+itemText);
            getArticlesMenuList().get(i).click();
            System.out.println(driver.getCurrentUrl()+"  "+ driver.getTitle());
            //fluentWait.until(x -> x.findElement(H1).isDisplayed());

            title = articlesOnPageList();
            String[] titles = title.replaceAll("|", "").split(" ");
            String[] itemsText = itemText.split(" ");
            matches= matches+checkMatchedWords(titles, itemsText);
            getArticlesMenuList();
        }
        System.out.println("number of matches - "+matches);
        return matches;
    }
    public int collectAllArticlesLinksMenu(){
        int titleAndH1 = 0;
        String totalInfo="";
        String h1Text="";
        for (int i = 0; i < getArticlesMenuList().size(); i++) {
            System.out.println(i+" Menu item text: "+driver.getCurrentUrl());
            getArticlesMenuList().get(i).click();
            try {
                h1Text=headersPages().getText();
            }
            catch (NoSuchElementException e){
                h1Text = "";
                System.out.println("NoSuchElementException occured - "+ e);
            }
            totalInfo = driver.getCurrentUrl()+" "+ h1Text;
            System.out.println("Art+H1 - "+totalInfo);
            if (totalInfo!=""){
                titleAndH1++;
                totalInfo="";
            }
        }
        System.out.println("total titles+h1 - " + titleAndH1);
        return titleAndH1;
    }
    public int checkMatchedWords(String[] titles, String[] menuItems){
        int matches=0;
        if (titles.length>=menuItems.length){
            for (int i = 0; i < titles.length; i++) {
                for (int j = 0; j < menuItems.length; j++) {
                    if (titles[i].equals(menuItems[j])) {
                        System.out.println("var 1 Matched -  " + titles[i] + " and " + menuItems[j]);
                        matches++;
                        break;
                    }
                }
            }
        }else {
            for (int i = 0; i < menuItems.length; i++) {
                for (int j = 0; j < titles.length; j++) {
                    if (menuItems[i].equals(titles[j])) {
                        System.out.println("var 2 Matched -  " + menuItems[i] + " and " + titles[j]);
                        matches++;
                        break;
                    }
                }
            }
        }

        return matches;
    }
}
