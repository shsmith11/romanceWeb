package pageObjects;

import data.PagesLinks;
import org.openqa.selenium.WebDriver;

public class PhotosPage extends BasePage{
    public PhotosPage(WebDriver driver) {
        super(driver);
        openPage(PagesLinks.photosUrl);
    }
}
