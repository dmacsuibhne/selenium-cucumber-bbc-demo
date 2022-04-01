package testContext;

import lombok.Data;
import org.openqa.selenium.WebDriver;

/**
 * Class for sharing data between tests steps. Injected via cucumber-picocontainer
 */
@Data
public class TestContext {
    private WebDriver driver;
}
