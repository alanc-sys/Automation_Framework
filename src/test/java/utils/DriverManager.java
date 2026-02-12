package utils;

import org.openqa.selenium.WebDriver;
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
    /**
     * Retrieves the WebDriver instance for the current thread, initializing it if necessary.
     * <p>
     * The browser selection follows this hierarchy of precedence:
     * <ol>
     * <li><b>Command Line (System Property):</b> Checks for the <code>-Dbrowser</code> property
     * (e.g., <code>mvn test -Dbrowser=edge</code>). This enables CI/CD integration.</li>
     * <li><b>Configuration File:</b> If no system property is found, it reads the <code>browser</code>
     * property from the <code>config.properties</code> file.</li>
     * <li><b>Default:</b> If both are null or empty, <b>Chrome</b> is used by default.</li>
     * </ol>
     * </p>
     *
     * @return The initialized WebDriver (Chrome, Firefox, Edge, or Safari).
     * @throws IOException If an error occurs while reading the configuration file.
     * @throws IllegalArgumentException If the specified browser is not supported.
     */
    public WebDriver getDriver() throws IOException {
        if (driver.get() == null) {

            String browser = System.getProperty("browser");

            if  (browser == null || browser.isBlank()) {
                 browser = ConfigReader.getProperties("browser");

            }
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
