package test.ui.pages;

import main.base.BasePage;
import org.openqa.selenium.By;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.flow.MainMenuFlow;

public class HomePage extends BasePage {

    private MainMenuFlow mainMenuFlow = new MainMenuFlow();

    protected By loginForm = By.cssSelector("form[name='frmLogin']");

    public HomePage(){
        url = getExpectedPageUrl(PagePaths.HOME_PAGE.getValue());
        title = PageTitles.HOME_PAGE.getValue();
    }

    public MainMenuFlow getMainMenuFlow(){
        return mainMenuFlow;
    }
}
