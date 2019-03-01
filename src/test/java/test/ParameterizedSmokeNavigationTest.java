package test;

import ui.enums.Titles;
import ui.pages.HomePage;
import ui.pages.NewToursPage;
import ui.pages.TablePage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ParameterizedSmokeNavigationTest extends LocalDriver {

    LocalDriver localDriver;
    HomePage homePage;
    NewToursPage newToursPage;
    TablePage tablePage;

    public ParameterizedSmokeNavigationTest(Object driverObject,
                                            HomePage homePage,
                                            NewToursPage newToursPage,
                                            TablePage tablePage){
        super(driverObject);
        localDriver = getCorrectDriver();
        this.homePage = homePage;
        this.newToursPage = newToursPage;
        this.tablePage = tablePage;
    }

    public void homePageTest() {
        when:
        homePage.navigate();

        then:
        assertEquals(Titles.HOME_PAGE.getValue(), localDriver.getTitle());
        assertTrue(homePage.isLoginFormPresent());
    }

    public void newToursPageTest() {
        when:
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnNewToursButton();

        then:
        assertEquals(newToursPage.getUrl(), driver.getCurrentUrl());
        assertEquals(Titles.NEW_TOURS_PAGE.getValue(), newToursPage.getTitle());
        assertTrue(newToursPage.isMainFragmentPresent());
    }

    public void tablePageTest() {
        when:
        homePage.navigate();
        homePage.getMainMenuFragment().clickOnSeleniumDropDown();
        homePage.getMainMenuFragment().clickOnTableDemoLink();

        then:
        assertEquals(tablePage.getUrl(), driver.getCurrentUrl());
        assertEquals(Titles.TABLE_PAGE.getValue(), tablePage.getTitle());
        assertTrue(tablePage.isTablePresent());
    }
}
