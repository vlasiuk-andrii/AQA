package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import properties.PropertiesHolder;

public class DragAndDropPage extends BasePage {

    @FindBy(css = "div.platform-content")
    private WebElement dragAndDropForm;

    By debitAccountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li");
    By debitAmountDropField = By.xpath("//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li");
    By creditAccountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li");
    By creditAmountDropField = By.xpath("//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li");
    By resultTable = By.cssSelector("div.table4_result");

    private Actions action = new Actions(driver);

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        url = PropertiesHolder.getProperty("baseUrl")  + "/test/drag_drop.html";
    }

    public void navigate(){
        driver.get(url);
    }

    public boolean isDragAndDropFormDisplayed(){
        return dragAndDropForm.isDisplayed();
    }

    public void putDebitAccount(String account) {
        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = dragAndDropForm.findElement(debitAccountDropField);
        action.dragAndDrop(from, to).build().perform();
    }

    public void putDebitAmount(String amount) {
        WebElement from = dragAndDropForm.findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = dragAndDropForm.findElement(debitAmountDropField);
        action.dragAndDrop(from, to).build().perform();
    }

    public void putCreditAccount(String account) {
        WebElement from = dragAndDropForm.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = dragAndDropForm.findElement(creditAccountDropField);
        action.dragAndDrop(from, to).build().perform();
    }

    public void putCreditAmount(String amount) {
        WebElement from = dragAndDropForm.findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = dragAndDropForm.findElement(creditAmountDropField);
        action.dragAndDrop(from, to).build().perform();
    }

    public boolean successMessageIsShown() {
        waitABit(100);
        return dragAndDropForm.findElement(resultTable).isDisplayed();
    }
}