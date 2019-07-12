package test.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.TouchAction;
import lombok.Getter;
import main.base.BasePage;
import main.core.annotation.Parameters;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Getter
@Parameters(title = "Drag and Drop Action",
        url = "/test/drag_drop.html")
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

    private Actions actionSelenium;
    private TouchAction actionAppium;

    public DragAndDropPage() {
        if (webDriver != null) {
            actionSelenium = new Actions(webDriver);
        } else if (appiumDriver != null) {
            actionAppium = new TouchAction(appiumDriver);
        }
    }
}