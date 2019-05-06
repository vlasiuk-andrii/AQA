package ui.fragments;

import base.BaseFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgileProjectTableFragment extends BaseFragment {

    @FindBy(css = "table.layout1")
    private WebElement rootElement;

    public AgileProjectTableFragment() {
        super.rootElement = rootElement;
    }
}
