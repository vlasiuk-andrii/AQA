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
public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "body>div>table")
    private SelenideElement mainFragmentE;

//    protected By mainFragment = By.cssSelector("body>div>table");

    public NewToursPage(){
        url = getExpectedPageUrl(PagePaths.NEW_TOURS_PAGE.getValue());
        title = PageTitles.NEW_TOURS_PAGE.getValue();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }
}
