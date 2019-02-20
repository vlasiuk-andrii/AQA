package ui.suites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
        assertEquals(expectedTitle, homePage.getTitle());
        assertTrue(homePage.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        String expectedTitle = "Welcome: Mercury Tours";

        when:
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnNewToursButton();

        then:
        assertEquals(newToursPage.getUrl(), getCurrentUrl());
        assertEquals(expectedTitle, newToursPage.getTitle());
        assertTrue(newToursPage.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        String expectedTitle = "Table Demo";

        when:
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnSeleniumDropDown();
        homePage.getMainMenuFragment().clickOnTableDemoLink();

        then:
        assertEquals(tablePage.getUrl(), getCurrentUrl());
        assertEquals(expectedTitle, tablePage.getTitle());
        assertTrue(tablePage.isTablePresent());
    }
}
