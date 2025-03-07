package amzn;

import java.util.*;

class WebsiteLog {
    String time;
    String customerId;
    String page;

    public WebsiteLog(String time, String customerId, String page) {
        this.time = time;
        this.customerId = customerId;
        this.page = page;
    }
}

public class TopPageSequences {

    // Method to find top 3-page sequences visited by customers
    public static List<String> findTop3PageSequences(List<WebsiteLog> logs) {
        // Map to store customer visit history
        Map<String, List<String>> customerPageHistory = new HashMap<>();

        // Step 1: Collect page visits for each customer
        for (WebsiteLog log : logs) {
            customerPageHistory.putIfAbsent(log.customerId, new ArrayList<>());
            customerPageHistory.get(log.customerId).add(log.page);
        }

        // Map to store the frequency of each 3-page sequence
        Map<String, Integer> sequenceCount = new HashMap<>();

        // Step 2: Generate 3-page sequences for each customer and count their occurrences
        for (String customerId : customerPageHistory.keySet()) {
            List<String> pages = customerPageHistory.get(customerId);

            // Sliding window to get all sequences of length 3
            for (int i = 0; i < pages.size() - 2; i++) {
                String sequence = pages.get(i) + "->" + pages.get(i + 1) + "->" + pages.get(i + 2);
                sequenceCount.put(sequence, sequenceCount.getOrDefault(sequence, 0) + 1);
            }
        }

        // Step 3: Sort sequences by their count in descending order
        List<Map.Entry<String, Integer>> sortedSequences = new ArrayList<>(sequenceCount.entrySet());
        sortedSequences.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue()); // Sort by count in descending order

        // Step 4: Return the top 3 sequences
        List<String> top3Sequences = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sortedSequences.size()); i++) {
            top3Sequences.add(sortedSequences.get(i).getKey());
        }

        return top3Sequences;
    }

    public static void main(String[] args) {
        // Sample logs
        List<WebsiteLog> logs = Arrays.asList(
                new WebsiteLog("11:00", "CustomerA", "A"),
                new WebsiteLog("11:01", "CustomerA", "B"),
                new WebsiteLog("11:00", "CustomerB", "A"),
                new WebsiteLog("11:02", "CustomerA", "C"),
                new WebsiteLog("11:01", "CustomerB", "B"),
                new WebsiteLog("11:01", "CustomerC", "A"),
                new WebsiteLog("11:04", "CustomerA", "D"),
                new WebsiteLog("11:04", "CustomerA", "E")
        );

        // Find the top 3 sequences
        List<String> topSequences = findTop3PageSequences(logs);

        // Output the top 3 sequences
        System.out.println("Top 3 Page Sequences:");
        for (String sequence : topSequences) {
            System.out.println(sequence);
        }
    }
}
