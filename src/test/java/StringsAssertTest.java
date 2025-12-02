import org.example.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsAssertTest {

    @Test
    public void stringAsserts() {
        String actual = "AssertJ is a great library for writing tests";

        // Check if the string is equal to the expected value (case-insensitive)
        assertThat(actual)
                .isEqualToIgnoringCase("assertj is a great library for writing tests");

        // Check if the string starts with the specified prefix
        assertThat(actual)
                .startsWith("AssertJ");

        // Check if the string ends with the specified suffix
        assertThat(actual)
                .endsWith("writing tests");

        // Check if the string contains the specified substring
        assertThat(actual)
                .contains("great");

        // Check if the string matches the specified regular expression
        assertThat(actual)
                .matches("AssertJ.*library.*writing tests");

        // Check if the string has the specified length
        assertThat(actual)
                .hasSize(44);

        // Check if the string is empty
        String emptyString = "";
        assertThat(emptyString)
                .isEmpty();

        // Check if the string is not empty
        assertThat(actual)
                .isNotEmpty();
    }

    @Test
    public void isEqualToExample() {
        String actual = "AssertJ";
        String expected = "AssertJ";
        String unexpected = "Assert";

        assertThat(actual).isEqualTo(expected);
        assertThat(actual).isNotEqualTo(unexpected);
    }

    @Test
    public void isEqualToObjectExample() {
        Person actual = new Person("John", "Doe", 30);
        Person expected = new Person("John", "Doe", 30);

        assertThat(actual).isEqualTo(expected);
    }
}

