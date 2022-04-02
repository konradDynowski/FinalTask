package pages.general;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(css = "div.user-info a")
    private WebElement signInLink;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignIn() {
        signInLink.click();
    }
}
