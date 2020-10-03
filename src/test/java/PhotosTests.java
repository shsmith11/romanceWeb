import data.Locators;
import data.PagesLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosTests extends BaseTest{


    @Test
    public void isPhotoPage(){
        Assert.assertEquals(driver.getTitle(), "Ukrainian women photos: ladies pictures at Marry Ukrainian Lady");
    }

    @Test
    public void isPicturesLoaded(){
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Locators.divGallery))));
        List<WebElement> gallery = driver.findElements(By.xpath(Locators.divGalleryPhotos));

        Assert.assertNotNull(gallery.size());
        System.out.println("size is  "+gallery.size());

    }
}
