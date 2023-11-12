package christmas.view;


import christmas.domain.Menu;

import java.text.DecimalFormat;
import java.util.List;

import static christmas.view.constant.OutputMessage.*;

public class OutputView {
    private final static DecimalFormat PRINT_FORMAT = new DecimalFormat("#,##0");
    public void greeting() {
        System.out.println(GREETING.getMessage());
    }

    public void orderMenus(List<Menu> menus) {
        System.out.println(ORDERS);
        for (Menu menu : menus) {
            System.out.println(menu.getName() + " " + menu.getAmount()+"개");
        }
    }

    public void totalPriceBefore(int price) {
        System.out.println(TOTAL_PRICE_BEFORE);
        System.out.println(PRINT_FORMAT.format(price));
    }
}
