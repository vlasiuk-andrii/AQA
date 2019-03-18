package mobile.android.app.suites;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import mobile.android.app.AndroidNativeAppTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BaseSumTest extends AndroidNativeAppTest {

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_2')]")
    public MobileElement digit2;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'digit_3')]")
    public MobileElement digit3;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'op_add')]")
    public MobileElement plusButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id, 'eq')]")
    public MobileElement equalButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'result')]")
    public MobileElement resultField;

    @Test
    public void simpleSummTest() {
        digit2.click();
        plusButton.click();
        digit3.click();
        equalButton.click();

        assertEquals("5", resultField.getText());
    }
}
