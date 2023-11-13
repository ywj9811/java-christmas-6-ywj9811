package christmas.exception;

import static christmas.exception.constant.ExceptionMessage.INVALID_MENU;

public class InvalidMenuException extends IllegalArgumentException{
    public InvalidMenuException() {
        super(INVALID_MENU.getMessage());
    }
}
