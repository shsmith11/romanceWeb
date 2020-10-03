package pageObjects;

import data.PagesLinks;
import org.openqa.selenium.WebDriver;

public class LeftCornerMenuPage extends BasePage{
    public LeftCornerMenuPage(WebDriver driver) {
        super(driver);
        openPage(PagesLinks.prettyWomanUrl);
    }
}
