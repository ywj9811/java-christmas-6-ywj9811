package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import christmas.service.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.util.Conversion.conversionDate;
import static christmas.view.constant.OutputFormat.*;

public class EventInputController {
    private final OutputView outputView;
    private final InputView inputView;
    private final InputMenuService inputMenuService;
    private static EventInputController instance;

    private EventInputController(OutputView outputView, InputView inputView, InputMenuService inputMenuService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.inputMenuService = inputMenuService;
    }

    public static EventInputController getInstance(OutputView outputView, InputView inputView, InputMenuService inputMenuService) {
        if (instance == null) {
            instance = new EventInputController(outputView, inputView, inputMenuService);
        }
        return instance;
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
}
