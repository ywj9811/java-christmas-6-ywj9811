package christmas.service;

import christmas.domain.Menu;

import java.util.List;

public class PriceService {
    private final List<Menu> menus;
    public PriceService(List<Menu> menus) {
        this.menus = menus;
    }

    public int getTotalPriceBefore() {
        int totalPrice = 0;
        for (Menu menu : menus) {
            totalPrice += menu.getTotalPrice();
        }
        return totalPrice;
    }


    public int getTotalPriceAfter(int totalPrice, int totalBenefit, int presentationBenefit) {
        return totalPrice - totalBenefit + presentationBenefit;
    }
}


