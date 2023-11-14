package christmas.domain;

import christmas.domain.constant.Layer;
import christmas.domain.constant.MenuInfo;
import christmas.exception.InvalidMenuException;

public class Menu {
    private final Layer layer;
    private final String name;
    private final int price;
    private final int amount;

    public Menu(String name, int amount) {
        MenuInfo menuInfo = validateMenu(name);
        this.layer = menuInfo.getLayer();
        this.name = menuInfo.getName();
        this.price = menuInfo.getPrice();
        this.amount = amount;
    }

    private MenuInfo validateMenu(String name) {
        MenuInfo[] values = MenuInfo.values();
        for (MenuInfo menuInfo : values) {
            if (menuInfo.getName().equals(name))
                return menuInfo;
        }
        throw new InvalidMenuException();
    }

    public Layer getLayer() {
        return layer;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPrice() {
        return price*amount;
    }
}
