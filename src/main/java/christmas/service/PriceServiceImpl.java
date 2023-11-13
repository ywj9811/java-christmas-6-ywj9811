package christmas.service;

import christmas.domain.OrderMenus;

public class PriceServiceImpl implements PriceService{
    private final OrderMenus menus;
    private static PriceServiceImpl instance;

    private PriceServiceImpl(OrderMenus menus) {
        this.menus = menus;
    }

    public static PriceServiceImpl getInstance(OrderMenus menus) {
        if (instance == null)
            return new PriceServiceImpl(menus);
        return instance;
    }

    @Override
    public int getTotalPriceBefore() {
        int totalPriceBefore = menus.getTotalPriceBefore();
        return totalPriceBefore;
    }

    @Override
    public int getTotalPriceAfter(int totalBenefit, int presentationBenefit) {
        return menus.getTotalPriceBefore() - totalBenefit + presentationBenefit;
    }
}


