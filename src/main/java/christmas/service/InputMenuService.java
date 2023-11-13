package christmas.service;

import christmas.domain.Menu;
import christmas.domain.constant.MenuInfo;
import christmas.exception.DuplicatedMenuException;
import christmas.exception.InvalidFormatException;
import christmas.exception.InvalidMenuException;

import java.util.ArrayList;
import java.util.List;

public class InputMenuService {
    public List<Menu> getInputMenus(String inputMenus) {
        List<Menu> menus = new ArrayList<>();
        String[] inputMenuDetails = inputMenus.split(",");
        for (String inputMenu : inputMenuDetails) {
            Menu menu = getMenu(inputMenu);
            checkDuplicated(menus, menu);
            menus.add(menu);
        }
        return menus;
    }

    private Menu getMenu(String inputMenu) {
        try {
            String[] menuDetails = inputMenu.split("-");
            String name = menuDetails[0];
            int amount = Integer.parseInt(menuDetails[1]);
            MenuInfo menuInfo = getMenuInfo(name);
            Menu menu = new Menu(menuInfo.getLayer(), menuInfo.getName(), menuInfo.getPrice(), amount);
            return menu;
        } catch (Exception e) {
            throw new InvalidFormatException();
        }
    }

    private MenuInfo getMenuInfo(String name) {
        MenuInfo[] values = MenuInfo.values();
        for (MenuInfo menuInfo : values) {
            if (menuInfo.getName().equals(name))
                return menuInfo;
        }
        throw new InvalidMenuException();
    }

    private void checkDuplicated(List<Menu> menus, Menu inputMenu) {
        for (Menu originMenu : menus) {
            if (originMenu.getName()
                    .equals(inputMenu.getName()))
                throw new DuplicatedMenuException();
        }
    }
}
