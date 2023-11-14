package christmas.domain.constant;

public enum Number {
    MIN_DATE(1),
    MAX_DATE(31),
    CHRISTMAS(25),
    MIN_PRICE(10000),
    BENEFIT_DATE_START(1000),
    BENEFIT_DATE_UNIT(100),
    BENEFIT_PRICE_UNIT(2023),
    MIN_PRESENTATION_PRICE(120000),
    PRESENTATION_PRICE(25000),
    PRESENTATION_MAX(20000),
    PRESENTATION_MED(10000),
    PRESENTATION_MIN(5000)
    ;

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
