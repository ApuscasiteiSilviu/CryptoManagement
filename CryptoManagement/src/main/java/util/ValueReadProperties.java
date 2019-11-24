package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ValueReadProperties {

    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    FileInputStream objFile;

    public ValueReadProperties(){
        try {
            objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(objFile);
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
