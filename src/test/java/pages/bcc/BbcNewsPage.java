package pages.bcc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page class containing relevant actions for BBC News Page
 */
public class BbcNewsPage {
    public static final String URL = "https://www.bbc.com/news"; // In a real world scenario would determine this at run time to allow for running on test environments also


    WebDriver driver;
    public BbcNewsPage(WebDriver driver){
        this.driver = driver;
    }

    public void assertPageUrl(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.urlToBe(URL));
    }
}
