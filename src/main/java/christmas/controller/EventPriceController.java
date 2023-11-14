package christmas.controller;

import christmas.domain.OrderMenus;
import christmas.service.BenefitService;
import christmas.service.PriceService;
import christmas.view.OutputView;

import static christmas.domain.constant.Benefit.*;
import static christmas.domain.constant.Benefit.PRESENTATION;
import static christmas.view.constant.OutputFormat.*;
import static christmas.view.constant.OutputFormat.priceFormatter;

public class EventPriceController {
    private final OutputView outputView;
    private final PriceService priceService;
    private final BenefitService benefitService;
    private final int[] benefits = new int[5];
    private static EventPriceController instance;

    private EventPriceController(OutputView outputView, PriceService priceService, BenefitService benefitService) {
        this.outputView = outputView;
        this.priceService = priceService;
        this.benefitService = benefitService;
    }

    public static EventPriceController getInstance(OutputView outputView, PriceService priceService, BenefitService benefitService) {
        if (instance == null)
            instance = new EventPriceController(outputView, priceService, benefitService);
        return instance;
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
}
