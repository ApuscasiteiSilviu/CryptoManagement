package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserReadProperties {
    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    FileInputStream objFile;

    public UserReadProperties(){
        try {
            objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\user.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(objFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public String getUsernameApplication(){
        return properties.getProperty("usernameApplication");
    }

    public String getPasswordApplication() { return properties.getProperty("passwordApplication");}

    public String getCryptoCoin(){ return properties.getProperty("cryptoCoin"); }

    public String getGmailAccount(){
        return properties.getProperty("gmailAccount");
    }
}
