package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected String url;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate(){
        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUrl(){
        return url;
    }

}
