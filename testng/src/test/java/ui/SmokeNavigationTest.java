package ui;

import org.testng.annotations.Test;
import test.ui.flow.HomeFlow;
import test.ui.flow.NewToursFlow;
import test.ui.flow.TableFlow;
import test.ui.pages.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeNavigationTest extends BaseUiTest {

    HomeFlow homeFlow = new HomeFlow();
    NewToursFlow newToursFlow = new NewToursFlow();
    TableFlow tableFlow = new TableFlow();

    @Test
    public void homePageTest() {
        homeFlow.navigate(page(HomePage.class).getUrl());

        assertEquals(homeFlow.getHomePage().getDefaultTitle(), homeFlow.getHomePage().getTitleFromBrowser());
        assertTrue(homeFlow.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        homeFlow.navigate(page(HomePage.class).getUrl());
        homeFlow.getMainMenuFragment().clickOnNewToursButton();

        assertEquals(newToursFlow.getNewToursPage().getDefaultUrl(), getCurrentUrl());
        assertEquals(newToursFlow.getNewToursPage().getDefaultTitle(), newToursFlow.getNewToursPage().getTitleFromBrowser());
        assertTrue(newToursFlow.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        homeFlow.navigate(page(HomePage.class).getUrl());
        homeFlow.getMainMenuFragment().clickOnSeleniumDropDown();
        homeFlow.getMainMenuFragment().clickOnTableDemoLink();

        assertEquals(tableFlow.getDefaultUrl(), getCurrentUrl());
        assertEquals(tableFlow.getDefaultTitle(), tableFlow.getTitleFromBrowser());
        assertTrue(tableFlow.isTablePresent());
    }
}
