package ui.suites;

import org.testng.annotations.Test;
import ui.BaseUiTest;
import ui.pages.HomePage;
import ui.pages.NewToursPage;
import ui.pages.TablePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeNavigationTest extends BaseUiTest {

    HomePage homePage = new HomePage();
    NewToursPage newToursPage = new NewToursPage();
    TablePage tablePage = new TablePage();

    @Test
    public void homePageTest() {
        homePage.navigate();

        assertEquals(homePage.getDefaultTitle(), homePage.getTitleFromBrowser());
        assertTrue(homePage.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnNewToursButton();

        assertEquals(newToursPage.getDefaultUrl(), getCurrentUrl());
        assertEquals(newToursPage.getDefaultTitle(), newToursPage.getTitleFromBrowser());
        assertTrue(newToursPage.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnSeleniumDropDown();
        homePage.getMainMenuFragment().clickOnTableDemoLink();

        assertEquals(tablePage.getDefaultUrl(), getCurrentUrl());
        assertEquals(tablePage.getDefaultTitle(), tablePage.getTitleFromBrowser());
        assertTrue(tablePage.isTablePresent());
    }
}
