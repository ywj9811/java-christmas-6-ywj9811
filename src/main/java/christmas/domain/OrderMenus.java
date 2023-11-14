package christmas.domain;

import christmas.exception.DuplicatedMenuException;
import christmas.exception.OnlyBeverageException;
import christmas.exception.OverCountOfMenuException;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.constant.Layer.*;

public class OrderMenus {
    private final List<Menu> menus;

    public OrderMenus() {
        menus = new ArrayList<>();
    }

    public void add(Menu menu) {
        for (Menu originMenu : menus) {
            if (originMenu.getName()
                    .equals(menu.getName()))
                throw new DuplicatedMenuException();
        }
        menus.add(menu);
    }

    public void validate() {
        validateOnlyBeverage();
        validateSize();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public int getTotalPriceBefore() {
        int totalPrice = 0;
        for (Menu menu : menus) {
            totalPrice += menu.getTotalPrice();
        }
        return totalPrice;
    }

    public int getDesertAmount() {
        int count = 0;
        for (Menu menu : menus) {
            if (menu.getLayer().equals(DESERT)) {
                count++;
            }
        }
        return count;
    }

    public int getMainAmount() {
        int count = 0;
        for (Menu menu : menus) {
            if (menu.getLayer().equals(MAIN)) {
                count++;
            }
        }
        return count;
    }

    private void validateOnlyBeverage() {
        for (Menu menu : menus) {
            if (!menu.getLayer().equals(BEVERAGE))
                return;
        }
        throw new OnlyBeverageException();
    }

    private void validateSize() {
        int count = 0;
        for (Menu menu : menus) {
            count += menu.getAmount();
        }
        if (count > 20)
            throw new OverCountOfMenuException();
    }
}
