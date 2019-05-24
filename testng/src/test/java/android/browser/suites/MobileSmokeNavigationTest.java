package android.browser.suites;

import android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import test.ui.enums.PageTitles;
import test.ui.flow.HomeFlow;
import test.ui.flow.NewToursFlow;
import test.ui.flow.TableFlow;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MobileSmokeNavigationTest extends AndroidChromeTest {

    HomeFlow homeFlow = new HomeFlow();
    NewToursFlow newToursFlow = new NewToursFlow();
    TableFlow tableFlow = new TableFlow();

    @Test
    public void homePageTest() {
        homeFlow.navigate();

        assertEquals(PageTitles.HOME_PAGE.getValue(), appiumDriver.getTitle());
        assertTrue(homeFlow.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        homeFlow.navigate();
        homeFlow.getMainMenuFlow().clickOnNewToursButton();

        assertEquals(newToursFlow.getDefaultUrl(), getCurrentUrl());
        assertEquals(PageTitles.NEW_TOURS_PAGE.getValue(), newToursFlow.getTitleFromBrowser());
        assertTrue(newToursFlow.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        homeFlow.navigate();
        homeFlow.getMainMenuFlow().clickOnSeleniumDropDown();
        homeFlow.getMainMenuFlow().clickOnTableDemoLink();

        assertEquals(tableFlow.getDefaultUrl(), getCurrentUrl());
        assertEquals(PageTitles.TABLE_PAGE.getValue(), tableFlow.getTitleFromBrowser());
        assertTrue(tableFlow.isTablePresent());
    }
}
