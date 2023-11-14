package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import christmas.domain.constant.MenuInfo;
import christmas.exception.InvalidMenuException;

import java.util.ArrayList;
import java.util.List;

import static christmas.util.Conversion.conversionAmount;

public class InputMenuServiceImpl implements InputMenuService{
    private static final String COMMA = ",";
    private static final String DASH = "-";

    private InputMenuServiceImpl() {}

    private static class InputMenuServiceHelper {
        private static final InputMenuService INPUT_MENU_SERVICE = new InputMenuServiceImpl();
    }

    public static InputMenuService getInstance(){
        return InputMenuServiceHelper.INPUT_MENU_SERVICE;
    }

    @Override
    public OrderMenus getInputMenus(String inputMenus) {
        OrderMenus orderMenus = new OrderMenus();
        String[] inputMenuDetails = inputMenus.split(COMMA);
        for (String inputMenu : inputMenuDetails) {
            Menu menu = getMenu(inputMenu);
            orderMenus.add(menu);
        }
        return orderMenus;
    }

    private Menu getMenu(String inputMenu) {
        String[] menuDetails = inputMenu.split(DASH);
        String name = menuDetails[0];
        int amount = conversionAmount(menuDetails[1]);
        Menu menu = new Menu(name, amount);
        return menu;
    }
}
