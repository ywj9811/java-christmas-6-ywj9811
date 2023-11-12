package christmas.view.constant;

public enum OutputMessage {
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PRE_BENEFITS("일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDERS("\n<주문 메뉴>"),
    TOTAL_PRICE_BEFORE("\n<할인 전 총주문 금액>"),
    PRESENTATION_MENU("\n<증정 메뉴>"),
    PRESENTATION_MENU_AMOUNT("샴페인 1개"),
    CHRISTMAS_BENEFIT("크리스마스 디데이 할인: "),
    WEEKEND_BENEFIT("주말 할인: "),
    WEEKDAY_BENEFIT("평일 할인: "),
    STAR_BENEFIT("특별 할인: "),
    PRESENTATION_BENEFIT("증정 이벤트: "),
    BENEFITS("\n<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    TOTAL_PRICE_AFTER("\n<할인 후 예상 결제 금액>"),
    EVENT_BADGE("\n<12월 이벤트 배지>"),
    NONE("없음")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
