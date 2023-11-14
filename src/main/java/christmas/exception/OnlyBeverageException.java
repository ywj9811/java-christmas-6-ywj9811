package christmas.exception;

import static christmas.exception.constant.ExceptionMessage.ONLY_BEVERAGE;

public class OnlyBeverageException extends IllegalArgumentException{
    public OnlyBeverageException() {
        super(ONLY_BEVERAGE.getMessage());
    }
}
