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
public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "table>tbody")
    private SelenideElement tableE;

//    protected By table = By.cssSelector("table>tbody");

    public TablePage(){
        url = getExpectedPageUrl(PagePaths.TABLE_PAGE.getValue());
        title = PageTitles.TABLE_PAGE.getValue();
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }

}
