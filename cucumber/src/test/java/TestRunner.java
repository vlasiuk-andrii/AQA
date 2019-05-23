import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import main.driver.CustomWebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps"}
)
public class TestRunner {

    @BeforeClass
    public static void setup() {
        System.out.println("BEFORE CUCUMBER SUITE");
    }

    @AfterClass
    public static void teardown() {
        CustomWebDriverManager.getWebDriver().close();
        System.out.println("AFTER CUCUMBER SUITE");
    }
}
