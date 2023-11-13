package christmas.config;

import christmas.controller.EventInputController;
import christmas.controller.EventPriceController;
import christmas.domain.OrderMenus;
import christmas.service.*;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return InputView.getInstance();
    }

    public OutputView outputView() {
        return OutputView.getInstance();
    }
    public BenefitService benefitService(int date) {
        return BenefitServiceImpl.getInstance(date);
    }

    public PriceService priceService(OrderMenus menus) {
        return PriceServiceImpl.getInstance(menus);
    }

    public InputMenuService inputMenuService() {
        return InputMenuServiceImpl.getInstance();
    }

    public EventInputController eventInputController() {
        return EventInputController.getInstance(outputView(), inputView(), inputMenuService());
    }

    public EventPriceController eventPriceController(OrderMenus menus, int date) {
        return EventPriceController.getInstance(outputView(), priceService(menus), benefitService(date));
    }
}
