package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//Documentation use: https://programandoapasitos.com/2017/12/leer-ficheros-en-java.html
public class ConfigReader {
    private static Properties properties = null;

    private ConfigReader() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileReader("config.properties"));
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }




}
