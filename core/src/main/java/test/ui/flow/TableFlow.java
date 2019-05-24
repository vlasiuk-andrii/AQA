package test.ui.flow;

import test.ui.pages.TablePage;

import static com.codeborne.selenide.Selenide.$;

public class TableFlow extends TablePage {

    public boolean isTablePresent(){
        return $(table).isDisplayed();
    }
}
