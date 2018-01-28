package enums;

public enum ServiceMenuTextsEnum {

    TEXT_1("SUPPORT"),
    TEXT_2("DATES"),
    TEXT_3("COMPLEX TABLE"),
    TEXT_4("SIMPLE TABLE"),
    TEXT_5("TABLE WITH PAGES"),
    TEXT_6("DIFFERENT ELEMENTS");

    public String text;

    ServiceMenuTextsEnum(String text) {
        this.text = text;
    }
}
