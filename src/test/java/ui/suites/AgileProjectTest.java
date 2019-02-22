package ui.suites;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.BasicTest;
import ui.pages.AgileProjectPage;

import static org.testng.Assert.assertTrue;

public class AgileProjectTest extends BasicTest {

    AgileProjectPage agileProjectPage;

    @BeforeTest
    public void setupPages(){
        agileProjectPage = new AgileProjectPage(driver);
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
