package amzn;

import java.util.*;
/**
 * amazon customers look at various product detail webpages each day.
 * You have access to the web logs. For a targeted ad campaign, we want
 * to find customers with repeating visits across two consecutive days.
 * How will you solve this ?
 */
public class AmazonVisitPages {
    public static List<Integer> findRepeatingVisitors(List<String> logs) {
        Map<Integer, Integer> customerVisitCount = new HashMap<>();

        // Count visits for each customer
        for (String log : logs) {
            String[] parts = log.split(", ");
            int customerId = Integer.parseInt(parts[0]);

            customerVisitCount.put(customerId, customerVisitCount.getOrDefault(customerId, 0) + 1);
        }

        // Filter customers with more than one visit
        List<Integer> repeatingCustomers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : customerVisitCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingCustomers.add(entry.getKey());
            }
        }

        return repeatingCustomers;
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "1001, 2025-03-01 12:30:00, P123",
                "1001, 2025-03-02 14:45:00, P456",
                "1002, 2025-03-01 10:00:00, P789",
                "1002, 2025-03-03 09:15:00, P321",
                "1003, 2025-03-05 11:20:00, P654",
                "1003, 2025-03-06 13:40:00, P987",
                "1003, 2025-03-07 15:10:00, P852",
                "1004, 2025-03-08 12:30:00, P777"  // Only one visit, should not be in output
        );

        List<Integer> result = findRepeatingVisitors(logs);
        System.out.println("Customers with repeating visits: " + result);
    }
}
