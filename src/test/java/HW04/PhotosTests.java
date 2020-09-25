package HW04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosTests extends BaseTest{

    @BeforeMethod
    public void openUrl(){openPage(PagesLinks.photosUrl);}

    @Test
    public void isPhotoPage(){
        Assert.assertEquals(driver.getTitle(), "Pilot Group : Photo gallery");
    }

    @Test
    public void isPicturesLoaded(){
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(Locators.divGallery))));
        List<WebElement> gallery = driver.findElements(By.xpath(Locators.divGalleryPhotos));

        Assert.assertNotNull(gallery.size());
        System.out.println("size is  "+gallery.size());

    }
}
