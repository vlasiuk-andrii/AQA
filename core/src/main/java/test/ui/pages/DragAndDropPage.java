package test.ui.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import main.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;

import java.time.Duration;

public class DragAndDropPage extends BasePage {

    protected By debitAccountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li");
    protected By debitAmountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li");
    protected By creditAccountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li");
    protected By creditAmountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li");
    protected By resultTable = By.cssSelector("div.table4_result");
    protected By dragAndDropForm = By.cssSelector("div.platform-content");

    private Actions actionSelenium;
    private TouchAction actionAppium;

    public DragAndDropPage() {
        url = getExpectedPageUrl(PagePaths.DRAG_AND_DROP_PAGE.getValue());
        title = PageTitles.DRAG_AND_DROP_PAGE.getValue();
        if (webDriver != null) {
            actionSelenium = new Actions(webDriver);
        } else if (appiumDriver != null) {
            actionAppium = new TouchAction(appiumDriver);
        }
    }

    protected void dragAndDrop(WebElement from, WebElement to) {
        if (webDriver != null) {
            actionSelenium.dragAndDrop(from, to).build().perform();
        } else if (appiumDriver != null) {
            actionAppium.longPress(PointOption.point(from.getLocation().getX(), from.getLocation().getY()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(to.getLocation().getX(), to.getLocation().getY()))
                    .perform()
                    .release();
        }
    }
}