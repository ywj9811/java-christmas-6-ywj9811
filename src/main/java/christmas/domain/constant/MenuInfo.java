package christmas.domain.constant;

import static christmas.domain.constant.Layer.*;

public enum MenuInfo {
    SOUP(APPETIZER, "양송이수프",6000),
    TAPAS(APPETIZER, "타파스", 5500),
    SALAD(APPETIZER, "시저샐러드", 8000),
    T_BONE(MAIN,"티본스테이크",55000),
    RIB(MAIN,"바비큐립",54000),
    OCEAN_PASTA(MAIN,"해산물파스타",35000),
    CHRISTMAS_PASTA(MAIN,"크리스마스파스타",25000),
    CAKE(DESERT, "초코케이크",15000),
    ICE_CREAM(DESERT,"아이스크림",5000),
    COLA(BEVERAGE, "제로콜라",3000),
    WINE(BEVERAGE,"레드와인",60000),
    CHAMPAGNE(BEVERAGE,"샴페인",25000);


    private final Layer layer;
    private final String name;
    private final int price;

    MenuInfo(Layer layer, String name, int price) {
        this.layer = layer;
        this.name = name;
        this.price = price;
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
}
