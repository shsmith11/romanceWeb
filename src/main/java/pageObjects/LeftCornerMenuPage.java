package pageObjects;

import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class LeftCornerMenuPage extends BasePage{
    public LeftCornerMenuPage(WebDriver driver) {
        super(driver);
        openPage(PagesLinks.prettyWomanUrl);
    }


    public List<WebElement> navMenuItemsList(){return driver.findElements(By.xpath(Locators.navMenuItems));}
    ArrayList<String> titles;

    public void getAllNavMenuPagesTitles(){
        navMenuItemsList();
        titles = new ArrayList<>();
        for (int i = 0; i < navMenuItemsList().size(); i++) {
            System.out.println(i+"/"+ navMenuItemsList().size()+" - "+ navMenuItemsList().get(i).getText());
            navMenuItemsList().get(i).click();
            //explicitWait.until(ExpectedConditions.visibilityOf(navMenuClosed()));
            titles.add(driver.getTitle());
            driver.navigate().back(); //  or call method - openPage(PagesLinks.mainUrl);
        }
    }
    public boolean checkAllTitlesFromNavMenu(){
        boolean failTitle=false;
        for (int i = 0; i < titles.size(); i++) {
            if(titles.get(i)!=null && titles.get(i)!=""){
                failTitle = false;
                System.out.println(titles.get(i));
            } else {failTitle = true;}
        }
        return failTitle;
    }

}
