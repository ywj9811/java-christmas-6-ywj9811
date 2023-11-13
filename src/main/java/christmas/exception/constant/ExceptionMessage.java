package christmas.exception.constant;

public enum ExceptionMessage {
    OUT_OF_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_TYPE("[ERROR] 입력값의 타입이 잘못되었습니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 존재하지 않는 메뉴입니다. 다시 입력해 주세요."),
    INVALID_FORMAT("[ERROR] 입력 형식이 잘못되었습니다. 다시 입력해 주세요."),
    DUPLICATED_MENU("[ERROR] 중복된 메뉴가 입력되었습니다. 다시 입력해 주세요.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
