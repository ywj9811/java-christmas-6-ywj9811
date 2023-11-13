package christmas.service;

import christmas.domain.OrderMenus;

public class PriceServiceImpl implements PriceService{
    private final OrderMenus menus;
    private static PriceService instance;

    private PriceServiceImpl(OrderMenus menus) {
        this.menus = menus;
    }

    public static PriceService getInstance(OrderMenus menus) {
        if (instance == null)
            instance = new PriceServiceImpl(menus);
        return instance;
    }

    /**
     * 테스트용 싱글톤 해제 실전 사용X 절대 금지
     */
    public static PriceService reset(OrderMenus menus) {
        return new PriceServiceImpl(menus);
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


