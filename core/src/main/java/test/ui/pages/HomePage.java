package test.ui.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import main.base.BasePage;
import main.core.annotation.Parameters;
import org.openqa.selenium.support.FindBy;
import test.ui.fragments.MainMenuFragment;

@Getter
@Parameters(title = "Guru99 Bank Home Page",
            url = "/")
public class HomePage extends BasePage {

    private MainMenuFragment mainMenuFragment = new MainMenuFragment();

    @FindBy(css = "form[name='frmLogin']")
    private SelenideElement loginFormE;

    public HomePage(){
    }

    public MainMenuFragment getMainMenuFragment(){
        return mainMenuFragment;
    }
}
