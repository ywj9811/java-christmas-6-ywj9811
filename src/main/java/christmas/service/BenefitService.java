package christmas.service;

import christmas.domain.OrderMenus;

import static christmas.domain.constant.Badge.*;
import static christmas.domain.constant.BenefitDay.*;
import static christmas.domain.constant.Number.*;
import static christmas.view.constant.OutputMessage.NONE;

public class BenefitService {
    private final int date;
    private static BenefitService instance;

    private BenefitService(int date) {
        this.date = date;
    }
    public static BenefitService getInstance(int date) {
        if (instance == null) {
            instance = new BenefitService(date);
        }
        return instance;
    }


    public int getD_dayBenefit(int price) {
        if (date > CHRISTMAS.getNumber() || price < MIN_PRICE.getNumber())
            return 0;
        return BENEFIT_DATE_START.getNumber()
                +(BENEFIT_DATE_UNIT.getNumber()*(date-1));
    }

    public int getWeekDayBenefit(OrderMenus menus, int price) {
        if (WEEK_DAY.getDays().contains(date)
                && price > MIN_PRICE.getNumber()) {
            return getDeserts(menus);
        }
        return 0;
    }

    private int getDeserts(OrderMenus menus) {
        int desertAmount = menus.getDesertAmount();
        return desertAmount * BENEFIT_PRICE_UNIT.getNumber();
    }

    public int getWeekEndBenefit(OrderMenus menus, int price) {
        if (WEEK_END.getDays().contains(date)
                && price > MIN_PRICE.getNumber()) {
            return getMain(menus);
        }
        return 0;
    }

    private int getMain(OrderMenus menus) {
        int mainAmount = menus.getMainAmount();
        return mainAmount* BENEFIT_PRICE_UNIT.getNumber();
    }

    public int getStarDayBenefit(int price) {
        if (STAR_DAY.getDays().contains(date)
                && price > MIN_PRICE.getNumber())
            return BENEFIT_DATE_START.getNumber();
        return 0;
    }

    public int getPresentationBenefit(int price) {
        if (price >= MIN_PRESENTATION_PRICE.getNumber())
            return PRESENTATION_PRICE.getNumber();
        return 0;
    }

    public String getBadge(int totalPrice) {
        if (totalPrice > PRESENTATION_MAX.getNumber())
            return SANTA.getMessage();
        if (totalPrice > PRESENTATION_MED.getNumber())
            return TREE.getMessage();
        if (totalPrice > PRESENTATION_MIN.getNumber())
            return STAR.getMessage();
        return NONE.getMessage();
    }
}
