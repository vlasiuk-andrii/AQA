package mobile.android.browser.tests;

import mobile.android.browser.AndroidChromeTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.enums.Titles;
import ui.pages.HomePage;

import java.net.MalformedURLException;

public class MobileBrowserTests extends AndroidChromeTest {

    HomePage homePage = new HomePage(appiumDriver);

    public MobileBrowserTests() throws MalformedURLException {
    }

    @Test
    public void smokeTest() {
        homePage.navigate();
        Assert.assertEquals(Titles.HOME_PAGE.getValue(), appiumDriver.getTitle());
    }
}
