package amzn;

import java.util.*;

public class ItineraryReconstructor {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        // Build the graph (Adjacency List with Min-Heap)
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            // If the key doesn't exist, initialize a new PriorityQueue for the destination list
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).add(to);
        }

        List<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);

        // While there are destinations from this airport, visit the smallest lexicographically first
        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, itinerary);
        }

        // Add to itinerary after visiting all reachable airports (Post-order DFS)
        itinerary.add(0, airport);
    }

    public static void main(String[] args) {
        ItineraryReconstructor solver = new ItineraryReconstructor();
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK","SFO"),
                Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),
                Arrays.asList("ATL","JFK"),
                Arrays.asList("ATL","SFO")
        );

        System.out.println(solver.findItinerary(tickets));
    }
}
