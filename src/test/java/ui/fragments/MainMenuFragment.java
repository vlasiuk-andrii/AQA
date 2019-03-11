package ui.fragments;

import fragments.BaseFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuFragment extends BaseFragment {

    @FindBy(css = "div#navbar-brand-centered")
    private WebElement rootElement;

    By newTourButton = By.cssSelector("a[href*='newtours']");
    By seleniumDropDown = By.cssSelector("a.dropdown-toggle");
    By tableDemoLink = By.cssSelector("a[href*='table']");

    public MainMenuFragment() {
        super.rootElement = rootElement;
    }


    public void clickOnNewToursButton(){
        rootElement.findElement(newTourButton).click();
    }

    public void clickOnSeleniumDropDown(){
        rootElement.findElement(seleniumDropDown).click();
    }

    public void clickOnTableDemoLink(){
        rootElement.findElement(tableDemoLink).click();
    }
}
