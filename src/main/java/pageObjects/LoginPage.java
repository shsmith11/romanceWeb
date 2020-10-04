package pageObjects;

import data.PagesLinks;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        openPage(PagesLinks.logInUrl);
    }
}