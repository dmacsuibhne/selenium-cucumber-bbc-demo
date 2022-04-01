package pages.bcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Page class containing element getters and page actions for BBC Main Page
 */
public class BbcMainPage {
    WebDriver driver;
    WebDriverWait shortWebDriverWait;
    public BbcMainPage(WebDriver driver){
        this.driver = driver;
        shortWebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static final String URL = "https://www.bbc.com/"; // In a real world scenario would determine this at run time to allow for running on test environments also
    private static final By byConsentButton = By.cssSelector("button[aria-label='Consent']");
    private static final By byNavBarMore = By.id("orb-nav-more");
    private static final By byNavBarNews = By.cssSelector("#orb-header li.orb-nav-newsdotcom:not(.orb-nav-hide) > a");
    private static final By bySearchButton = By.id("orbit-search-button");
    private static final By byTitle = By.cssSelector("section.module--header > h2 > span");
    private static final By byTitleAndDate = By.cssSelector("section.module--header > h2");
    private static final String formatCssNavItem = "#orb-header li.%s:not(.orb-nav-hide) > a";
    private static final String dayDateRegex = "[A-Za-z]+, [0-9]{1,2} [A-Za-z]+";;
    private static final String[] expectedNavLinksClass = new String[]{
            "orb-nav-homedotcom",
            "orb-nav-newsdotcom",
            "orb-nav-sport",
            "orb-nav-reeldotcom",
            "orb-nav-worklife",
            "orb-nav-traveldotcom",
            "orb-nav-future",
            "orb-nav-culture",
            "orb-nav-tv",
            "orb-nav-weather",
            "orb-nav-sounds"
    };

    public WebElement getNavBarMore(){
        return driver.findElement(byNavBarMore);
    }

    public WebElement getNavBarNews(){
        return driver.findElement(byNavBarNews);
    }

    public WebElement getSearchButton(){
        return driver.findElement(bySearchButton);
    }

    /**
     * Click through the cookie popup box
     */
    public void consentToCookies(){
        shortWebDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(byConsentButton))
                .click();
    }

    /**
     * Validate that each of the expected nav links is visible
     * Does not verify the link URL
     */
    public void validateNavigationLinks(){
        for (String navClass : expectedNavLinksClass){
            shortWebDriverWait.until(
                    ExpectedConditions.visibilityOfElementLocated(getNavCssSelector(navClass)));
        }
    }

    /**
     * Validate that the displayed day and date match today's day and date
     */
    public void validateDayAndDate(){
        final String expectedDayOfWeek = LocalDate.now().getDayOfWeek().toString();
        final int expectedDayOfMonth = LocalDate.now().getDayOfMonth();
        final String expectedMonth = LocalDate.now().getMonth().toString();

        final String dayAndDate = getDayAndDate();
        final String dayOfWeek = dayAndDate.split(",")[0].toUpperCase();
        final String date = dayAndDate.split(",")[1].trim();
        final int dayOfMonth = Integer.parseInt(date.split(" ")[0]);
        final String month = date.split(" ")[1].toUpperCase();

        assertThat(expectedDayOfWeek, equalTo(dayOfWeek));
        assertThat(expectedDayOfMonth, equalTo(dayOfMonth));
        assertThat(expectedMonth, equalTo(month));
    }

    private String getDayAndDate(){
        final String titleAndDateText = driver.findElement(byTitleAndDate).getAttribute("innerText");
        final String titleText = driver.findElement(byTitle).getAttribute("innerText");
        return titleAndDateText.replace(titleText, "").trim();

    }

    /**
     * Get a cssSelector for a top nav item with the given class.
     * Valid for elements which are visible by default, and which only appear after 'More' is clicked
     */
    private By getNavCssSelector(String navClass){
        return By.cssSelector(
                    String.format(formatCssNavItem, navClass));
    }
}
