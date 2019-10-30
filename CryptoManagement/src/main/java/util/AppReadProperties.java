package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppReadProperties {

    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    FileInputStream objFile;

    public AppReadProperties(){
        try {
            objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\application.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(objFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get methods for URLs
    public String getTradingViewURL(){
        return properties.getProperty("tradingViewURL");
    }

    public String getUsername(){
        return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

    public String getCryptoCoin(){
        return properties.getProperty("cryptoCoin");
    }

    public String getLastPrice(){
        return properties.getProperty("lastPrice");
    }

    public String getGmailURL() { return properties.getProperty("gmailURL");}

    public String getGmailAccount(){
        return properties.getProperty("gmailAccount");
    }

}
