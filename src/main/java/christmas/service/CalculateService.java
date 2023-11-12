package christmas.service;

import christmas.domain.Menu;

import java.util.List;

public class CalculateService {
    private final List<Menu> menus;
    private final int date;

    public CalculateService(List<Menu> menus, int date) {
        this.menus = menus;
        this.date = date;
    }

    public int getTotalPriceBefore() {
        int totalPrice = 0;
        for (Menu menu : menus) {
            totalPrice += menu.getTotalPrice();
        }
        return totalPrice;
    }
}
