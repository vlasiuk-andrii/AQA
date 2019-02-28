package mobile.android.browser.tests;

import mobile.android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import ui.suites.SmokeNavigationTest;

import java.io.IOException;

public class SmokeTests extends AndroidChromeTest {

    SmokeNavigationTest smokeNavigationTest = new SmokeNavigationTest();

    public SmokeTests() throws IOException {
    }

    @Test
    public void smokeTest() {
        smokeNavigationTest.homePageTest();
    }
}
