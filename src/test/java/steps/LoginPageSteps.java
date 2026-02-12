package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;
import java.io.IOException;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());

    public LoginPageSteps() throws IOException {
    }

    @Given("the user is on the Swag Labs login page")
    public void the_user_is_on_the_swag_labs_login_page() throws IOException {
        String url = ConfigReader.getProperties("url");
        DriverManager.getInstance().getDriver().get(url);
    }

    @When("the user enters any credentials")
    public void the_user_enters_any_credentials() throws IOException {
        loginPage.enterUsername(ConfigReader.getProperties("username"));
        loginPage.enterPassword(ConfigReader.getProperties("password"));
    }

    @When("the user clears the input fields")
    public void the_user_clears_the_input_fields() {
        loginPage.clearInputs();
    }

    @When("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedErrorMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(
                "El mensaje de error no coincide. Esperado: " + expectedErrorMessage +
                        " | Actual: " + actualMessage,
                actualMessage.contains(expectedErrorMessage));
    }
}
