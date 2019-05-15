package mobile.android.browser.suites;

import mobile.android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import ui.enums.PageTitles;
import ui.pages.HomePage;
import ui.pages.NewToursPage;
import ui.pages.TablePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MobileSmokeNavigationTest extends AndroidChromeTest {

    HomePage homePage = new HomePage();
    NewToursPage newToursPage = new NewToursPage();
    TablePage tablePage = new TablePage();

    @Test
    public void homePageTest() {
        homePage.navigate();

        assertEquals(PageTitles.HOME_PAGE.getValue(), appiumDriver.getTitle());
        assertTrue(homePage.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnNewToursButton();

        assertEquals(newToursPage.getDefaultUrl(), getCurrentUrl());
        assertEquals(PageTitles.NEW_TOURS_PAGE.getValue(), newToursPage.getTitleFromBrowser());
        assertTrue(newToursPage.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnSeleniumDropDown();
        homePage.getMainMenuFragment().clickOnTableDemoLink();

        assertEquals(tablePage.getDefaultUrl(), getCurrentUrl());
        assertEquals(PageTitles.TABLE_PAGE.getValue(), tablePage.getTitleFromBrowser());
        assertTrue(tablePage.isTablePresent());
    }
}
