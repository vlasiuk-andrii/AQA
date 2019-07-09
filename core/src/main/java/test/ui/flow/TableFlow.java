package test.ui.flow;

import test.ui.pages.TablePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TableFlow extends TablePage {

    public boolean isTablePresent(){
        return page(TablePage.class).getTableE().isDisplayed();
//        return $(table).isDisplayed();
    }
}
