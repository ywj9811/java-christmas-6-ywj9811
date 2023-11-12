package christmas.view;


import christmas.domain.Menu;

import java.util.List;

import static christmas.view.constant.OutputMessage.*;

public class OutputView {
    public void greeting() {
        System.out.println(GREETING.getMessage());
    }

    public void preBenefit(int date) {
        System.out.println("12월 " + date + PRE_BENEFITS.getMessage());
    }

    public void orderMenus(List<Menu> menus) {
        System.out.println(ORDERS.getMessage());
        for (Menu menu : menus) {
            System.out.println(menu.getName() + " " + menu.getAmount()+ "개");
        }
    }

    public void totalPriceBefore(String price) {
        System.out.println(TOTAL_PRICE_BEFORE.getMessage());
        System.out.println(price + "원");
    }

    public void presentationMenu(int presentation) {
        System.out.println(PRESENTATION_MENU.getMessage());
        if (presentation > 0) {
            System.out.println(PRESENTATION_MENU_AMOUNT.getMessage());
            return;
        }
        System.out.println(NONE.getMessage());
    }

    public void benefitHistory(String history) {
        System.out.println(BENEFITS.getMessage());
        System.out.println(history);
    }
}
