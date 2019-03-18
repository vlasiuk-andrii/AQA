package mobile.android.browser;

import mobile.android.BaseMobileTest;
import org.testng.annotations.AfterSuite;

public class AndroidChromeTest extends BaseMobileTest {

    @AfterSuite
    public void tearDown(){
        appiumDriver.close();
        appiumDriver.quit();
    }

}
