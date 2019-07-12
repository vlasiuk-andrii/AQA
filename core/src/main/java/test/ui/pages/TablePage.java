package test.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import main.base.BasePage;
import main.core.annotation.Parameters;
import org.openqa.selenium.support.FindBy;
import test.ui.fragments.MainMenuFragment;

@Getter
@Parameters(title = "Table Demo",
            url = "/test/table.html")
public class TablePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "table>tbody")
    private SelenideElement tableE;

    public TablePage(){
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }
}