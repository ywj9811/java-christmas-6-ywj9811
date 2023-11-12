package christmas.exception;

import christmas.exception.constant.ExceptionMessage;

import static christmas.exception.constant.ExceptionMessage.INVALID_TYPE;

public class InvalidTypeException extends IllegalArgumentException{
    public InvalidTypeException() {
        super(INVALID_TYPE.getMessage());
    }
}
