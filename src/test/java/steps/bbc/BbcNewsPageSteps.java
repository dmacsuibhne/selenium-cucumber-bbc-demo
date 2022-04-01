package steps.bbc;

import io.cucumber.java.en.Then;
import pages.bcc.BbcNewsPage;
import testContext.TestContext;

public class BbcNewsPageSteps {
    private BbcNewsPage bbcNewsPage;
    public BbcNewsPageSteps(TestContext testContext) {
        this.bbcNewsPage = new BbcNewsPage(testContext.getDriver());
    }

    @Then("URL of the current page matches the News page URL")
    public void urlOfTheCurrentPageMatchesTheNewsPageURL() {
        bbcNewsPage.assertPageUrl();
    }
}
