package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import christmas.service.BenefitService;
import christmas.service.InputMenuService;
import christmas.service.PriceService;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.domain.constant.Benefit.*;
import static christmas.util.Conversion.conversionDate;
import static christmas.view.constant.OutputFormat.*;

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
        for (int benefitPrice : benefits)
            totalBenefits += benefitPrice;

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
            outputView.preBenefit(preBenefitFormatter(date));
            outputView.orderMenus();
            for (Menu menu : menus.getMenus())
                outputView.totalMenus(orderMenusFormatter(menu));
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
        String benefit = benefitHistoryFormatter(benefits);
        outputView.presentationMenu(benefits[PRESENTATION.getColumn()]);
        outputView.benefitHistory(benefit);
    }
}
