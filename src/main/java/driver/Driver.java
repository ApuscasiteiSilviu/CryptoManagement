package driver;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class Driver {

    public static WebDriver driver;
    public static String currentDirectoryPath = System.getProperty("user.dir");
    public static ClassLoader classLoader = new ClassLoader();

    public static WebDriver getInstance(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", currentDirectoryPath + "/drivers/chromedriver.exe");

//            URL url = classLoader.getResource("chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver", url.toString());
          //  WebDriverManager.chromedriver().setup();
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

    public static void waitForElementToLoad(WebElement element, long timeOutInSeconds) {

        int i = 0;
        while (i < 5){
            try {
                new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
                break;
            }catch (Exception e){
                i++;
                continue;
            }
        }
        System.out.println("Waiting for " + element + ": " + i + " times");
        System.out.println(element.getText());
    }

    public static void waitForElementToBeClickable(WebElement element, long timeOutInSeconds) {

        int i = 0;
        while (i < 1){
            try {
                new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
                break;
            }catch (Exception e){
                i++;
                continue;
            }
        }
        System.out.println("i: " + i);
    }

    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
