package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Class for driver setup tasks
 */
public class WebDriverSetup {

    private static final Dimension DESKTOP_DIMENSION = new Dimension(1366, 768);
    private static final Dimension MOBILE_DIMENSION = new Dimension(414, 896);

    public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver startDriver(String browser, Dimension screenSize){
        WebDriver driver;
        switch (browser) {
            case "chrome":
                driver = getChromeDriver();
                break;
            case "firefox":
                driver = getFirefoxDriver();
                break;
            default:
                throw new RuntimeException(String.format("Unknown browser '%s'", browser));
        }
        driver.manage().window().setSize(screenSize);
        return driver;
    }

    public static WebDriver startDriver(String browser, String screenSize){
        return startDriver(browser, convertStringToDimension(screenSize));
    }

    private static Dimension convertStringToDimension(String screenSize){
        Dimension screenDimension;
        switch (screenSize) {
            case "desktop":
                screenDimension = DESKTOP_DIMENSION;
                break;
            case "mobile":
                screenDimension = MOBILE_DIMENSION;
                break;
            default:
                throw new RuntimeException(String.format("Unknown screen size '%s'", screenSize));
        }
        return screenDimension;
    }
}
