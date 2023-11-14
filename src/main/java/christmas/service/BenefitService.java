package christmas.service;

import christmas.domain.OrderMenus;

public interface BenefitService {
    int getD_dayBenefit(int price);

    int getWeekDayBenefit(OrderMenus menus, int price);

    int getWeekEndBenefit(OrderMenus menus, int price);

    int getStarDayBenefit(int price);

    int getPresentationBenefit(int price);

    String getBadge(int totalPrice);
}
