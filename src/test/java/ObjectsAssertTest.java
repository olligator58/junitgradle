import org.example.Person;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectsAssertTest {

    @Test
    public void typeAsserts() {
        Object number = 42;

        // Check if the object is an instance of the specified class
        assertThat(number)
                .isInstanceOf(Integer.class);

        // Check if the object is an instance of any of the specified classes
        assertThat(number)
                .isInstanceOfAny(Integer.class, Long.class);

        // Check if the object is not an instance of the specified class
        assertThat(number)
                .isNotInstanceOf(String.class);

        // Check if the object is not an instance of any of the specified classes
        assertThat(number)
                .isNotInstanceOfAny(String.class, Float.class);
    }

    @Test
    public void fieldAsserts() {
        Person person = new Person("John", "Doe", 30);

        // Check if the object has the specified field with the given value
        assertThat(person)
                .hasFieldOrPropertyWithValue("firstName", "John");

        // Check if the object has the specified field (or property)
        assertThat(person)
                .hasFieldOrProperty("lastName");
    }

    @Test
    public void satisfiesAsserts() {
        Person person = new Person("John", "Doe", 30);

        // Check if the object satisfies the given condition(s)
        assertThat(person)
                .satisfies(p -> {
                    assertThat(p.getFirstName()).isEqualTo("John");
                    assertThat(p.getAge()).isGreaterThanOrEqualTo(18);
                });
    }

    @Test
    public void optionalAsserts() {
        Optional<String> presentOptional = Optional.of("AssertJ");
        Optional<String> emptyOptional = Optional.empty();

        // Check if the Optional is present (i.e., contains a value)
        assertThat(presentOptional)
                .isPresent();

        // Check if the Optional is empty (i.e., doesn't contain a value)
        assertThat(emptyOptional)
                .isEmpty();

        // Check if the Optional contains the specified value
        assertThat(presentOptional)
                .contains("AssertJ");

        // Check if the Optional contains a value that matches the given condition
        assertThat(presentOptional)
                .hasValueSatisfying(value -> assertThat(value).startsWith("Assert"));

        // Perform assertions on the value inside the Optional (if present)
        assertThat(presentOptional)
                .hasValueSatisfying(value -> {
                    assertThat(value).isNotEmpty();
                    assertThat(value).isEqualTo("AssertJ");
                });
    }
}
