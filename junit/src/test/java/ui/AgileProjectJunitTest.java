package ui;

import org.junit.jupiter.api.Test;
import test.ui.pages.AgileProjectPage;

import static org.testng.Assert.assertTrue;

public class AgileProjectJunitTest extends BaseUiJunitTest {

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
