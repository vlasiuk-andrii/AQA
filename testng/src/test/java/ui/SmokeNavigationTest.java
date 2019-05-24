package ui;

import org.testng.annotations.Test;
import test.ui.flow.HomeFlow;
import test.ui.flow.NewToursFlow;
import test.ui.flow.TableFlow;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeNavigationTest extends BaseUiTest {

    HomeFlow homeFlow = new HomeFlow();
    NewToursFlow newToursFlow = new NewToursFlow();
    TableFlow tableFlow = new TableFlow();

    @Test
    public void homePageTest() {
        homeFlow.navigate();

        assertEquals(homeFlow.getDefaultTitle(), homeFlow.getTitleFromBrowser());
        assertTrue(homeFlow.isLoginFormPresent());
    }

    @Test
    public void newToursPageTest() {
        homeFlow.navigate();
        homeFlow.getMainMenuFlow().clickOnNewToursButton();

        assertEquals(newToursFlow.getDefaultUrl(), getCurrentUrl());
        assertEquals(newToursFlow.getDefaultTitle(), newToursFlow.getTitleFromBrowser());
        assertTrue(newToursFlow.isMainFragmentPresent());
    }

    @Test
    public void tablePageTest() {
        homeFlow.navigate();
        homeFlow.getMainMenuFlow().clickOnSeleniumDropDown();
        homeFlow.getMainMenuFlow().clickOnTableDemoLink();

        assertEquals(tableFlow.getDefaultUrl(), getCurrentUrl());
        assertEquals(tableFlow.getDefaultTitle(), tableFlow.getTitleFromBrowser());
        assertTrue(tableFlow.isTablePresent());
    }
}
