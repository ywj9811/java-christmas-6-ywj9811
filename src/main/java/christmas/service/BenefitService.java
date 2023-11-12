package christmas.service;

import christmas.domain.Menu;

import java.util.List;

import static christmas.domain.constant.Badge.*;
import static christmas.domain.constant.Layer.DESERT;
import static christmas.domain.constant.Layer.MAIN;
import static christmas.view.constant.OutputMessage.NONE;

public class BenefitService {
    private final static List<Integer> WEEKDAY = List.of(1,4,5,6,7,8,11,12,13,14,15,18,19,20,21,22,25,26,27,28,29);
    private final static List<Integer> WEEKEND = List.of(2,3,9,10,16,17,23,24,30,31);
    private final static List<Integer> STAR_DAY = List.of(3,10,17,24,25,31);
    private final int date;
    public BenefitService(int date) {
        this.date = date;
    }


    public int getD_dayBenefit() {
        if (date > 25)
            return 0;
        return 1000+(100*(date-1));
    }

    public int getWeekDayBenefit(List<Menu> menus) {
        if (WEEKDAY.contains(date)) {
            return getDeserts(menus);
        }
        return 0;
    }

    private int getDeserts(List<Menu> menus) {
        int desertBenefit = 0;
        for (Menu menu : menus) {
            if (menu.getLayer().equals(DESERT)) {
                desertBenefit += 2023*menu.getAmount();
            }
        }
        return desertBenefit;
    }

    public int getWeekEndBenefit(List<Menu> menus) {
        if (WEEKEND.contains(date)) {
            return getMain(menus);
        }
        return 0;
    }

    private int getMain(List<Menu> menus) {
        int mainBenefit = 0;
        for (Menu menu : menus) {
            if (menu.getLayer().equals(MAIN)) {
                mainBenefit += 2023*menu.getAmount();
            }
        }
        return mainBenefit;
    }

    public int getStarDayBenefit() {
        if (STAR_DAY.contains(date))
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
