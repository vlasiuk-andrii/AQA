package ui.suites;

import org.testng.annotations.Test;
import ui.BaseUiTest;
import ui.pages.DragAndDropPage;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends BaseUiTest {

    DragAndDropPage dragAndDropPage;

    public DragAndDropTest() throws IOException {
        super();
        dragAndDropPage = new DragAndDropPage(webDriver);
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
