package amzn;

import java.util.*;

public class ClosestAmazonGoLocations {

    // Method to calculate the distance squared from the customer's location [0,0]
    private static int calculateDistanceSquared(int x, int y) {
        return x * x + y * y;
    }

    // Method to return K closest Amazon Go locations
    public static List<int[]> findKClosestLocations(int[][] locations, int K) {
        // Create a priority queue to sort locations by distance squared
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
                calculateDistanceSquared(a[0], a[1]) - calculateDistanceSquared(b[0], b[1])
        );

        // Add each location to the priority queue
        for (int[] location : locations) {
            minHeap.offer(location);
        }

        // Extract the K closest locations from the priority queue
        List<int[]> closestLocations = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            closestLocations.add(minHeap.poll());
        }

        return closestLocations;
    }

    public static void main(String[] args) {
        int[][] amazonGoLocations = {
                {1, 2},
                {1, 1},
                {5, 5}
        };

        int K = 2; // Example: find the 2 closest locations

        List<int[]> closestLocations = findKClosestLocations(amazonGoLocations, K);

        // Print the K closest locations
        System.out.println("The " + K + " closest Amazon Go locations are:");
        for (int[] location : closestLocations) {
            System.out.println(Arrays.toString(location));
        }
        System.out.println("--");
        closestLocations = findCloses(amazonGoLocations, K);
        for (int[] location : closestLocations) {
            System.out.println(Arrays.toString(location));
        }
    }

    static List<int[]> findCloses(int[][] locations, int k) {
        PriorityQueue<Record> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        for (int[] location: locations) {
            pq.add(new Record(location));
            if (pq.size() > k) {
                pq.poll();
            }
        }


        List<int[]> result = new ArrayList<>();
        for (Record value : pq) {
            result.add(value.location);
        }

        return result;
    }

    static class Record {
        int[] location;
        int distance;
        public Record(int[] location) {
            this.location = location;
            this.distance = this.location[0] * this.location[0] + location[1] * location[1];
        }
    }
}
