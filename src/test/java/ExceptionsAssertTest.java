import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionsAssertTest {

    @Test
    public void exceptionAsserts() {
        // Assert that an exception of the specified type is thrown
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("Invalid argument");
        }).isInstanceOf(IllegalArgumentException.class);

        // Assert that an exception with the specified message is thrown
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("Invalid argument");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid argument");

        // Assert that an exception with a message matching the specified pattern is thrown
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("Invalid argument");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("Invalid .*");

        // Assert that an exception with the specified cause is thrown
        Exception cause = new NullPointerException("Cause");
        assertThatThrownBy(() -> {
            throw new RuntimeException("Wrapper exception", cause);
        }).isInstanceOf(RuntimeException.class)
                .hasCause(cause);

        // Assert that an exception with a cause of the specified type is thrown
        assertThatThrownBy(() -> {
            throw new RuntimeException("Wrapper exception", cause);
        }).isInstanceOf(RuntimeException.class)
                .hasCauseInstanceOf(NullPointerException.class);
    }
}
