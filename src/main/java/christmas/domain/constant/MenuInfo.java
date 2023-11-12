package christmas.domain.constant;

import static christmas.domain.constant.Layer.*;

public enum MenuInfo {
    SOUP(APPETIZER.name(), "양송이수프",6000),
    TAPAS(APPETIZER.name(), "타파스", 5500),
    SALAD(APPETIZER.name(), "시저샐러드", 8000),
    T_BONE(MAIN.name(),"티본스테이크",55000),
    RIB(MAIN.name(),"바비큐립",54000),
    OCEAN_PASTA(MAIN.name(),"해산물파스타",35000),
    CHRISTMAS_PASTA(MAIN.name(),"크리스마스파스타",25000),
    CAKE(DESERT.name(), "초코케이크",5000),
    ICE_CREAM(DESERT.name(),"아이스크림",5000),
    COLA(BEVERAGE.name(), "제로콜라",3000),
    WINE(BEVERAGE.name(),"레드와인",60000),
    CHAMPAGNE(BEVERAGE.name(),"샴페인",25000);


    private final String layer;
    private final String name;
    private final int price;

    MenuInfo(String layer, String name, int price) {
        this.layer = layer;
        this.name = name;
        this.price = price;
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
}
