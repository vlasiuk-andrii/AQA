package test.ui.flow;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import main.base.BasePage;
import main.core.annotation.Parameters;
import main.driver.CustomAppiumDriverManager;
import main.driver.CustomWebDriverManager;
import main.properties.PropertiesHolder;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class BaseFlow {

    private Actions actionSelenium;
    private TouchAction actionAppium;
    private String baseUrl = PropertiesHolder.getProperty("base.url");

    protected Integer defaultTimeoutSeconds = new Integer(PropertiesHolder.getProperty("explicit.dom.timeout"));

    protected void dragAndDrop(WebElement from, WebElement to) {
        if (CustomWebDriverManager.getWebDriver() != null) {
            actionSelenium.dragAndDrop(from, to).build().perform();
        } else if (CustomAppiumDriverManager.getAppiumDriver() != null) {
            actionAppium.longPress(PointOption.point(from.getLocation().getX(), from.getLocation().getY()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(to.getLocation().getX(), to.getLocation().getY()))
                    .perform()
                    .release();
        }
    }

    public void navigate(Class<? extends BasePage> page) {
        URL url = null;
        try {
            url = new URL(baseUrl + page.getAnnotation(Parameters.class).url());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (CustomWebDriverManager.getWebDriver() != null) {
            open(url);
        } else if (CustomAppiumDriverManager.getAppiumDriver() != null) {
            CustomAppiumDriverManager.getAppiumDriver().get(url.toString());
        } else throw new WebDriverException("Can't navigate URL. All drivers are null");
    }

    public String getExpectedTitle(Class<? extends BasePage> page){
        return page.getAnnotation(Parameters.class).title();
    }

    public String getExpectedUrl(Class<? extends BasePage> page){
        return baseUrl + page.getAnnotation(Parameters.class).url();
    }
}
