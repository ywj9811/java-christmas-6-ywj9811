package christmas.view.constant;

import christmas.domain.Menu;

import java.text.DecimalFormat;

import static christmas.domain.constant.Benefit.*;
import static christmas.domain.constant.Benefit.PRESENTATION;
import static christmas.view.constant.OutputMessage.*;
import static christmas.view.constant.Print.*;

public class OutputFormat {
    private final static DecimalFormat PRINT_FORMAT = new DecimalFormat("#,##0");
    public static String minusFormatter(int price) {
        String format = PRINT_FORMAT.format(price);
        return (DASH.getMessage() + format + WON.getMessage() + "\n");
    }

    public static String priceFormatter(int price) {
        String format = PRINT_FORMAT.format(price);
        return (format + WON.getMessage());
    }

    public static String benefitFormatter(int price) {
        String format = PRINT_FORMAT.format(price);
        if (price > 0)
            return (DASH.getMessage() + format + WON.getMessage());
        return (format + WON.getMessage());
    }

    public static String preBenefitFormatter(int date) {
        return (MONTH.getMessage() + date + PRE_BENEFITS.getMessage());
    }

    public static String orderMenusFormatter(Menu menu) {
        return (menu.getName() + SPACING + menu.getAmount()+ UNIT);
    }

    public static String benefitHistoryFormatter(int[] benefits) {
        StringBuilder sb = new StringBuilder();
        if (benefits[D_DAY.getColumn()] > 0)
            sb.append(CHRISTMAS_BENEFIT.getMessage() + minusFormatter(benefits[D_DAY.getColumn()]));
        if (benefits[WEEKDAY.getColumn()] > 0)
            sb.append(WEEKDAY_BENEFIT.getMessage() + minusFormatter(benefits[WEEKDAY.getColumn()]));
        if (benefits[WEEKEND.getColumn()] > 0)
            sb.append(WEEKEND_BENEFIT.getMessage() + minusFormatter(benefits[WEEKEND.getColumn()]));
        if (benefits[STAR_DAY.getColumn()] > 0)
            sb.append(STAR_BENEFIT.getMessage() + minusFormatter(benefits[STAR_DAY.getColumn()]));
        if (benefits[PRESENTATION.getColumn()] > 0)
            sb.append(PRESENTATION_BENEFIT.getMessage() + minusFormatter(benefits[PRESENTATION.getColumn()]));
        if (sb.isEmpty())
            sb.append(NONE.getMessage());
        return sb.toString();
    }
}
