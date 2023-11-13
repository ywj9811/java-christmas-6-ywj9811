package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.constant.MenuInfo.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PriceServiceTest {
    private PriceService priceService;
    @BeforeEach
    void setting() {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu(CAKE.getLayer(), CAKE.getName(), CAKE.getPrice(), 1));
        menus.add(new Menu(CHAMPAGNE.getLayer(), CHAMPAGNE.getName(), CHAMPAGNE.getPrice(), 1));
        menus.add(new Menu(RIB.getLayer(), RIB.getName(), RIB.getPrice(), 1));
        menus.add(new Menu(SOUP.getLayer(), SOUP.getName(), SOUP.getPrice(), 1));
        menus.add(new Menu(TAPAS.getLayer(), TAPAS.getName(), TAPAS.getPrice(), 1));
        menus.add(new Menu(SALAD.getLayer(), SALAD.getName(), SALAD.getPrice(), 1));
        menus.add(new Menu(T_BONE.getLayer(), T_BONE.getName(), T_BONE.getPrice(), 1));
        menus.add(new Menu(OCEAN_PASTA.getLayer(), OCEAN_PASTA.getName(), OCEAN_PASTA.getPrice(), 1));
        menus.add(new Menu(CHRISTMAS_PASTA.getLayer(), CHRISTMAS_PASTA.getName(), CHRISTMAS_PASTA.getPrice(), 1));
        menus.add(new Menu(ICE_CREAM.getLayer(), ICE_CREAM.getName(), ICE_CREAM.getPrice(), 1));
        menus.add(new Menu(COLA.getLayer(), COLA.getName(), COLA.getPrice(), 1));
        menus.add(new Menu(WINE.getLayer(), WINE.getName(), WINE.getPrice(), 1));
        OrderMenus orderMenus = new OrderMenus(menus);
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
