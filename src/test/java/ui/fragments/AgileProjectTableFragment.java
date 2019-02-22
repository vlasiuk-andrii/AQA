package ui.fragments;

import fragments.BaseFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgileProjectTableFragment extends BaseFragment {

    @FindBy(css = "table.layout1")
    private WebElement rootElement;

    public AgileProjectTableFragment(WebDriver driver) {
        super(driver);
        super.rootElement = rootElement;
    }
}
