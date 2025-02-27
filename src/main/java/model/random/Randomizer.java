package model.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Randomizer {


    // Igy müködik
    public static void main(String[] args) {
        RandomSingleton randomSingleton = RandomSingleton.getInstance();

//        randomSingleton.setSeed(1);

        // Define objects and their corresponding percentages
        List<String> objects = Arrays.asList("obj1", "obj2");
        List<Double> percentages = Arrays.asList(99.0, 1.0);

        // Test the weighted random selection
        Map<String, Integer> resultCounts = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            String selected = randomSingleton.weightedRandom(objects, percentages);
            resultCounts.put(selected, resultCounts.getOrDefault(selected, 0) + 1);
        }

        // Print the results
        System.out.println("Selection counts:");
        resultCounts.forEach((obj, count) -> System.out.println(obj + ": " + count + " times"));
    }
}
