package christmas.exception;

import christmas.exception.constant.ExceptionMessage;

import static christmas.exception.constant.ExceptionMessage.OUT_OF_RANGE;

public class OutOfRangeException extends IllegalArgumentException{
    public OutOfRangeException() {
        super(OUT_OF_RANGE.getMessage());
    }
}
