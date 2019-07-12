package test.ui.pages;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import main.base.BasePage;
import main.core.annotation.Parameters;
import org.openqa.selenium.support.FindBy;
import test.ui.fragments.AgileProjectMenuFragment;
import test.ui.fragments.AgileProjectTableFragment;

@Getter
@Parameters(title = " Guru99 Bank Home Page ",
            url = "/Agile_Project/Agi_V1/")
public class AgileProjectPage extends BasePage {

    protected AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment();
    protected AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment();

    @FindBy(css = "input[name='uid']")
    private SelenideElement userInput;
    @FindBy(css = "input[name='password']")
    private SelenideElement passwordInput;
    @FindBy(css = "input[name='btnLogin']")
    private SelenideElement logInButton;
    @FindBy(css = "ul.menusubnav")
    private SelenideElement customerMenu;
    @FindBy(css = "marquee")
    private SelenideElement welcomeMessage;

    public AgileProjectPage() {
    }

    public AgileProjectMenuFragment getAgileProjectMenuFragment() {
        return agileProjectMenuFragment;
    }

    public AgileProjectTableFragment getAgileProjectTableFragment() {
        return agileProjectTableFragment;
    }
}
