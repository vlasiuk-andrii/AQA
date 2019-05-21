package ui;

import org.testng.annotations.Test;
import test.ui.pages.AgileProjectPage;

import static org.testng.Assert.assertTrue;

public class AgileProjectTest extends BaseUiTest {

    AgileProjectPage agileProjectPage = new AgileProjectPage();;

    @Test
    public void fullHappyPathTest(){
        agileProjectPage.navigate();
        agileProjectPage.logIn("1303", "Guru99");
        agileProjectPage.rememberNewPageUrl(getCurrentUrl());

        assertTrue(agileProjectPage.getAgileProjectMenuFragment().isRootElementDisplayed());
        assertTrue(agileProjectPage.getAgileProjectTableFragment().isRootElementDisplayed());
    }
}
