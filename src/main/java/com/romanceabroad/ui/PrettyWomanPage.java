package com.romanceabroad.ui;
import data.Data;
import data.Helpers;
import data.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class PrettyWomanPage extends BasePage {

    public WebElement dropDownMinAge (){return driver.findElement(By.xpath(Locators.dropDownMinAge));}
    public WebElement dropDownSorter (){return driver.findElement(By.xpath(Locators.dropDownSorter));}
    public List<WebElement> dropDownMinAgeList (){return driver.findElements(By.xpath(Locators.dropDownMinAge));}
    public WebElement dropDownMaxAge (){return driver.findElement(By.xpath(Locators.dropDownMaxAge));}
    public List<WebElement>  dropDownMaxAgeList (){return driver.findElements(By.xpath(Locators.dropDownMaxAge));}
    public List<WebElement>  userNameAgeGallery (){return driver.findElements(By.xpath(Locators.userNameAgeGallery));}
    public WebElement buttonSearch(){return driver.findElement(By.xpath(Locators.buttonSearch));}
    public By BLOCK_MIN_MAX = By.xpath(Locators.blockMinMaxAge);
    public List<WebElement> imageBlock() { return driver.findElements(By.xpath(Locators.imageBlock));}
    public WebElement buttonNextAtGallery() {return driver.findElement(By.xpath(Locators.buttonNextAtGallery));}
    public WebElement buttonLastAtGallery() {return driver.findElement(By.xpath(Locators.buttonLastAtGallery));}
    public WebElement buttonBeforeNextAtGallery() {return driver.findElement(By.xpath(Locators.buttonBeforeNextAtGallery));}
    public List<WebElement> panelPageSelector() {return driver.findElements(By.xpath(Locators.panelPageSelectorTagA));}
    public List<WebElement> panelPageSelectorTagLi() {return driver.findElements(By.xpath(Locators.panelPageSelectorTagLi));}


    Select selectMinAge;
    Select selectMaxAge;
    List<String> collectedData = new ArrayList<>();

    public PrettyWomanPage(WebDriver driver) {
        super(driver, explicitWait);
    }

    public Select selectMinAge(){
        if (selectMinAge == null) {
            return new Select(dropDownMinAge());
        } else return selectMinAge;

    }
    public Select selectMaxAge(){
        if (selectMaxAge == null) {
            return new Select(dropDownMaxAge());
        } else return selectMaxAge;

    }
    public String pageTitleExpected(){
        fluentWait.until(x -> x.findElement(BLOCK_MIN_MAX).isDisplayed());
        return "Meet single Ukrainian women online: dating and marriage at Marry Ukrainian Lady";
    }

    public HashMap<String,String> getRandomMinMaxAgeDropDown(){
        return   Helpers.getDropDownMapRangeByRandomValue(dropDownMinAge(), dropDownMaxAge(),"value");

    }
    /* Here is overload example */

    public void setMinMaxAgeSelect(String min, String max){
        fluentWait.until(x -> x.findElement(BLOCK_MIN_MAX).isDisplayed());
        selectMinAge().selectByValue(min);
        selectMaxAge().selectByValue(max);
    }
    public void setMinMaxAgeSelect(){
        setMinMaxAgeSelect(getRandomMinMaxAgeDropDown().get("min"),getRandomMinMaxAgeDropDown().get("max"));
    }
    public void setSortMode(String sortMode){
        Helpers.setDropDownListByText(dropDownSorter(), sortMode);
    }
    public void setSortMode(){
        setSortMode("Name");
    }

    public boolean imageSearchResult() {
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(imageBlock()));
        List<WebElement> imagesList = driver.findElements(By.xpath(Locators.imageSearchResult));;
        return imagesList.size()>0;
    }

    public List<String> retrieveAgeFromElements() {
        List<WebElement> gallery = userNameAgeGallery();
        List<String> age = new ArrayList<>();
        waitAllImagesLoaded(imageBlock());
        for (int i = 0; i < gallery.size(); i+=2) {
            age.add(gallery.get(i).getText().trim().split(",")[1]);
            System.out.println(" here is retrieveAgeFromElements data " + age.get(age.size()-1));
        }
        System.out.println("List age - " + age);
        return age;
    }

    public Integer pageCounter() throws InterruptedException {
        Thread.sleep(1000);
        waitAllImagesLoaded(imageBlock());
        List<Integer> pageSum = new ArrayList<>();
        Thread.sleep(500);
        if (panelPageSelector().size()!=0) {
            if (checkIfDisplayed(panelPageSelector().get(0))) {
                for (int i = 1; i < panelPageSelector().size(); i++) {
                    System.out.println(panelPageSelector().size());
                    System.out.println("attribute - " + panelPageSelector().get(i).getAttribute("data-page"));
                    System.out.println("text - " + panelPageSelector().get(i).getText());
                    pageSum.add(Integer.parseInt(panelPageSelector().get(i).getAttribute("data-page")));
                }
                System.out.println("Max button value " + Collections.max(pageSum));
            }
        }
        else if (panelPageSelector().size()==0 && imageBlock().size()>0) {
            System.out.println("One page");
            pageSum.add(1);
        } else if (imageBlock().size()==0) {
            System.out.println("No pages");
            pageSum.add(0);
        }
        return Collections.max(pageSum);
    }

    public boolean checkIfDisplayed(WebElement element){
        try {
            element.isDisplayed();
            return true;
        }
        catch (NoSuchElementException  e){
            System.out.println(e + " error happened NoSuchElementException.");
            return false;
        }
        catch (ElementNotInteractableException e){
            System.out.println(e + " error happened ElementNotInteractableException.");
            return false;
        }
        catch (StaleElementReferenceException e){
            System.out.println(e + " error happened ElementNotInteractableException.");
            return false;
        }
    }

    public boolean ifImageLoaded(WebElement image, WebDriver driver){
        Object result = ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && "+
                        "typeof arguments[0].naturalWidth != \"undefined\" && "+
                        "arguments[0].naturalWidth > 0", image);
        boolean loaded = false;
        if (result instanceof Boolean) {
            loaded = (Boolean) result;
            //System.out.println("Pages handled JavascriptExecutor. Loaded - " +loaded);
        }
        return loaded;
    }

    public void waitAllImagesLoaded(List<WebElement> imageBlock) {
        if (imageBlock.size()>0) {
            for (int i = 0; i < imageBlock().size(); i++) {
                WebElement image = imageBlock().get(i);
                fluentWait.until(x -> ifImageLoaded(image, driver));
               // System.out.println("Image" + i + " - status  - " + ifImageLoaded(image, driver));
            }
        } else  System.out.println("No images");
    }

    public List<String> dataPageCollector() throws InterruptedException {
        Thread.sleep(500);
        //Integer pageNum = pageCounter();
        while (isLastPageExist()){
            waitAllImagesLoaded(imageBlock());
            for (int i = 0; i < panelPageSelectorTagLi().size(); i++) {
                if (panelPageSelectorTagLi().get(i).getAttribute("class").contains("active")){
                    collectedData.addAll(retrieveAgeFromElements());
                    Helpers.ajaxScroll(buttonNextAtGallery());
                    Helpers.performClick(buttonNextAtGallery());
                }
            }
        }
        collectedData.addAll(retrieveAgeFromElements()); // last page parse
        System.out.println("all data -" + collectedData);
        System.out.println("all size data -" + collectedData.size());
        return collectedData;
    }

    public String getElementAttributeValue(WebElement element, String Attribute){
        return element.getAttribute(Attribute);
    }

    public boolean isLastPageExist() throws InterruptedException {
        boolean nextButtonState=false;
        Thread.sleep(1000);

        for (int i = 0; i < Data.trys; i++) {
            try {
            nextButtonState = driver.findElement(By.xpath(Locators.buttonNextAtGallery)).isDisplayed();
            System.out.println("next buttond found " + driver.findElement(By.xpath(Locators.buttonNextAtGallery)).getText());
            System.out.println("next buttond found " + driver.findElement(By.xpath(Locators.buttonNextAtGallery)).getAttribute("data-page"));
            i = Data.trys;
            }
        catch(NoSuchElementException e){
                System.out.println(e + " error happened NoSuchElementException. last page");
                nextButtonState = false;
            Thread.sleep(Data.tryMS);
            }
        catch(ElementNotInteractableException e){
            System.out.println(e + " error happened ElementNotInteractableException. last page");
            nextButtonState = false;
            Thread.sleep(Data.tryMS);
        }catch(StaleElementReferenceException e){
            System.out.println(e + " error happened ElementNotInteractableException. last page");
            nextButtonState = false;
            Thread.sleep(Data.tryMS);
        }
        }
        return nextButtonState;
    }





    public String getExpectedPeopleFoundOnPage(){
        return "People found: 68"; // TODO put here Data from API in future
    }

}
