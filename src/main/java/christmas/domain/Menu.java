package christmas.domain;

import christmas.domain.constant.Layer;

public class Menu {
    private final Layer layer;
    private final String name;
    private final int price;
    private final int amount;

    public Menu(Layer layer, String name, int price, int amount) {
        this.layer = layer;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Layer getLayer() {
        return layer;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalPrice() {
        return price*amount;
    }
}
