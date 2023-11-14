package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.constant.MenuInfo.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderMenusTest {
    private List<Menu> menus;
    private OrderMenus orderMenus;
    @BeforeEach
    void setting() {
        menus = new ArrayList<>();
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
    }

    @Test
    @DisplayName("OrderMenus 생성 테스트")
    void setOrderMenusTest() {
        List<Menu> testMenus = orderMenus.getMenus();
        for (int i = 0; i < menus.size(); i++) {
            Assertions.assertThat(testMenus.get(i))
                    .isEqualTo(menus.get(i));
        }
    }

    @Test
    @DisplayName("OrderMenus 중복 메뉴 추가 예외 테스트")
    void setOrderMenusDuplicatedTest() {
        assertThatThrownBy(() -> orderMenus.add(new Menu(TAPAS.getName(), 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("OrderMenu 없는 메뉴 추가 예외 테스트")
    void setOrderMenusInvalidMenuTest() {
        assertThatThrownBy(() -> orderMenus.add(new Menu("테파스", 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
