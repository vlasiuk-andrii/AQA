package ui.enums;

public enum Titles {
    HOME_PAGE("Guru99 Bank Home Page"),
    NEW_TOURS_PAGE("Welcome: Mercury Tours"),
    TABLE_PAGE("Table Demo");

    private String value;

    Titles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
