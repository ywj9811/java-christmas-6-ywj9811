package christmas;

import christmas.controller.ChristmasEventController;
import christmas.domain.Menu;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ChristmasEventController controller = new ChristmasEventController();
        controller.greeting();
        int date = controller.greetingAndInputDate();
        List<Menu> menus = controller.inputOrders(date);
        controller.setServices(menus, date);
        int totalPriceBefore = controller.totalPriceBefore();
        controller.getBenefits(menus, totalPriceBefore);
        controller.getResult(totalPriceBefore);
    }
}
