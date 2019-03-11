package ui.fragments;

import fragments.BaseFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgileProjectMenuFragment extends BaseFragment {

    @FindBy(css = "ul.menusubnav")
    private WebElement rootElement;

    By customerButton = By.cssSelector("a[href*='Customerhomepage']");
    By miniStatementButton = By.cssSelector("a[href*='MiniStatement']");

    public AgileProjectMenuFragment() {
        super.rootElement = rootElement;
    }

}
