package pages.general;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;
    @FindBy(css = "#content input[type='email']")
    private WebElement loginInput;
    @FindBy(id = "submit-login")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
