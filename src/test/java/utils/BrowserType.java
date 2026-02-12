package utils;

import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public enum BrowserType {

    CHROME(ChromeDriver::new),
    FIREFOX(FirefoxDriver::new),
    EDGE(EdgeDriver::new),
    SAFARI(SafariDriver::new);

    private final Supplier<WebDriver> driverSupplier;

    BrowserType(Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    public WebDriver createDriver() {
        return driverSupplier.get();
    }
}
