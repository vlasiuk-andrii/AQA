package test.ui.enums;

public enum PageTitles {
    HOME_PAGE("Guru99 Bank Home Page"),
    NEW_TOURS_PAGE("Welcome: Mercury Tours"),
    TABLE_PAGE("Table Demo"),
    AGILE_PROJECT_PAGE(" Guru99 Bank Home Page "),
    DRAG_AND_DROP_PAGE("Drag and Drop Action");

    private String value;

    PageTitles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
