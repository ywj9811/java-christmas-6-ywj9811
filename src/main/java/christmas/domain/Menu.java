package christmas.domain;

public class Menu {
    private final String layer;
    private final String name;
    private final int price;
    private final int amount;

    public Menu(String layer, String name, int price, int amount) {
        this.layer = layer;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getLayer() {
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
