package christmas.util;

import christmas.exception.InvalidFormatException;
import christmas.exception.InvalidTypeException;
import christmas.exception.OutOfRangeException;

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
            if (date < 1 || date > 31)
                throw new OutOfRangeException();
            return date;
        } catch (OutOfRangeException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidTypeException();
        }
    }
}
