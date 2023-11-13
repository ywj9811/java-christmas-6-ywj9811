package christmas.service;

import christmas.domain.OrderMenus;

public class PriceService {
    private final OrderMenus menus;
    private static PriceService instance;

    private PriceService(OrderMenus menus) {
        this.menus = menus;
    }

    public static PriceService getInstance(OrderMenus menus) {
        if (instance == null)
            return new PriceService(menus);
        return instance;
    }

    public int getTotalPriceBefore() {
        int totalPriceBefore = menus.getTotalPriceBefore();
        return totalPriceBefore;
    }


    public int getTotalPriceAfter(int totalBenefit, int presentationBenefit) {
        return menus.getTotalPriceBefore() - totalBenefit + presentationBenefit;
    }
}


