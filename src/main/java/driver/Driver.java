package driver;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

    public static WebDriver driver;
    public static String currentDirectoryPath = System.getProperty("user.dir");

    public static WebDriver getInstance(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();

//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--no-sandbox");
//            options.addArguments("window-size=1920x1080");
//            options.addArguments("--disable-dev-shm-usage");
//            driver = new ChromeDriver(options);

            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--test-type");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-first-run");
            chromeOptions.addArguments("--no-default-browser-check");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(chromeOptions);


//
//            System.setProperty("webdriver.chrome.driver", currentDirectoryPath + "\\drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
        }
        return driver;
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
    }

    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
