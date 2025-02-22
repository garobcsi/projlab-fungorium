package model;

import java.util.Random;

public class RandomSingleton {

    // Private static instance of the class
    private static RandomSingleton instance;

    private final Random random;

    // Private constructor to prevent instantiation from outside
    private RandomSingleton() {
        random = new Random();
    }

    // Public method to provide access to the singleton instance
    public static RandomSingleton getInstance() {
        if (instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }

    // Method to generate a random integer
    public int nextInt() {
        return random.nextInt();
    }

    // Method to generate a random integer within a specified range
    public int nextInt(int bound) {
        return random.nextInt(bound);
    }

    // Method to generate a random double between 0.0 and 1.0
    public double nextDouble() {
        return random.nextDouble();
    }

    // Method to generate a random boolean
    public boolean nextBoolean() {
        return random.nextBoolean();
    }

    // Method to generate a random number within a range [from, to]
    public int randomizeInRange(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("'from' must be less than or equal to 'to'");
        }
        return from + random.nextInt(to - from + 1);
    }

    // Method to check if a given percentage chance occurs
    public boolean chance(double percent) {
        if (percent < 0.0 || percent > 100.0) {
            throw new IllegalArgumentException("Percentage must be between 0.0 and 100.0");
        }
        double randomValue = random.nextDouble() * 100.0;
        return randomValue < percent;
    }
}
