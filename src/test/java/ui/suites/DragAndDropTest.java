package ui.suites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.BasicTest;
import ui.pages.DragAndDropPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends BasicTest {

    DragAndDropPage dragAndDropPage;

    @BeforeTest
    public void setupPages(){
        dragAndDropPage = new DragAndDropPage(driver);
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
