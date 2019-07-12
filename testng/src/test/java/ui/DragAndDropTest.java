package ui;

import org.testng.annotations.Test;
import test.ui.flow.DragAndDropFlow;
import test.ui.pages.DragAndDropPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends BaseUiTest {

    DragAndDropFlow dragAndDropFlow = new DragAndDropFlow();

    @Test
    public void happyPathTest() {
        dragAndDropFlow.navigate(DragAndDropPage.class);
        assertFalse(dragAndDropFlow.successMessageIsShown());
        dragAndDropFlow.putDebitAccount("BANK");
        dragAndDropFlow.putDebitAmount("5000");
        dragAndDropFlow.putCreditAccount("SALES");
        dragAndDropFlow.putCreditAmount("5000");

        assertTrue(dragAndDropFlow.successMessageIsShown());
    }
}
