package mobile.android.browser.suites;

import mobile.android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import ui.enums.Titles;
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
        when:
        homePage.navigate();

        then:
        assertEquals(Titles.HOME_PAGE.getValue(), appiumDriver.getTitle());
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
