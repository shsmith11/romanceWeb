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
    public List<WebElement> getArticlesMenuList(){

        return driver.findElements(By.xpath(Locators.articlesMenuList));}
    public WebElement headersPages(){return driver.findElement(By.xpath("//h1"));}
    public By H1 = By.xpath("//h1");


    public boolean countArticlesItemsCheck(){
        if (collectAllArticlesMenuLinks() == getArticlesMenuList().size()){
            System.out.println("Number of links equals number of H1 titles");
            return true;
        } else return false;

    }

    public int collectAllArticlesMenuLinks(){
        String h1Articles;
        String itemText;
        int k = 0;
        for (int i = 0; i < getArticlesMenuList().size(); i++) {
            //System.out.println("total list size: "+ getArticlesMenuList().size());
            itemText = getArticlesMenuList().get(i).getText();
            System.out.println(i+" Menu item text: "+itemText);
            System.out.println(getArticlesMenuList().get(i).getAttribute("a"));
            getArticlesMenuList().get(i).click();
            System.out.println(driver.getCurrentUrl()+"  "+ driver.getTitle());
            fluentWait.until(x -> x.findElement(H1).isDisplayed());
            try {
                h1Articles = headersPages().getText();
                System.out.println("H1 "+h1Articles);
            } catch (NoSuchElementException e){
                System.out.println("NoSuchElementException occured at " + itemText+ " : "+ e);
                h1Articles="No Article H1";
            }
            if (itemText == h1Articles) {
                k++;

            }
            getArticlesMenuList();
        }
        System.out.println("number of articles - "+k);
        return k;
    }
}
