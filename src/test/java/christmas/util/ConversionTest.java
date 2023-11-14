package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static christmas.util.Conversion.conversionAmount;
import static christmas.util.Conversion.conversionDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConversionTest {
    @ValueSource(strings = {"1", "2", "3"})
    @ParameterizedTest
    @DisplayName("숫자 전환 테스트")
    void conversionAmountTest(String input) {
        assertThat(conversionAmount(input))
                .isEqualTo(Integer.parseInt(input));
    }

    @ValueSource(strings = {"a", "2a", "123-1"})
    @ParameterizedTest
    @DisplayName("숫자 전환 예외 테스트")
    void conversionAmountFailTest(String input) {
        assertThatThrownBy(() -> conversionAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1", "3" ,"5", "7", "8" ,"15", "25", "30", "31"})
    @ParameterizedTest
    @DisplayName("날짜 전환 테스트")
    void conversionDateTest(String date) {
        assertThat(conversionDate(date))
                .isEqualTo(Integer.parseInt(date));
    }

    @ValueSource(strings = {"a", "2a", "123-1"})
    @ParameterizedTest
    @DisplayName("날짜 전환 숫자 아님 예외 테스트")
    void conversionDateFailTest(String input) {
        assertThatThrownBy(() -> conversionDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"-1", "0", "123", "32", "-100", "45"})
    @ParameterizedTest
    @DisplayName("날짜 전환 날짜 범위 예외 테스트")
    void conversionDateOverOrLessFailTest(String input) {
        assertThatThrownBy(() -> conversionDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
