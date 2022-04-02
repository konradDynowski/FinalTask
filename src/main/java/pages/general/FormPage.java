package pages.general;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BasePage {
    @FindBy(css = "input[name='alias']")
    private WebElement aliasInput;
    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;
    @FindBy(css = "input[name='city']")
    private WebElement cityInput;
    @FindBy(css = "input[name='postcode']")
    private WebElement zipInput;
    @FindBy(css = "select[name='id_country']")
    private WebElement countrySel;
    @FindBy(css = "input[name='phone']")
    private WebElement phoneInput;
    @FindBy(css = "button.btn-primary")
    private WebElement saveButton;


    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage fillAlias(String alias) {
        aliasInput.sendKeys(alias);
        return this;
    }

    public FormPage fillAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public FormPage fillCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public FormPage fillZip(String zipcode) {
        zipInput.sendKeys(zipcode);
        return this;
    }

    public FormPage fillCountry(String country) {
        new Select(countrySel).selectByVisibleText(country.trim());
        return this;
    }

    public FormPage fillPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public void submit() {
        saveButton.click();
    }
}
