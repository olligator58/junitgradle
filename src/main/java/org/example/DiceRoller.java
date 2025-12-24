package org.example;

import java.util.Random;

public class DiceRoller {
    private final Random random;

    public DiceRoller(Random random) {
        this.random = random;
    }

    public int roll(int sides) {
        return random.nextInt(sides) + 1;
    }
}
