package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.domain.constant.Layer.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuTest {
    @ValueSource(strings = {"양송이수프", "타파스", "시저샐러드"})
    @ParameterizedTest
    @DisplayName("에피타이저 생성 테스트")
    void createAppetizerMenu(String name) {
        Menu menu = new Menu(name, 1);
        assertThat(menu.getLayer())
                .isEqualTo(APPETIZER);
    }

    @ValueSource(strings = {"티본스테이크", "티본스테이크", "해산물파스타", "해산물파스타"})
    @ParameterizedTest
    @DisplayName("메인 생성 테스트")
    void createMainMenu(String name) {
        Menu menu = new Menu(name, 1);
        assertThat(menu.getLayer())
                .isEqualTo(MAIN);
    }

    @ValueSource(strings = {"초코케이크", "아이스크림"})
    @ParameterizedTest
    @DisplayName("디저트 생성 테스트")
    void createDesertMenu(String name) {
        Menu menu = new Menu(name, 1);
        assertThat(menu.getLayer())
                .isEqualTo(DESERT);
    }

    @ValueSource(strings = {"제로콜라", "레드와인", "샴페인"})
    @ParameterizedTest
    @DisplayName("음료 생성 테스트")
    void createBeverageMenu(String name) {
        Menu menu = new Menu(name, 1);
        assertThat(menu.getLayer())
                .isEqualTo(BEVERAGE);
    }

    @ValueSource(strings = {"제로", "화이트와인", "립아이"})
    @ParameterizedTest
    @DisplayName("존재하지 않는 메뉴 예외 테스트")
    void invalidMenuTest(String name) {
        assertThatThrownBy(() -> new Menu(name, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
