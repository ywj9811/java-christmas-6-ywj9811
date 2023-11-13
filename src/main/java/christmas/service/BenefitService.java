package christmas.service;

import christmas.domain.OrderMenus;

import static christmas.domain.constant.Badge.*;
import static christmas.domain.constant.BenefitDay.*;
import static christmas.view.constant.OutputMessage.NONE;

public class BenefitService {
    private final int date;
    public BenefitService(int date) {
        this.date = date;
    }


    public int getD_dayBenefit(int price) {
        if (date > 25 || price < 10000)
            return 0;
        return 1000+(100*(date-1));
    }

    public int getWeekDayBenefit(OrderMenus menus, int price) {
        if (WEEK_DAY.getDays().contains(date)
                && price > 10000) {
            return getDeserts(menus);
        }
        return 0;
    }

    private int getDeserts(OrderMenus menus) {
        int desertAmount = menus.getDesertAmount();
        return desertAmount*2023;
    }

    public int getWeekEndBenefit(OrderMenus menus, int price) {
        if (WEEK_END.getDays().contains(date)
                && price > 10000) {
            return getMain(menus);
        }
        return 0;
    }

    private int getMain(OrderMenus menus) {
        int mainAmount = menus.getMainAmount();
        return mainAmount*2023;
    }

    public int getStarDayBenefit(int price) {
        if (STAR_DAY.getDays().contains(date)
                && price > 10000)
            return 1000;
        return 0;
    }

    public int getPresentationBenefit(int price) {
        if (price >= 120000)
            return 25000;
        return 0;
    }

    public String getBadge(int totalPrice) {
        if (totalPrice > 20000)
            return SANTA.getMessage();
        if (totalPrice > 10000)
            return TREE.getMessage();
        if (totalPrice > 5000)
            return STAR.getMessage();
        return NONE.getMessage();
    }
}
