package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By headerTitle = By.xpath("//div[@class='app_logo']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderTitle() {
        return getText(headerTitle);
    }

    public String getUrl() {
        return getCurrentUrl();
    }
}
