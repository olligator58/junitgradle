import org.example.PasswordStrength;
import org.example.PasswordUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordTest {

    @ParameterizedTest
    @MethodSource("provideStrongPasswords")
    void testStrongPasswords(String password) {
        assertEquals(PasswordStrength.STRONG, PasswordUtils.getStrength(password));
    }

    @ParameterizedTest
    @MethodSource("provideMediumPasswords")
    void testMediumPasswords(String password) {
        assertEquals(PasswordStrength.MEDIUM, PasswordUtils.getStrength(password));
    }

    @ParameterizedTest
    @MethodSource("provideWeakPasswords")
    void testWeakPasswords(String password) {
        assertEquals(PasswordStrength.WEAK, PasswordUtils.getStrength(password));
    }

    static List<String> provideStrongPasswords() {
        return List.of("aN we2aM", "*****Jj0", "Ux134!&w");
    }

    static List<String> provideMediumPasswords() {
        return List.of("QWERTY23", "Admin012", "2418^ax00");
    }

    static List<String> provideWeakPasswords() {
        return List.of("password", "f8HdA*", "320220101");
    }
}
