package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.constant.MenuInfo.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceServiceTest {
    private PriceService priceService;
    private OrderMenus orderMenus;
    @BeforeEach
    void setting() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(CAKE.getName(), 1));
        menus.add(new Menu(CHAMPAGNE.getName(), 1));
        menus.add(new Menu(RIB.getName(),1));
        menus.add(new Menu(SOUP.getName(),1));
        menus.add(new Menu(TAPAS.getName(), 1));
        menus.add(new Menu(SALAD.getName(), 1));
        menus.add(new Menu(T_BONE.getName(), 1));
        menus.add(new Menu(OCEAN_PASTA.getName(), 1));
        menus.add(new Menu(CHRISTMAS_PASTA.getName(), 1));
        menus.add(new Menu(ICE_CREAM.getName(), 1));
        menus.add(new Menu(COLA.getName(), 1));
        menus.add(new Menu(WINE.getName(), 1));
        orderMenus = new OrderMenus();
        for (Menu menu : menus)
            orderMenus.add(menu);
        priceService = PriceServiceImpl.reset(orderMenus);
    }

    @Test
    @DisplayName("혜택 전 총 금액 테스트")
    void totalPriceBeforeTest() {
        int totalPriceBefore = priceService.getTotalPriceBefore();
        assertThat(totalPriceBefore)
                .isEqualTo(296500);
    }

    @Test
    @DisplayName("혜택 이후 금액 테스트")
    void totalPriceAfterTest() {
        int totalPriceAfter = priceService.getTotalPriceAfter(10000, 0);
        assertThat(totalPriceAfter)
                .isEqualTo(286500);
    }
}
