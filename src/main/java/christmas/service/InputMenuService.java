package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import christmas.domain.constant.MenuInfo;
import christmas.exception.InvalidMenuException;

import java.util.ArrayList;
import java.util.List;

import static christmas.util.Conversion.conversionAmount;

public class InputMenuService {
    private static final String COMMA = ",";
    private static final String DASH = "-";

    private InputMenuService() {}

    private static class InputMenuServiceHelper {
        private static final InputMenuService INPUT_MENU_SERVICE = new InputMenuService();
    }

    public static InputMenuService getInstance(){
        return InputMenuServiceHelper.INPUT_MENU_SERVICE;
    }


    public OrderMenus getInputMenus(String inputMenus) {
        List<Menu> menus = new ArrayList<>();
        String[] inputMenuDetails = inputMenus.split(COMMA);
        for (String inputMenu : inputMenuDetails) {
            Menu menu = getMenu(inputMenu);
            menus.add(menu);
        }
        return new OrderMenus(menus);
    }

    private Menu getMenu(String inputMenu) {
        String[] menuDetails = inputMenu.split(DASH);
        String name = menuDetails[0];
        int amount = conversionAmount(menuDetails[1]);
        MenuInfo menuInfo = getMenuInfo(name);
        Menu menu = new Menu(menuInfo.getLayer(), menuInfo.getName(), menuInfo.getPrice(), amount);
        return menu;
    }

    private MenuInfo getMenuInfo(String name) {
        MenuInfo[] values = MenuInfo.values();
        for (MenuInfo menuInfo : values) {
            if (menuInfo.getName().equals(name))
                return menuInfo;
        }
        throw new InvalidMenuException();
    }
}
