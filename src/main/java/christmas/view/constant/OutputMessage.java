package christmas.view.constant;

public enum OutputMessage {
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PRE_BENEFITS("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDERS("\n<주문 메뉴>"),
    TOTAL_PRICE_BEFORE("\n<할인 전 총주문 금액>"),
    PRESENTATION_MENU("\n<증정 메뉴>"),
    BENEFITS("\n<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("\n<총혜택 금액>"),
    TOTAL_PRICE_AFTER("\n<할인 후 예상 결제 금액>"),
    EVENT_BADGE("\n<12월 이벤트 배지>")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
