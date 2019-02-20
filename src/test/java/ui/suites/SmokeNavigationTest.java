package ui.suites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.BasicTest;
import ui.enums.Titles;
import ui.pages.HomePage;
import ui.pages.NewToursPage;
import ui.pages.TablePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeNavigationTest extends BasicTest {

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
        when:
        homePage.navigate();

        then:
        assertEquals(Titles.HOME_PAGE.getValue(), homePage.getTitle());
        assertTrue(homePage.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        when:
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnNewToursButton();

        then:
        assertEquals(newToursPage.getUrl(), getCurrentUrl());
        assertEquals(Titles.NEW_TOURS_PAGE.getValue(), newToursPage.getTitle());
        assertTrue(newToursPage.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        when:
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnSeleniumDropDown();
        homePage.getMainMenuFragment().clickOnTableDemoLink();

        then:
        assertEquals(tablePage.getUrl(), getCurrentUrl());
        assertEquals(Titles.TABLE_PAGE.getValue(), tablePage.getTitle());
        assertTrue(tablePage.isTablePresent());
    }
}
