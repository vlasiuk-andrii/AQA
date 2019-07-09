package test.ui.pages;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import main.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;
import test.ui.fragments.AgileProjectMenuFragment;
import test.ui.fragments.AgileProjectTableFragment;

@Getter
public class AgileProjectPage extends BasePage {

    protected AgileProjectMenuFragment agileProjectMenuFragment = new AgileProjectMenuFragment();
    protected AgileProjectTableFragment agileProjectTableFragment = new AgileProjectTableFragment();

    @FindBy(css = "input[name='uid']")
    private SelenideElement userInputE;
    @FindBy(css = "input[name='password']")
    private SelenideElement passwordInputE;
    @FindBy(css = "input[name='btnLogin']")
    private SelenideElement logInButtonE;
    @FindBy(css = "ul[class='menusubnav']")
    private SelenideElement customerMenuE;
    @FindBy(css = "marquee")
    private SelenideElement welcomeMessageE;

//    protected By userInput = By.cssSelector("input[name='uid']");
//    protected By passwordInput = By.cssSelector("input[name='password']");
//    protected By logInButton = By.cssSelector("input[name='btnLogin']");
//    protected By customerMenu = By.cssSelector("ul[class='menusubnav']");
//    protected By welcomeMessage = By.cssSelector("marquee");

    public AgileProjectPage() {
        url = getExpectedPageUrl(PagePaths.AGILE_PROJECT_PAGE.getValue());
        title = PageTitles.AGILE_PROJECT_PAGE.getValue();;
    }

    public AgileProjectMenuFragment getAgileProjectMenuFragment() {
        return agileProjectMenuFragment;
    }

    public AgileProjectTableFragment getAgileProjectTableFragment() {
        return agileProjectTableFragment;
    }
}
