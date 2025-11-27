import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTests {
    private Calculator calculator;

    @BeforeEach
    void createCalculator() {
        this.calculator = new Calculator();
    }

    @Test
    @DisplayName("Adding 3 and 7. Result must be 10.")
    void testAddition() {
        int result = calculator.add(3, 7);

        assertEquals(result, 10, "result is not 10");
    }

    @Test
    @DisplayName("Multiplying 11 and 13. Result must be 143.")
    void testMultiplication() {
        int result = calculator.multiply(11, 13);

        assertEquals(result, 143, "result is not 143");
    }

    @Test
    @DisplayName("Subtraction 100 and 23. Result must be 77.")
    void testSubtraction() {
        int result = calculator.subtract(100, 23);

        assertEquals(result, 77, "result is not 77");
    }

    @Test
    @DisplayName("Division 51 and 17. Result must be 3.")
    void testDivision() {
        int result = calculator.divide(51, 17);

        assertEquals(result, 3, "result is not 3");
    }

    @Test
    @DisplayName("Division by zero. IllegalArgumentException must be thrown.")
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(23, 0);
        }, "IllegalArgumentException was not thrown");
    }

    @ParameterizedTest(name = "{index} => maxOf({0}, {1}) == {2}")
    @CsvSource({"2, 1, 2", "1, 2, 2", "1, 1, 1", "-123, 5, 5"})
    void testMax(int first, int second, int expected) {
        int result = calculator.maxOf(first, second);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 1000})
    void testIsEven(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @EmptySource
    void testEmpty(int[] arg) {
        assertEquals(0, arg.length);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testNullAndEmpty(int[] arg) {
        assertTrue(arg == null || arg.length == 0);
    }

    @ParameterizedTest
    @MethodSource("stringFactory")
    void testStrings(String string) {
        assertFalse(string.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("argFactory")
    void testStringLength(String str, int length) {
        assertEquals(length, str.length());
    }

    static List<String> stringFactory() {
        return List.of("apple", "banana", "lemon", "orange");
    }

    static List<Arguments> argFactory() {
        return List.of(arguments("apple", 5), arguments("watermelon", 10));
    }
}
