package pageObjects;
import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PhotosPage extends BasePage{
    public PhotosPage(WebDriver driver) {
        super(driver);
        openPage(PagesLinks.photosUrl);
    }
    public String getExpectedTitle() {
        return "Ukrainian women photos: ladies pictures at Marry Ukrainian Lady";
        }

    public boolean getPageTitle() {
        if (driver.getTitle().equals(getExpectedTitle())) {
            return true;
        }
        else {
            System.out.println( "TITLE: Ukrainian women photos: ladies pictures at Marry Ukrainian Lady");
            return false;
        }
    }
    public boolean loadAlbymPictures(){
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Locators.divGallery))));
        List<WebElement> gallery = driver.findElements(By.xpath(Locators.divGalleryPhotos));
        System.out.println("size is  "+gallery.size());
        if (gallery.size() != 0){
            return true;
        } else return false;
    }

}
