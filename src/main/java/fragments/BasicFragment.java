package fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasicPage;

public abstract class BasicFragment extends BasicPage {

    protected WebDriver driver;
    protected WebElement rootElement;

    public BasicFragment(WebDriver driver) {
        super(driver);
    }
}
