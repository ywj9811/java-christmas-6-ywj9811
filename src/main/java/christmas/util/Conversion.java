package christmas.util;

import christmas.exception.InvalidFormatException;
import christmas.exception.InvalidTypeException;
import christmas.exception.OutOfRangeException;

import static christmas.domain.constant.Number.MAX_DATE;
import static christmas.domain.constant.Number.MIN_DATE;

public class Conversion {
    public static int conversionAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new InvalidFormatException();
        }
    }

    public static int conversionDate(String input) {
        try {
            int date = Integer.parseInt(input);
            if (date < MIN_DATE.getNumber() || date > MAX_DATE.getNumber())
                throw new OutOfRangeException();
            return date;
        } catch (OutOfRangeException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidTypeException();
        }
    }
}
