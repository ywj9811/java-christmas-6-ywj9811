package christmas.exception;

import static christmas.exception.constant.ExceptionMessage.INVALID_FORMAT;

public class InvalidFormatException extends IllegalArgumentException{
    public InvalidFormatException() {
        super(INVALID_FORMAT.getMessage());
    }
}
