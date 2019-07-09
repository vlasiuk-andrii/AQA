package ui;

import org.testng.annotations.Test;
import test.ui.flow.AgileProjectFlow;
import test.ui.pages.AgileProjectPage;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class AgileProjectTest extends BaseUiTest {

    AgileProjectFlow agileProjectFlow = new AgileProjectFlow();;

    @Test
    public void fullHappyPathTest(){
        agileProjectFlow.navigate(page(AgileProjectPage.class).getUrl());
        agileProjectFlow.logIn("1303", "Guru99");
        agileProjectFlow.rememberNewPageUrl(getCurrentUrl());

        assertTrue(agileProjectFlow.getAgileProjectMenuFragment().isRootElementDisplayed());
        assertTrue(agileProjectFlow.getAgileProjectTableFragment().isRootElementDisplayed());
    }
}
