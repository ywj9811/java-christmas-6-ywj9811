package christmas.view.constant;

import java.text.DecimalFormat;

public class OutputFormat {
    private final static DecimalFormat PRINT_FORMAT = new DecimalFormat("#,##0");

    public static String formatter(int price) {
        return PRINT_FORMAT.format(price);
    }
}
