package ui;

import main.core.annotation.Parameters;
import org.testng.annotations.Test;
import test.ui.flow.HomeFlow;
import test.ui.flow.NewToursFlow;
import test.ui.flow.TableFlow;
import test.ui.pages.HomePage;
import test.ui.pages.NewToursPage;
import test.ui.pages.TablePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeNavigationTest extends BaseUiTest {

    HomeFlow homeFlow = new HomeFlow();
    NewToursFlow newToursFlow = new NewToursFlow();
    TableFlow tableFlow = new TableFlow();

    @Test
    public void homePageTest() {
        homeFlow.navigate(HomePage.class);

        assertEquals(homeFlow.getHomePage().getClass().getAnnotation(Parameters.class).title(), homeFlow.getHomePage().getTitleFromBrowser());
        assertTrue(homeFlow.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        homeFlow.navigate(HomePage.class);
        homeFlow.getMainMenuFragment().clickOnNewToursButton();

        assertEquals(newToursFlow.getExpectedUrl(NewToursPage.class), getCurrentUrl());
        assertEquals(newToursFlow.getExpectedTitle(NewToursPage.class), newToursFlow.getNewToursPage().getTitleFromBrowser());
        assertTrue(newToursFlow.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        homeFlow.navigate(HomePage.class);
        homeFlow.getMainMenuFragment().clickOnSeleniumDropDown();
        homeFlow.getMainMenuFragment().clickOnTableDemoLink();

        assertEquals(tableFlow.getExpectedUrl(TablePage.class), getCurrentUrl());
        assertEquals(tableFlow.getExpectedTitle(TablePage.class), tableFlow.getTablePage().getTitleFromBrowser());
        assertTrue(tableFlow.isTablePresent());
    }
}
