package steps.bbc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.bcc.BbcMainPage;
import testContext.TestContext;

public class BbcMainPageSteps {
    private TestContext testContext;
    private BbcMainPage bbcMainPage;
    public BbcMainPageSteps(TestContext testContext){
        this.testContext = testContext;
        bbcMainPage = new BbcMainPage(testContext.getDriver());
    }

    @Then("I see all of the expected top navigation links")
    public void iSeeAllOfTheTopNavigationLinks() {
        bbcMainPage.validateNavigationLinks();
    }

    @When("I allow cookies from bbc")
    public void iAllowCookiesFromBbc() {
        bbcMainPage.consentToCookies();
    }

    @When("I expand all of the top navigation bars")
    public void iExpandAllOfTheTopNavigationBars() {
        bbcMainPage.getNavBarMore().click();
    }

    @Then("the correct day and date is displayed")
    public void theCorrectDayAndDateIsDisplayed() {
        bbcMainPage.validateDayAndDate();
    }

    @When("I click the 'News' nav button")
    public void iClickTheNewsNavButton() {
        bbcMainPage.getNavBarNews().click();
    }

    @When("I navigate to the BBC main page")
    public void iNavigateToTheBBCMainPage() {
        testContext.getDriver().navigate().to(BbcMainPage.URL);
    }

    @And("I click the main page search button")
    public void iClickTheMainPageSearchButton() {
        bbcMainPage.getSearchButton().click();
    }
}
