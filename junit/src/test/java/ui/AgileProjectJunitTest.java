package ui;

import org.junit.jupiter.api.Test;
import test.ui.flow.AgileProjectFlow;
import test.ui.pages.AgileProjectPage;

import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgileProjectJunitTest extends BaseUiJunitTest {

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
