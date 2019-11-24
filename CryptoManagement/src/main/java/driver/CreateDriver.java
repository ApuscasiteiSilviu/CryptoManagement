package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateDriver {

    public static WebDriver driver;
    public static String currentDirectoryPath = System.getProperty("user.dir");

    public static WebDriver getInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", currentDirectoryPath + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void closeAllTabsExeptOne(String originalHandle){
        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        driver.switchTo().window(originalHandle);
    }

    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
