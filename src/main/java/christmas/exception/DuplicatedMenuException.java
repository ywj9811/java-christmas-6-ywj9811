package christmas.exception;

import static christmas.exception.constant.ExceptionMessage.DUPLICATED_MENU;

public class DuplicatedMenuException extends IllegalArgumentException{
    public DuplicatedMenuException() {
        super(DUPLICATED_MENU.getMessage());
    }
}
