package steps.bbc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.bcc.BbcSearchPage;
import testContext.TestContext;

public class BbcSeachPageSteps {
    private BbcSearchPage bbcSearchPage;
    public BbcSeachPageSteps(TestContext testContext) {
        this.bbcSearchPage = new BbcSearchPage(testContext.getDriver());
    }

    @And("I search for {string}")
    public void iSearchFor(String searchText) {
        bbcSearchPage.getSearchBox().sendKeys(searchText);
        bbcSearchPage.getSearchButton().click();
    }

    @Then("one of the search results mentions {string}")
    public void oneOfTheSearchResultsMentions(String searchResultText) {
        bbcSearchPage.verifySearchResult(searchResultText);
    }
}
