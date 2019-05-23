import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import main.driver.CustomWebDriverManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps"},
        plugin = { "pretty", "html:target/htmlreports" }
)
public class TestRunner {

    @AfterClass
    public static void teardown() {
        CustomWebDriverManager.getWebDriver().close();
    }
}
