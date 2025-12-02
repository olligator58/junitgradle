import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsTest {

    @Test
    public void isNullExample() {
        String actual = null;
        String notNullActual = "AssertJ";

        assertThat(actual).isNull();
        assertThat(notNullActual).isNotNull();
    }
}
