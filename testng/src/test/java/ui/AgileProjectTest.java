package ui;

import org.testng.annotations.Test;
import test.ui.flow.AgileProjectFlow;
import test.ui.pages.AgileProjectPage;

import static org.testng.Assert.assertTrue;

public class AgileProjectTest extends BaseUiTest {

    AgileProjectFlow agileProjectFlow = new AgileProjectFlow();;

    @Test
    public void fullHappyPathTest() {
        agileProjectFlow.navigate(AgileProjectPage.class);
        agileProjectFlow.logIn("1303", "Guru99");
        agileProjectFlow.refreshPageUrl(getCurrentUrl());

        assertTrue(agileProjectFlow.getAgileProjectMenuFragment().isRootElementDisplayed());
        assertTrue(agileProjectFlow.getAgileProjectTableFragment().isRootElementDisplayed());
    }
}
