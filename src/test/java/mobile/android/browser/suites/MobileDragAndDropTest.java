package mobile.android.browser.suites;

import mobile.android.browser.AndroidChromeTest;
import org.testng.annotations.Test;
import ui.pages.DragAndDropPage;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MobileDragAndDropTest extends AndroidChromeTest {

    DragAndDropPage dragAndDropPage = new DragAndDropPage(appiumDriver);

    public MobileDragAndDropTest() throws IOException {
    }

    @Test
    public void happyPathTest(){
        when:
        dragAndDropPage.navigate();
        assertFalse(dragAndDropPage.successMessageIsShown());
        dragAndDropPage.putDebitAccount("BANK");
        dragAndDropPage.putDebitAmount("5000");
        dragAndDropPage.putCreditAccount("SALES");
        dragAndDropPage.putCreditAmount("5000");

        then:
        assertTrue(dragAndDropPage.successMessageIsShown());
    }
}
