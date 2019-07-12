package test.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import main.base.BasePage;
import main.core.annotation.Parameters;
import org.openqa.selenium.support.FindBy;
import test.ui.fragments.MainMenuFragment;

@Getter
@Parameters(title = "Welcome: Mercury Tours",
            url = "/test/newtours/")
public class NewToursPage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "body>div>table")
    private SelenideElement mainFragment;

    public NewToursPage(){
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }
}
