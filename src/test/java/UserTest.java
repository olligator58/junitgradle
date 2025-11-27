import org.example.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    User user;

    @BeforeEach
    void createUser() {
        String username = "Alice";
        String password = "12345678";
        user = new User(username, password);
    }

    @Test
    void hasStrongPassword() {
        assertTrue(user.hasStrongPassword());
    }

    @Test
    void hasValidUsername() {
        assertTrue(user.hasValidUsername());
    }

    @Test
    void isValid() {
        assertTrue(user.isValid());
    }
}
