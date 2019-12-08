package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserReadProperties {
    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    InputStream inputStream;

    public UserReadProperties(){
        inputStream = getClass().getResourceAsStream("/user.properties");

        try {
            properties.load(inputStream);
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
