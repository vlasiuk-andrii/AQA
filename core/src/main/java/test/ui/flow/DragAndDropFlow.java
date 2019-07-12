package test.ui.flow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.ui.pages.DragAndDropPage;

import static com.codeborne.selenide.Selenide.page;

public class DragAndDropFlow extends BaseFlow {

    public boolean isDragAndDropFormDisplayed() {
        return page(DragAndDropPage.class).getDragAndDropForm().isDisplayed();
//        return $(dragAndDropForm).isDisplayed();
    }

    public void putDebitAccount(String account) {
        WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = page(DragAndDropPage.class).getDebitAccountDropField();
//        WebElement from = $(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
//        WebElement to = $(dragAndDropForm).findElement(debitAccountDropField);
        dragAndDrop(from, to);
    }

    public void putDebitAmount(String amount) {
        WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = page(DragAndDropPage.class).getDebitAmountDropField();
//        WebElement from = $(dragAndDropForm).findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
//        WebElement to = $(dragAndDropForm).findElement(debitAmountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAccount(String account) {
        WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
        WebElement to = page(DragAndDropPage.class).getCreditAccountDropField();
//        WebElement from = $(dragAndDropForm).findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
//        WebElement to = $(dragAndDropForm).findElement(creditAccountDropField);
        dragAndDrop(from, to);
    }

    public void putCreditAmount(String amount) {
        WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
        WebElement to = page(DragAndDropPage.class).getCreditAmountDropField();
//        WebElement from = $(dragAndDropForm).findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
//        WebElement to = $(dragAndDropForm).findElement(creditAmountDropField);
        dragAndDrop(from, to);
    }

    public boolean successMessageIsShown() {
        return page(DragAndDropPage.class).getResultTable().isDisplayed();
//        return $(dragAndDropForm).findElement(resultTable).isDisplayed();
    }

}