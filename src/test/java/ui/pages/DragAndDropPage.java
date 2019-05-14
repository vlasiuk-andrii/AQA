package ui.pages;

import base.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import properties.PropertiesHolder;
import ui.enums.PagePaths;
import ui.enums.PageTitles;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropPage extends BasePage {

    private By debitAccountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li");
    private By debitAmountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li");
    private By creditAccountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li");
    private By creditAmountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li");
    private By resultTable = By.cssSelector("div.table4_result");
    private By dragAndDropForm = By.cssSelector("div.platform-content");

    private Actions actionSelenium;
    private TouchAction actionAppium;

    public DragAndDropPage() {
        url = getDragAndDropPageUrl();
        title = getDragAndDropPageTitle();
        if (webDriver != null) {
            actionSelenium = new Actions(webDriver);
        } else if (appiumDriver != null) {
            actionAppium = new TouchAction(appiumDriver);
        }
    }

    public boolean isDragAndDropFormDisplayed() {
        return $(dragAndDropForm).isDisplayed();
    }

    public void putDebitAccount(String account) {
        WebElement from = $(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = $(dragAndDropForm).findElement(debitAccountDropField);
        dragAndDrop(from, to);
    }

    public void putDebitAmount(String amount) {
        WebElement from = $(dragAndDropForm).findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = $(dragAndDropForm).findElement(debitAmountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAccount(String account) {
        WebElement from = $(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = $(dragAndDropForm).findElement(creditAccountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAmount(String amount) {
        WebElement from = $(dragAndDropForm).findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = $(dragAndDropForm).findElement(creditAmountDropField);
        dragAndDrop(from, to);
    }

    public boolean successMessageIsShown() {
        return $(dragAndDropForm).findElement(resultTable).isDisplayed();
    }

    private void dragAndDrop(WebElement from, WebElement to) {
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

    private URL getDragAndDropPageUrl() {
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url") + PagePaths.DRAG_AND_DROP_PAGE.getValue());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private String getDragAndDropPageTitle(){
        return PageTitles.DRAG_AND_DROP_PAGE.getValue();
    }
}