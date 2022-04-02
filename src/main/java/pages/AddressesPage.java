package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.subpages.AddressMiniature;

import java.util.ArrayList;
import java.util.List;

public class AddressesPage extends BasePage {
    @FindBy(css = "div.addresses-footer a")
    private WebElement createNewAddressLink;
    @FindBy(css = "div.address-body")
    private List<WebElement> miniatures;

    public AddressesPage(WebDriver driver) {
        super(driver);
    }
    public void clickAddAddress(){
        createNewAddressLink.click();
    }

    public List<String> getMiniatures() {
        List<String> addressMiniatures = new ArrayList<>();
        for (WebElement element: miniatures) {
            addressMiniatures.add(element.getText());
        }
        return addressMiniatures;
    }
}
