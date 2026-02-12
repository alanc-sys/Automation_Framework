package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties from config.properties file.
 * Implements Singleton pattern implicitly via static access.
 */

public class ConfigReader {
    /**
     * Retrieves the value for a specific key from the properties file.
     * @param key The property key to search for.
     * @return The string value of the property.
     */

    private static Properties properties = null;

    private ConfigReader() throws IOException {
        properties = new Properties();
        properties.load(new FileReader("src/test/resources/config.properties"));
    }

    public static String getProperties(String key) throws IOException {

        if (properties == null) {
            new ConfigReader();
        }

        return properties.getProperty(key);
    }




}
