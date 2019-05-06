package ui.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import base.BasePage;
import properties.PropertiesHolder;
import driver.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DragAndDropPage extends BasePage {

    @FindBy(css = "div.platform-content")
    private WebElement dragAndDropForm;

    By debitAccountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li");
    By debitAmountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li");
    By creditAccountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li");
    By creditAmountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li");
    By resultTable = By.cssSelector("div.table4_result");

    private Actions actionSelenium;
    private TouchAction actionAppium;

    public DragAndDropPage() {
        url = getDragAndDropPageUrl();
        if (webDriver != null) {
            actionSelenium = new Actions(webDriver);
        } else if (appiumDriver != null) {
            actionAppium = new TouchAction(appiumDriver);
        }
    }

    public boolean isDragAndDropFormDisplayed() {
        return dragAndDropForm.isDisplayed();
    }

    public void putDebitAccount(String account) {
        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = dragAndDropForm.findElement(debitAccountDropField);
        dragAndDrop(from, to);
    }

    public void putDebitAmount(String amount) {
        WebElement from = dragAndDropForm.findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = dragAndDropForm.findElement(debitAmountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAccount(String account) {
        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = dragAndDropForm.findElement(creditAccountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAmount(String amount) {
        WebElement from = dragAndDropForm.findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = dragAndDropForm.findElement(creditAmountDropField);
        dragAndDrop(from, to);
    }

    public boolean successMessageIsShown() {
        WebDriverManager.waitABit(100);
        return dragAndDropForm.findElement(resultTable).isDisplayed();
    }

    private URL getDragAndDropPageUrl() {
        URL url = null;
        try {
            url = new URL(PropertiesHolder.getProperty("base.url") + "/test/drag_drop.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
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
}