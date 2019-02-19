package ui.suites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import properties.PropertiesHolder;
import ui.BasicTest;
import ui.pages.HomePage;
import ui.pages.NewToursPage;
import ui.pages.TablePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeContentVerificationTest extends BasicTest {

    HomePage homePage;
    NewToursPage newToursPage;
    TablePage tablePage;

    @BeforeTest
    public void setupDriver(){
        homePage = new HomePage(driver);
        newToursPage = new NewToursPage(driver);
        tablePage = new TablePage(driver);
    }

    @Test
    public void homePageTest() {
        String expectedTitle = "Guru99 Bank Home Page";

        when:
        homePage.navigate();

        then:
        assertEquals(expectedTitle, driver.getTitle());
        assertTrue(homePage.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        String expectedTitle = "Welcome: Mercury Tours";

        when:
        homePage.navigate();

        then:
        assertEquals(expectedTitle, driver.getTitle());
        assertTrue(homePage.isLoginFormPresent());
    }
}
