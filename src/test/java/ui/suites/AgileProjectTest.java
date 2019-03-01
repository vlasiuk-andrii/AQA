package ui.suites;

import org.testng.annotations.Test;
import ui.BaseUiTest;
import ui.pages.AgileProjectPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class AgileProjectTest extends BaseUiTest {

    AgileProjectPage agileProjectPage;

    public AgileProjectTest() throws IOException {
        super();
        agileProjectPage = new AgileProjectPage(webDriver);
    }

    @Test
    public void fullHappyPathTest(){
        agileProjectPage.navigate();
        agileProjectPage.logIn("1303", "Guru99");
        agileProjectPage.rememberNewPageUrl(getCurrentUrl());

        assertTrue(agileProjectPage.getAgileProjectMenuFragment().isRootElementDisplayed());
        assertTrue(agileProjectPage.getAgileProjectTableFragment().isRootElementDisplayed());
    }
}
