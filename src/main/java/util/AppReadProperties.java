package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppReadProperties {

    String currentDirectoryPath = System.getProperty("user.dir");
    Properties properties = new Properties();
    InputStream inputStream;

    public AppReadProperties(){

        inputStream = getClass().getResourceAsStream("/application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get methods for URLs
    public String getTradingViewURL(){
        return properties.getProperty("tradingViewURL");
    }

    public String getGmailURL() { return properties.getProperty("gmailURL");}

    public String getGithubURL(){ return properties.getProperty("githubURL"); }

    public String getYahooURL(){
        return properties.getProperty("yahooURL");
    }

    public String getGitHubUsername(){ return properties.getProperty("githubUsername");}

    public String getGitHubPassword(){ return properties.getProperty("githubPassword");}

    public String getApplicationGmailAccountName(){return properties.getProperty("applicationGmailAccountName");}

    public String getUsernameApplication() {
        return properties.getProperty("usernameApplication");
    }

    public String getPasswordApplication() {
        return properties.getProperty("passwordApplication");
    }
}
