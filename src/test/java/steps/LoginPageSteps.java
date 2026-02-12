package steps;

import io.cucumber.java.en.And;
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

    @And("the user clears the input fields")
    public void the_user_clears_the_input_fields() {
        loginPage.clearUsername();
        loginPage.clearPassword();
    }

    @And("the user clicks the Login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @When("the user enters any username {string}")
    public void the_user_enters_any_username(String string) {
        loginPage.enterUsername(string);
    }

    @When("the user enters any password {string}")
    public void the_user_enters_any_password(String string) {
        loginPage.enterPassword(string);
    }

    @When("the user clears the {string} input")
    public void the_user_clears_the_input(String string) {
        loginPage.clearPassword();
    }
    @When("the user enters a valid username {string}")
    public void the_user_enters_a_valid_username(String string) {
        loginPage.enterUsername(string);
    }
    @When("the user enters a valid password {string}")
    public void the_user_enters_a_valid_password(String string) {
        loginPage.enterPassword(string);
    }

    @Then("the error message {string} should be displayed")
    public void the_error_message_should_be_displayed(String expectedErrorMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(
                "The error message does not match. Expected: " + expectedErrorMessage +
                        " | Currently: " + actualMessage,
                actualMessage.contains(expectedErrorMessage));
    }
}
