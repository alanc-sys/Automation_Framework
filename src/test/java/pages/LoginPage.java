package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private final By usernameInput = By.xpath("//input[@id='user-name']") ;
    private final By passwordInput = By.xpath("//input[@id='password']") ;
    private final By loginButton = By.xpath("//input[@id='login-button']") ;
    private final By errorMessage =  By.xpath("//h3[@data-test='error']") ;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        sendKeys(usernameInput, username);
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public void clearUsername() {
        clearInput(usernameInput);
    }

    public void clearPassword() {
        clearInput(passwordInput);
    }
}
