package ui.suites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;
import ui.BasicTest;
import ui.pages.HomePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTest extends BasicTest {

    HomePage homePage;

    @BeforeTest
    public void setupDriver(){
        homePage = new HomePage(driver);
    }

    @Test
    public void firstTest() {
        String baseUrl = PropertiesHolder.getProperty("baseUrl");
        String expectedTitle = "Welcome: Mercury Tours";

        when:
        homePage.navigate();

        then:
        assertEquals(expectedTitle, driver.getTitle());
        assertTrue(homePage.isMainFragmentPresent());
    }
}
