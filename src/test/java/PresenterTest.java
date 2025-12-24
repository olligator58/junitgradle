import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PresenterTest {
    private Calculator calculator = mock(Calculator.class);
    private Presenter presenter = new Presenter(calculator);

    @Test
    void test() {
        when(calculator.sum(anyInt(), eq(3))).thenReturn(8);
        presenter.showSum(5, 3);
        int actual = presenter.getRecentValue();

        assertEquals(8, actual);
    }

    static class Calculator {

        public int sum(int a, int b) {
            return 0;
        }
    }

    static class Presenter {
        private final Calculator calculator;

        private Integer recentValue;

        public Presenter(Calculator calculator) {
            this.calculator = calculator;
        }

        // displays the sum of two integers
        public void showSum(int a, int b) {
            int sum = calculator.sum(a, b);
            recentValue = sum;    // update recentValue
            System.out.println(sum);
        }

        public Integer getRecentValue() {
            return recentValue;
        }
    }
}