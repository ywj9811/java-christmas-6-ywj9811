package christmas.domain.constant;

public enum Benefit {
    D_DAY(0),
    WEEKDAY(1),
    WEEKEND(2),
    STAR_DAY(3),
    PRESENTATION(4);

    private final int column;

    Benefit(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }
}
