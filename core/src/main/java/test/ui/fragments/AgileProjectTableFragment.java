package test.ui.fragments;

import main.base.BaseFragment;
import org.openqa.selenium.By;

public class AgileProjectTableFragment extends BaseFragment {

    private By rootElement = By.cssSelector("table.layout1");

    public AgileProjectTableFragment() {
        super.rootElement = rootElement;
    }
}
