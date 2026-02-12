package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//Documentation use: https://www.programandoapasitos.com/2017/12/leer-ficheros-properties-en-java.html
public class ConfigReader {

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
