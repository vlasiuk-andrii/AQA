package test.ui.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.ui.pages.DragAndDropPage;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropFlow extends DragAndDropPage {

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

}