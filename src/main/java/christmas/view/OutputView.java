package christmas.view;


import christmas.domain.Menu;
import christmas.domain.OrderMenus;

import static christmas.view.constant.OutputMessage.*;

public class OutputView {
    public void greeting() {
        System.out.println(GREETING.getMessage());
    }

    public void preBenefit(int date) {
        System.out.println("12월 " + date + PRE_BENEFITS.getMessage());
    }

    public void orderMenus(OrderMenus menus) {
        System.out.println(ORDERS.getMessage());
        for (Menu menu : menus.getMenus()) {
            System.out.println(menu.getName() + " " + menu.getAmount()+ "개");
        }
    }

    public void totalPriceBefore(String price) {
        System.out.println(TOTAL_PRICE_BEFORE.getMessage());
        System.out.println(price);
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

    public void totalBenefit(String totalBenefit) {
        System.out.println(TOTAL_BENEFIT_PRICE.getMessage());
        System.out.println(totalBenefit);
    }

    public void totalPriceAfter(String price) {
        System.out.println(TOTAL_PRICE_AFTER.getMessage());
        System.out.println(price);
    }

    public void badge(String badge) {
        System.out.println(EVENT_BADGE.getMessage());
        System.out.println(badge);
    }
}
