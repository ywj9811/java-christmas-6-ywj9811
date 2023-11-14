package christmas.service;

import christmas.domain.Menu;
import christmas.domain.OrderMenus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.constant.MenuInfo.*;

public class BenefitServiceTest {
    private BenefitService benefitService;

    private List<Menu> menus = new ArrayList<>();
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

    @ValueSource(ints = {50000, 40000, 30000})
    @ParameterizedTest
    @DisplayName("디데이 혜택 테스트")
    void dDayBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(25);
        int dDayBenefit = benefitService.getD_dayBenefit(input);
        Assertions.assertThat(dDayBenefit)
                .isEqualTo(1000 + 24*100);
    }

    @ValueSource(ints = {2, 15, 24})
    @ParameterizedTest
    @DisplayName("디데이 혜택 테스트 날짜별")
    void dDayBenefitPerDayTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int dDayBenefit = benefitService.getD_dayBenefit(100000);
        Assertions.assertThat(dDayBenefit)
                .isEqualTo(1000 + (input-1)*100);
    }

    @ValueSource(ints = {5000, 100, 3000, 9999})
    @ParameterizedTest
    @DisplayName("디데이 혜택 테스트 금액 부족")
    void nonedDayBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(20);
        int dDayBenefit = benefitService.getD_dayBenefit(input);
        Assertions.assertThat(dDayBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {50000, 40000, 30000})
    @ParameterizedTest
    @DisplayName("디데이 혜택 테스트 날짜 초과")
    void overDaydDayBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(30);
        int dDayBenefit = benefitService.getD_dayBenefit(input);
        Assertions.assertThat(dDayBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {3, 24, 5, 17})
    @ParameterizedTest
    @DisplayName("평일 혜택 테스트 평일")
    void weekDayBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int weekDayBenefit = benefitService.getWeekDayBenefit(orderMenus, 50000);
        Assertions.assertThat(weekDayBenefit)
                .isEqualTo(2023*2);
    }

    @ValueSource(ints = {1, 8, 15, 22})
    @ParameterizedTest
    @DisplayName("평일 혜택 테스트 주말")
    void noneWeekDayBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int weekDayBenefit = benefitService.getWeekDayBenefit(orderMenus, 50000);
        Assertions.assertThat(weekDayBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {3, 24, 5, 17})
    @ParameterizedTest
    @DisplayName("평일 혜택 테스트 가격 부족")
    void weekDayBenefitLessPriceTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int weekDayBenefit = benefitService.getWeekDayBenefit(orderMenus, 5000);
        Assertions.assertThat(weekDayBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {1, 8, 15, 22})
    @ParameterizedTest
    @DisplayName("주말 혜택 테스트 주말")
    void weekEndBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int weekEndBenefit = benefitService.getWeekEndBenefit(orderMenus, 50000);
        Assertions.assertThat(weekEndBenefit)
                .isEqualTo(2023*4);
    }

    @ValueSource(ints = {3, 24, 5, 17})
    @ParameterizedTest
    @DisplayName("주말 혜택 테스트 평일")
    void noneWeekEndBenefitTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int weekEndBenefit = benefitService.getWeekEndBenefit(orderMenus, 50000);
        Assertions.assertThat(weekEndBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {1, 8, 15, 22})
    @ParameterizedTest
    @DisplayName("주말 혜택 테스트 가격 부족")
    void weekEndBenefitLessPriceTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int weekEndBenefit = benefitService.getWeekEndBenefit(orderMenus, 5000);
        Assertions.assertThat(weekEndBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    @ParameterizedTest
    @DisplayName("특별 혜택 테스트 해당 날짜")
    void starDayTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int starDayBenefit = benefitService.getStarDayBenefit(50000);
        Assertions.assertThat(starDayBenefit)
                .isEqualTo(1000);
    }

    @ValueSource(ints = {1, 2, 4, 5, 20, 27, 30})
    @ParameterizedTest
    @DisplayName("특별 혜택 테스트 해당 안되는 날짜")
    void noneStarDayTest(int input) {
        benefitService = BenefitServiceImpl.reset(input);
        int starDayBenefit = benefitService.getStarDayBenefit(50000);
        Assertions.assertThat(starDayBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {120000, 130000, 140000, 150000})
    @ParameterizedTest
    @DisplayName("증정 혜택 테스트")
    void presentationTest(int input) {
        benefitService = BenefitServiceImpl.reset(5);
        int presentationBenefit = benefitService.getPresentationBenefit(input);
        Assertions.assertThat(presentationBenefit)
                .isEqualTo(25000);
    }

    @ValueSource(ints = {110000, 12000, 13000, 14000, 15000})
    @ParameterizedTest
    @DisplayName("증정 혜택 테스트")
    void nonePresentationTest(int input) {
        benefitService = BenefitServiceImpl.reset(5);
        int presentationBenefit = benefitService.getPresentationBenefit(input);
        Assertions.assertThat(presentationBenefit)
                .isEqualTo(0);
    }

    @ValueSource(ints = {20000, 30000})
    @ParameterizedTest
    @DisplayName("산타 배지 테스트")
    void santaBadgeTest(int input) {
        benefitService = BenefitServiceImpl.reset(5);
        String badge = benefitService.getBadge(input);
        Assertions.assertThat(badge)
                .isEqualTo("산타");
    }

    @ValueSource(ints = {10000, 19999})
    @ParameterizedTest
    @DisplayName("트리 배지 테스트")
    void treeBadgeTest(int input) {
        benefitService = BenefitServiceImpl.reset(5);
        String badge = benefitService.getBadge(input);
        Assertions.assertThat(badge)
                .isEqualTo("트리");
    }

    @ValueSource(ints = {5000, 9999})
    @ParameterizedTest
    @DisplayName("별 배지 테스트")
    void starBadgeTest(int input) {
        benefitService = BenefitServiceImpl.reset(5);
        String badge = benefitService.getBadge(input);
        Assertions.assertThat(badge)
                .isEqualTo("별");
    }

    @ValueSource(ints = {1000, 4999})
    @ParameterizedTest
    @DisplayName("없음 배지 테스트")
    void noneBadgeTest(int input) {
        benefitService = BenefitServiceImpl.reset(5);
        String badge = benefitService.getBadge(input);
        Assertions.assertThat(badge)
                .isEqualTo("없음");
    }
}
