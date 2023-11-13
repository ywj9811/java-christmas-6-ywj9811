package christmas.service;

import christmas.domain.Menu;
import christmas.domain.constant.MenuInfo;
import christmas.exception.InvalidMenuException;

import java.util.ArrayList;
import java.util.List;

public class InputMenuService {
    public List<Menu> getInputMenus(String inputMenus) {
        List<Menu> menus = new ArrayList<>();
        String[] inputMenuDetails = inputMenus.split(",");
        for (String inputMenu : inputMenuDetails) {
            Menu menu = getMenu(inputMenu);
            menus.add(menu);
        }
        return menus;
    }

    private Menu getMenu(String inputMenu) {
        String[] menuDetails = inputMenu.split("-");
        String name = menuDetails[0];
        int amount = Integer.parseInt(menuDetails[1]);
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
