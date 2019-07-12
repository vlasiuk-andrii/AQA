package test.ui.flow;

import test.ui.pages.TablePage;

import static com.codeborne.selenide.Selenide.page;

public class TableFlow extends BaseFlow {

    TablePage tablePage = new TablePage();

    public boolean isTablePresent(){
        return page(TablePage.class).getTableE().isDisplayed();
    }

    public TablePage getTablePage() {
        return tablePage;
    }
}
