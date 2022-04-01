package steps.browser;

import configuration.WebDriverSetup;
import io.cucumber.java.en.Given;
import testContext.TestContext;

public class BrowserSteps {
    private TestContext testContext;

    public BrowserSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @Given("I open a {word} browser window at {word} size")
    public void iOpenMyBrowser(String browser, String screenSize) {
        testContext.setDriver(
                WebDriverSetup.startDriver(browser, screenSize));
    }
}
