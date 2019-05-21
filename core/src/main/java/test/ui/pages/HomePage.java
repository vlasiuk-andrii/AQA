package test.ui.pages;

import main.base.BasePage;
import org.openqa.selenium.By;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.fragments.MainMenuFragment;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    private By loginForm = By.cssSelector("form[name='frmLogin']");

    public HomePage(){
        url = getExpectedPageUrl(PagePaths.HOME_PAGE.getValue());
        title = PageTitles.HOME_PAGE.getValue();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

    public boolean isLoginFormPresent(){
        return $(loginForm).isDisplayed();
    }
}
