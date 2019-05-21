package android.app;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import android.BaseMobileTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AndroidNativeAppTest extends BaseMobileTest {

    @BeforeSuite
    public void setUp() {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @AfterSuite
    public void tearDown(){
        appiumDriver.closeApp();
        appiumDriver.quit();
    }

}
