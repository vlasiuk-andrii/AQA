package mobile.android.browser.tests;

import mobile.android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import ui.suites.SmokeNavigationTest;

public class SmokeTests extends AndroidChromeTest {

    SmokeNavigationTest smokeNavigationTest = new SmokeNavigationTest();

    @Test
    public void smokeTest() {
        smokeNavigationTest.homePageTest();
    }
}
