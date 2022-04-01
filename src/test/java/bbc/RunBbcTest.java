package bbc;

import io.cucumber.java.After;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import testContext.TestContext;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

/**
 * Test runner class to run all the BBC tests in this repo
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("bbc")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunBbcTest {
    public TestContext testContext;

    public RunBbcTest(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void closeBrowser() {
        testContext.getDriver().close();
    }


}
