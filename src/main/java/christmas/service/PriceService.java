package christmas.service;

import christmas.domain.OrderMenus;

public class PriceService {
    private final OrderMenus menus;
    public PriceService(OrderMenus menus) {
        this.menus = menus;
    }

    public int getTotalPriceBefore() {
        int totalPriceBefore = menus.getTotalPriceBefore();
        return totalPriceBefore;
    }


    public int getTotalPriceAfter(int totalBenefit, int presentationBenefit) {
        return menus.getTotalPriceBefore() - totalBenefit + presentationBenefit;
    }
}


