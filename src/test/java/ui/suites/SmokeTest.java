package ui.suites;

import org.testng.Assert;
import org.testng.annotations.Test;
import properties.PropertiesHolder;
import ui.BasicTest;

public class SmokeTest extends BasicTest {

    @Test
    public void firstTest() {
        String baseUrl = PropertiesHolder.getProperty("baseUrl");
        String expectedTitle = "Welcome: Mercury Tours";

        driver.get(baseUrl);

        Assert.assertEquals(expectedTitle, driver.getTitle());
    }
}
