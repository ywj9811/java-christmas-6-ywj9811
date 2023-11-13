package christmas;

import christmas.config.AppConfig;
import christmas.controller.EventInputController;
import christmas.controller.EventPriceController;
import christmas.domain.OrderMenus;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        EventInputController eventInputController = appConfig.eventInputController();
        eventInputController.greeting();
        int date = eventInputController.greetingAndInputDate();
        OrderMenus menus = eventInputController.inputOrders(date);

        EventPriceController eventPriceController = appConfig.eventPriceController(menus, date);
        int totalPriceBefore = eventPriceController.totalPriceBefore();
        eventPriceController.getBenefits(menus, totalPriceBefore);
        eventPriceController.getResult();
    }
}
