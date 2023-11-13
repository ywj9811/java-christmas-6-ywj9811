package christmas;

import christmas.controller.ChristmasEventController;
import christmas.domain.OrderMenus;

public class Application {
    public static void main(String[] args) {
        ChristmasEventController controller = new ChristmasEventController();
        controller.greeting();
        int date = controller.greetingAndInputDate();
        OrderMenus menus = controller.inputOrders(date);
        controller.setServices(menus, date);
        int totalPriceBefore = controller.totalPriceBefore();
        controller.getBenefits(menus, totalPriceBefore);
        controller.getResult();
    }
}
