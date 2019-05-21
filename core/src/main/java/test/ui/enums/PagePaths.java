package test.ui.enums;

public enum PagePaths {
    HOME_PAGE("/"),
    NEW_TOURS_PAGE("/test/newtours/"),
    TABLE_PAGE("/test/table.html"),
    AGILE_PROJECT_PAGE("/Agile_Project/Agi_V1/"),
    DRAG_AND_DROP_PAGE("/test/drag_drop.html");

    private String value;

    PagePaths(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
