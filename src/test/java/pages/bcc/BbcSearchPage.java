package pages.bcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page class containing element getters and page actions for BBC Search Page
 */
public class BbcSearchPage {
    private static final By bySearchBox = By.id("search-input");
    private static final By bySearchButton = By.cssSelector("button[data-testid='test-search-submit']");

    WebDriver driver;
    public BbcSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(bySearchBox);
    }

    public WebElement getSearchButton() {
        return driver.findElement(bySearchButton);
    }

    public void verifySearchResult(String searchResultText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'PromoContent')]/div/p[contains(text(), 'Houghton Mifflin')]")));
    }


}
