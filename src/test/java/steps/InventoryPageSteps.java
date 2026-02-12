package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.InventoryPage;
import utils.DriverManager;

import java.io.IOException;

public class InventoryPageSteps {
    private final InventoryPage inventoryPage = new InventoryPage(DriverManager.getInstance().getDriver());

    public InventoryPageSteps() throws IOException {
    }

    @Then("the dashboard title should be {string}")
    public void the_dashboard_title_should_be(String expectedTitle) {
        String actualTitle = inventoryPage.getHeaderTitle();
        Assert.assertTrue("The current title does not match the expected one: " + expectedTitle +
                " | Currently: " + actualTitle, actualTitle.contains(expectedTitle));
    }
    @Then("the current URL should contain {string}")
    public void the_current_url_should_contain(String contain) {
        String actualUrl = inventoryPage.getUrl();
        Assert.assertTrue("The Url currently: " + actualUrl +
                "does not contain: " + contain, actualUrl.contains(contain));
    }
}
