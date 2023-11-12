package christmas.controller;

import christmas.domain.Menu;
import christmas.exception.OutOfRangeException;
import christmas.service.BenefitService;
import christmas.service.InputMenuService;
import christmas.service.PriceService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

import static christmas.domain.constant.Benefit.*;
import static christmas.view.constant.OutputFormat.*;
import static christmas.view.constant.OutputMessage.*;
import static christmas.view.constant.OutputMessage.STAR_BENEFIT;

public class ChristmasEventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputMenuService inputMenuService = new InputMenuService();
    private final int[] benefits = new int[5];
    private PriceService priceService;
    private BenefitService benefitService;

    public void setServices(List<Menu> menus, int date) {
        priceService = new PriceService(menus);
        benefitService = new BenefitService(date);
    }

    public void getResult(int totalPriceBefore) {
        int totalBenefits = 0;
        for (int benefitPrice : benefits) {
            totalBenefits += benefitPrice;
        }

        int totalPriceAfter = priceService.getTotalPriceAfter(totalPriceBefore, totalBenefits, benefits[PRESENTATION.getColumn()]);
        outputView.totalBenefit(benefitFormatter(totalBenefits));
        outputView.totalPriceAfter(priceFormatter(totalPriceAfter));

        String badge = benefitService.getBadge(totalBenefits);
        outputView.badge(badge);
    }

    public int greetingAndInputDate() {
        outputView.greeting();
        String s = inputView.visitDate();
        int date = Integer.parseInt(s);
        if (date < 1 || date > 31)
            throw new OutOfRangeException();
        return date;
    }

    public List<Menu> inputOrders(int date) {
        String orders = inputView.getOrders();
        outputView.preBenefit(date);
        List<Menu> menus = inputMenuService.getInputMenus(orders);
        outputView.orderMenus(menus);
        return menus;
    }

    public int totalPriceBefore() {
        int totalPriceBefore = priceService.getTotalPriceBefore();
        outputView.totalPriceBefore(priceFormatter(totalPriceBefore));
        return totalPriceBefore;
    }

    public void getBenefits(List<Menu> menus, int date, int totalPriceBefore) {
        benefits[PRESENTATION.getColumn()] = benefitService.getPresentationBenefit(totalPriceBefore);
        benefits[D_DAY.getColumn()] = benefitService.getD_dayBenefit(totalPriceBefore);
        benefits[WEEKDAY.getColumn()] = benefitService.getWeekDayBenefit(menus, totalPriceBefore);
        benefits[WEEKEND.getColumn()] = benefitService.getWeekEndBenefit(menus, totalPriceBefore);
        benefits[STAR_DAY.getColumn()] = benefitService.getStarDayBenefit(totalPriceBefore);
        String benefit = makeBenefit(benefits);
        outputView.presentationMenu(benefits[PRESENTATION.getColumn()]);
        outputView.benefitHistory(benefit);
    }

    private String makeBenefit(int[] benefits) {
        StringBuilder sb = new StringBuilder();
        if (benefits[D_DAY.getColumn()] > 0)
            sb.append(CHRISTMAS_BENEFIT.getMessage() + minusFormatter(benefits[D_DAY.getColumn()]));
        if (benefits[WEEKDAY.getColumn()] > 0)
            sb.append(WEEKDAY_BENEFIT.getMessage() + minusFormatter(benefits[WEEKDAY.getColumn()]));
        if (benefits[WEEKEND.getColumn()] > 0)
            sb.append(WEEKEND_BENEFIT.getMessage() + minusFormatter(benefits[WEEKEND.getColumn()]));
        if (benefits[STAR_DAY.getColumn()] > 0)
            sb.append(STAR_BENEFIT.getMessage() + minusFormatter(benefits[STAR_DAY.getColumn()]));
        if (benefits[PRESENTATION.getColumn()] > 0)
            sb.append(PRESENTATION_BENEFIT.getMessage() + minusFormatter(benefits[PRESENTATION.getColumn()]));
        if (sb.isEmpty())
            sb.append(NONE.getMessage());
        return sb.toString();
    }
}
