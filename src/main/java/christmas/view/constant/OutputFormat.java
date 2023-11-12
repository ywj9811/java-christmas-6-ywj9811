package christmas.view.constant;

import java.text.DecimalFormat;

public class OutputFormat {
    private final static DecimalFormat PRINT_FORMAT = new DecimalFormat("#,##0");

    public static String minusFormatter(int price) {
        String format = PRINT_FORMAT.format(price);
        return ("-" + format + "원\n");
    }

    public static String priceFormatter(int price) {
        String format = PRINT_FORMAT.format(price);
        return (format + "원");
    }

    public static String benefitFormatter(int price) {
        String format = PRINT_FORMAT.format(price);
        if (price > 0)
            return ("-" + format + "원");
        return (format + "원");
    }
}
