package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

/**
 * Manages the {@link WebDriver} instance by implementing the Singleton design pattern.
 * <p>
 * This class uses {@link ThreadLocal} to store the driver, ensuring that
 * each execution thread (in parallel tests) has its own isolated browser instance,
 * preventing conflicts between concurrent tests.
 * </p>
 */

public class DriverManager {

    private static DriverManager instance = null;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){
    }

    public static DriverManager getInstance(){
        if(instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() throws IOException {
        if (driver.get() == null) {
            String browser = ConfigReader.getProperties("browser");
            if (browser == null || browser.isBlank()) {
                browser = "chrome";
            }

            try {
                BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
                driver.set(browserType.createDriver());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(
                        "Browser '" + browser + "' is not supported. " +
                                "Valid options are: chrome, firefox, edge, safari."
                );
            }
        }
        return driver.get();
    }

    public void closeDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
