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

    public String getGmailURL() { return properties.getProperty("gmailURL");}

    public String getGithubURL(){ return properties.getProperty("githubURL"); }

    public String getGitHubUsername(){ return properties.getProperty("githubUsername");}

    public String getGitHubPassword(){ return properties.getProperty("githubPassword");}

    public String getApplicationGmailAccountName(){return properties.getProperty("applicationGmailAccountName");}

    public String getApplicationGmailAccountPassword(){return properties.getProperty("applicationGmailAccountPassword");}
}
