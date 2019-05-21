package test.ui.fragments;

import main.base.BaseFragment;
import org.openqa.selenium.By;

public class AgileProjectMenuFragment extends BaseFragment {

    private By rootElement = By.cssSelector("ul.menusubnav");
    private By customerButton = By.cssSelector("a[href*='Customerhomepage']");
    private By miniStatementButton = By.cssSelector("a[href*='MiniStatement']");

    public AgileProjectMenuFragment() {
        super.rootElement = rootElement;
    }

}
