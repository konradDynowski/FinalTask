import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressesPage;
import pages.general.FormPage;
import pages.general.HeaderPage;
import pages.general.LoginPage;
import pages.general.SignedPage;
import pages.subpages.AddressMiniature;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Steps1 {
    private WebDriver driver;

    @Given("user is on the main page")
    public void userIsOnTheMainPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("user signs in")
    public void userSignsIn() {
        new HeaderPage(driver).clickSignIn();
        new LoginPage(driver)
                .typeLogin("udremyocwbqhaslcnv@bvhrs.com")
                .typePassword("password")
                .submit();
    }

    @And("clicks Addresses")
    public void clicksAddresses() {
        SignedPage page = new SignedPage(driver);
        if (page.isFirstToAdd()) {
            page.clickAddresses();
        } else {
            page.clickAddresses();
            new AddressesPage(driver).clickAddAddress();
        }
    }

    @When("creates new address with given {string}, {string}, {string}, {string}, {string} and {string}")
    public void creates_new_address_with_given_and(String alias, String address, String city, String zip, String country, String phone) {
        new FormPage(driver)
                .fillAlias(alias)
                .fillAddress(address)
                .fillCity(city)
                .fillZip(zip)
                .fillCountry(country)
                .fillPhone(phone)
                .submit();
    }

    @Then("checks if in {string} are correct {string}, {string}, {string}, {string} and {string}")
    public void checksIfInAliasAreCorrectAddressCityZipcodeCountryAndPhone(String alias, String address, String city,
                                                                           String zip, String country, String phone) {
        List<String> miniatures = new AddressesPage(driver).getMiniatures();
        String finalMiniature = null;
        for (String miniature : miniatures) {
            if (miniature.contains(alias)) {
                finalMiniature = miniature;
                break;
            }
        }
        assertThat(finalMiniature)
                .containsIgnoringWhitespaces(address)
                .containsIgnoringWhitespaces(city)
                .containsIgnoringWhitespaces(zip)
                .containsIgnoringWhitespaces(country)
                .containsIgnoringWhitespaces(phone);
        driver.quit();
    }

}
