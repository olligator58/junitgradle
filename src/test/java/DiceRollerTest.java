import org.example.DiceRoller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiceRollerTest {
    private Random rnd = mock(Random.class);
    private DiceRoller diceRoller = new DiceRoller(rnd);

    @Test
    @DisplayName("Given any dice, when roll with random number == 0, then return 1")
    void minimumDiceValueTest() {
        int dice = 100;
        when(rnd.nextInt(dice)).thenReturn(0);  // #1

        int result = diceRoller.roll(dice);

        assertEquals(1, result);
    }
}
