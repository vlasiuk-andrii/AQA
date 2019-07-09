package test.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.Getter;
import main.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import test.ui.enums.PagePaths;
import test.ui.enums.PageTitles;

import java.time.Duration;

@Getter
public class DragAndDropPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li")
    private SelenideElement debitAccountDropField;
    @FindBy(xpath = "//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li")
    private SelenideElement debitAmountDropField;
    @FindBy(xpath = "//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li")
    private SelenideElement creditAccountDropField;
    @FindBy(xpath = "//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li")
    private SelenideElement creditAmountDropField;
    @FindBy(css = "div.table4_result")
    private SelenideElement resultTable;
    @FindBy(css = "div.platform-content")
    private SelenideElement dragAndDropForm;

//    protected By debitAccountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li");
//    protected By debitAmountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li");
//    protected By creditAccountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li");
//    protected By creditAmountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li");
//    protected By resultTable = By.cssSelector("div.table4_result");
//    protected By dragAndDropForm = By.cssSelector("div.platform-content");

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
}