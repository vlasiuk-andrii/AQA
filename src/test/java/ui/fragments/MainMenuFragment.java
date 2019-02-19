package ui.fragments;

import fragments.BasicFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class MainMenuFragment extends BasicFragment {

    @FindBy(css = "div#navbar-brand-centered")
    private WebElement rootElement;

    By newTourButton = By.cssSelector("a[href*='newtours']");

    public MainMenuFragment(WebDriver driver) {
        super(driver);
        super.rootElement = rootElement;
    }


    public void clickOnNewTours(){
        rootElement.findElement(newTourButton).click();
    }
}
