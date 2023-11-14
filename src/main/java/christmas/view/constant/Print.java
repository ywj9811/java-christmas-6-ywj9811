package christmas.view.constant;

public enum Print {
    DASH("-"),
    WON("원"),
    MONTH("12월 "),
    SPACING(" "),
    UNIT("개");

    private final String message;

    Print(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
