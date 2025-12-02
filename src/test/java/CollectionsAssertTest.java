import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class CollectionsAssertTest {

    @Test
    public void listAsserts() {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript");

        assertThat(languages).contains("Python", "Java");

        assertThat(languages).containsExactlyInAnyOrder("JavaScript", "Python", "Java");

        assertThat(languages).containsExactly("Java", "Python", "JavaScript");

        assertThat(languages).doesNotContain("PHP");
    }

    @Test
    public void setAsserts() {
        Set<String> languages = new HashSet<>(Arrays.asList("Java", "Python", "JavaScript"));

        // Check if the set contains the given elements
        assertThat(languages)
                .contains("Python", "Java");

        // Check if the set contains exactly the given elements (and nothing else)
        assertThat(languages)
                .containsExactlyInAnyOrder("JavaScript", "Python", "Java");

        // Check if the set doesn't contain the given element
        assertThat(languages)
                .doesNotContain("PHP");
    }

    @Test
    public void mapAsserts() {
        Map<String, Integer> languageRanks = new HashMap<>();
        languageRanks.put("Java", 1);
        languageRanks.put("Python", 2);
        languageRanks.put("JavaScript", 3);

        // Check if the map contains the given entry
        assertThat(languageRanks)
                .containsEntry("Python", 2);

        // Check if the map contains the given key
        assertThat(languageRanks)
                .containsKey("Java");

        // Check if the map contains the given value
        assertThat(languageRanks)
                .containsValue(3);

        // Check if the map has the expected size
        assertThat(languageRanks)
                .hasSize(3);

        // Check if the map doesn't contain the given key
        assertThat(languageRanks)
                .doesNotContainKey("PHP");
    }
}
