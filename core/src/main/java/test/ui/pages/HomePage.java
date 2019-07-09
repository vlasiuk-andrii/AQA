package test.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import main.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.fragments.MainMenuFragment;

@Getter
public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "form[name='frmLogin']")
    private SelenideElement loginFormE;

//    protected By loginForm = By.cssSelector("form[name='frmLogin']");

    public HomePage(){
        url = getExpectedPageUrl(PagePaths.HOME_PAGE.getValue());
        title = PageTitles.HOME_PAGE.getValue();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }
}
