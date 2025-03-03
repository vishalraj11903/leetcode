package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex {
    public static void main(String... args) {
        // Test Case 1: Normal case with varying populations
        Map<String, Double> map1 = Map.of("US", 100.4, "CA", 3.6, "MX", 5.8);
        System.out.println("Test Case 1 - Random pick from: " + map1);
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map1));
        }

        // Test Case 2: Only one country
        Map<String, Double> map2 = Map.of("US", 100.0);
        System.out.println("\nTest Case 2 - Single country: " + map2);
        System.out.println("Picked: " + RandomPickIndex.pickCountry(map2));

        // Test Case 3: All countries have the same population
        Map<String, Double> map3 = Map.of("US", 10.0, "CA", 10.0, "MX", 10.0);
        System.out.println("\nTest Case 3 - Equal populations: " + map3);
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map3));
        }

        // Test Case 4: Highly skewed populations
        Map<String, Double> map4 = Map.of("US", 1000.0, "CA", 1.0, "MX", 1.0);
        System.out.println("\nTest Case 4 - Highly skewed populations: " + map4);
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map4));
        }

        // Test Case 5: Edge case - Map with no entries
        Map<String, Double> map5 = Map.of();
        System.out.println("\nTest Case 5 - Empty map: " + map5);
        try {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map5));
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test Case 6: Edge case - Countries with zero population
        Map<String, Double> map6 = Map.of("US", 0.0, "CA", 0.0, "MX", 0.0);
        System.out.println("\nTest Case 6 - Zero population for all countries: " + map6);
        try {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map6));
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test Case 7: Countries with fractional populations
        Map<String, Double> map7 = Map.of("US", 0.5, "CA", 1.5, "MX", 2.0);
        System.out.println("\nTest Case 7 - Fractional populations: " + map7);
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map7));
        }

        // Test Case 8: Large populations
        Map<String, Double> map8 = Map.of("US", 1_000_000.0, "CA", 100_000.0, "MX", 50_000.0);
        System.out.println("\nTest Case 8 - Large populations: " + map8);
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked: " + RandomPickIndex.pickCountry(map8));
        }
    }

    private static String pickCountry(Map<String, Double> map) {
        String[] countries = getCountries(map);
        Double[] population = getPopulation(map);

        Double total = 0.0;
        Double[] prefixes = new Double[population.length];
        for (int index = 0; index < population.length; ++index) {
            total += population[index];
            prefixes[index] = total;
        }

        int left = 0, right = prefixes.length - 1;
        double target = new Random().nextDouble() * total;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixes[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return countries[left];
    }

    private static String[] getCountries(Map<String, Double> map) {
        String[] countries = new String[map.size()];
        int index = 0;
        for (String current : map.keySet()) {
            countries[index++] = current;
        }
        return countries;
    }

    private static Double[] getPopulation(Map<String, Double> map) {
        Double[] population = new Double[map.size()];
        int index = 0;
        for (Double current : map.values()) {
            population[index++] = current;
        }
        return population;
    }
}
