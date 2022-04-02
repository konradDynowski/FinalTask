package pages.general;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignedPage extends BasePage {
    @FindBy(id = "addresses-link")
    private WebElement addressLink;

    public SignedPage(WebDriver driver) {
        super(driver);
    }

    public SignedPage clickAddresses() {
        addressLink.click();
        return this;
    }

    public boolean isFirstToAdd() {
        return addressLink.getText().contains("first");
    }
}
