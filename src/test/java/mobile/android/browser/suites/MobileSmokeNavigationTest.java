package mobile.android.browser.suites;

import mobile.android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import test.ParameterizedSmokeNavigationTest;
import ui.pages.HomePage;
import ui.pages.NewToursPage;
import ui.pages.TablePage;

import java.net.MalformedURLException;

public class MobileSmokeNavigationTest extends AndroidChromeTest {

    HomePage homePage = new HomePage(appiumDriver);
    NewToursPage newToursPage = new NewToursPage(appiumDriver);
    TablePage tablePage = new TablePage(appiumDriver);

    public MobileSmokeNavigationTest() throws MalformedURLException {
    }

    ParameterizedSmokeNavigationTest parameterizedSmokeNavigationTest = new ParameterizedSmokeNavigationTest(
            appiumDriver,
            homePage,
            newToursPage,
            tablePage);

    @Test
    public void homePageTest(){
        parameterizedSmokeNavigationTest.homePageTest();
    }

    @Test
    public void newToursPageTest(){
        parameterizedSmokeNavigationTest.newToursPageTest();
    }

    @Test
    public void tablePageTest(){
        parameterizedSmokeNavigationTest.tablePageTest();
    }


}
