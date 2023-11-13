package christmas.controller;

import christmas.domain.OrderMenus;
import christmas.service.BenefitService;
import christmas.service.InputMenuService;
import christmas.service.PriceService;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.domain.constant.Benefit.*;
import static christmas.util.Conversion.conversionDate;
import static christmas.view.constant.OutputFormat.*;
import static christmas.view.constant.OutputMessage.*;

public class ChristmasEventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputMenuService inputMenuService = new InputMenuService();
    private final int[] benefits = new int[5];
    private PriceService priceService;
    private BenefitService benefitService;

    public void setServices(OrderMenus menus, int date) {
        priceService = new PriceService(menus);
        benefitService = new BenefitService(date);
    }

    public void getResult() {
        int totalBenefits = 0;
        for (int benefitPrice : benefits) {
            totalBenefits += benefitPrice;
        }

        int totalPriceAfter = priceService.getTotalPriceAfter(totalBenefits, benefits[PRESENTATION.getColumn()]);
        outputView.totalBenefit(benefitFormatter(totalBenefits));
        outputView.totalPriceAfter(priceFormatter(totalPriceAfter));

        String badge = benefitService.getBadge(totalBenefits);
        outputView.badge(badge);
    }

    public void greeting() {
        outputView.greeting();
    }

    public int greetingAndInputDate() {
        try {
            String inputDate = inputView.visitDate();
            int date = conversionDate(inputDate);
            return date;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return greetingAndInputDate();
        }
    }

    public OrderMenus inputOrders(int date) {
        try {
            String orders = inputView.getOrders();
            OrderMenus menus = inputMenuService.getInputMenus(orders);
            outputView.preBenefit(date);
            outputView.orderMenus(menus);
            return menus;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputOrders(date);
        }
    }

    public int totalPriceBefore() {
        int totalPriceBefore = priceService.getTotalPriceBefore();
        outputView.totalPriceBefore(priceFormatter(totalPriceBefore));
        return totalPriceBefore;
    }

    public void getBenefits(OrderMenus menus, int totalPriceBefore) {
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
