package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

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
            String browserType  = ConfigReader.getProperties("browser");
            if (browserType == null) browserType = "chrome";

            switch (browserType.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                case "safari":
                    driver.set(new SafariDriver());
                    break;
            }
        }
        return driver.get();
    }

    public void closeDriver(){
        if(driver.get() != null){
            driver.get().close();
            driver.remove();
        }
    }
}
