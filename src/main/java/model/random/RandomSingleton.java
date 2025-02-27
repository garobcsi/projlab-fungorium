package model.random;

import java.util.List;
import java.util.Random;

public class RandomSingleton {

    // Private static instance of the class
    private static RandomSingleton instance;

    private Random random;

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

    // Method to set the seed for the Random instance
    public void setSeed(long seed) {
        random = new Random(seed);
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

    /**
     * Method to randomly select an object based on weighted percentages.
     *
     * @param objects    A list of objects to choose from.
     * @param percentages A list of percentages corresponding to each object.
     * @return The selected object based on the weighted percentages.
     * @throws IllegalArgumentException If the number of objects and percentages don't match,
     *                                  or if percentages don't sum to 100.
     */
    public <T> T weightedRandom(List<T> objects, List<Double> percentages) {
        if (objects.size() != percentages.size()) {
            throw new IllegalArgumentException("The number of objects and percentages must match.");
        }

        double totalPercentage = percentages.stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercentage - 100.0) > 0.0001) { // Allow for minor floating-point inaccuracies
            throw new IllegalArgumentException("Percentages must sum to 100.");
        }

        double cumulativePercentage = 0.0;
        for (int i = 0; i < objects.size(); i++) {
            cumulativePercentage += percentages.get(i);
            if (chance(cumulativePercentage)) {
                return objects.get(i);
            }
        }

        // This should never happen if percentages sum to 100
        throw new IllegalStateException("Failed to select an object based on percentages.");
    }
}
