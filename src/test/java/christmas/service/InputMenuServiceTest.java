package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputMenuServiceTest {
    private InputMenuService inputMenuService = InputMenuServiceImpl.getInstance();

    @Test
    @DisplayName("OrderMenu 테스트")
    void getInputMenus() {
        String inputMenus = "타파스-1,제로콜라-2";
        OrderMenus orderMenus = inputMenuService.getInputMenus(inputMenus);
        List<Menu> menus = orderMenus.getMenus();

        assertThat(menus.get(0).getAmount()).isEqualTo(1);
        assertThat(menus.get(0).getName()).isEqualTo("타파스");
        assertThat(menus.get(1).getAmount()).isEqualTo(2);
        assertThat(menus.get(1).getName()).isEqualTo("제로콜라");
    }

    @ValueSource(strings = {"'타파스-1,제로콜라--1'", "'타파스-1,제로콜라'", "'타파스---1,제로콜라-1'"})
    @ParameterizedTest
    @DisplayName("잘못된 형식 예외 테스트")
    void invalidFormatTest(String input) {
        assertThatThrownBy(() -> inputMenuService.getInputMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"'타파스-1,제로콜라-a'", "'타파스-a,제로콜라-a'", "'타파스-a,제로콜라-1'"})
    @ParameterizedTest
    @DisplayName("숫자가 아닌 값 예외 테스트")
    void invalidTypeTest(String input) {
        assertThatThrownBy(() -> inputMenuService.getInputMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"'타파스-1,코카콜라-4", "'타파스-1,토마토파스타-5'"})
    @ParameterizedTest
    @DisplayName("메뉴판 없는 메뉴 예외 테스트")
    void invalidMenuTest(String input) {
        assertThatThrownBy(() -> inputMenuService.getInputMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"'타파스-1,제로콜라-30'", "'타파스-10,제로콜라-11'"})
    @ParameterizedTest
    @DisplayName("개수 테스트")
    void overCountMenuTest(String input) {
        assertThatThrownBy(() -> inputMenuService.getInputMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"'타파스-1,타파스-10'", "'제로콜라-10,제로콜라-5'"})
    @ParameterizedTest
    @DisplayName("중복 테스트")
    void duplicatedMenuTest(String input) {
        assertThatThrownBy(() -> inputMenuService.getInputMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"'제로콜라-10'", "'레드와인-10"})
    @ParameterizedTest
    @DisplayName("음료 테스트")
    void onlyBeverage(String input) {
        assertThatThrownBy(() -> inputMenuService.getInputMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
