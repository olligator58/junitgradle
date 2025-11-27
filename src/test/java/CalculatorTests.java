import org.example.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
