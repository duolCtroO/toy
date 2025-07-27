package oort.cloud.document.importer;

public enum Attributes {
    PATH("path"),
    WIDTH("width"),
    HEIGHT("height"),
    TYPE("type"),
    PATIENT("patient"),
    AMOUNT("amount"),
    ADDRESS("address"),
    BODY("body"),

    ;
    private final String value;
    Attributes(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
