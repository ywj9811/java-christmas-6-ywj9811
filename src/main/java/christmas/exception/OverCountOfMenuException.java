package christmas.exception;

import static christmas.exception.constant.ExceptionMessage.OVER_MENU;

public class OverCountOfMenuException extends IllegalArgumentException {
    public OverCountOfMenuException() {
        super(OVER_MENU.getMessage());
    }
}
