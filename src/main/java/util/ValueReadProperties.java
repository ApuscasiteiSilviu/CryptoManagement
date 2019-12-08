package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValueReadProperties {

    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    InputStream inputStream;

    public ValueReadProperties(){
        inputStream = getClass().getResourceAsStream("/value.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLastPrice(){
        return properties.getProperty("lastPrice");
    }

    public String getStartPrice(){
        return properties.getProperty("startPrice");
    }
}
