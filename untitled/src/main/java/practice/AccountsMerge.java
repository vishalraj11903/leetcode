package practice;

import java.util.*;

/**
 * Time complexity: O(NKlogNK)
 * N -> Number of emails
 * K -> Max length of email
 *
 * Space complexity:
 *
 * O(NK)
 */
public class AccountsMerge {
    public static void main(String... args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        list.add(Arrays.asList("Kevin","Kevin3@m.co","Gabe3@m.co","Kevin0@m.co"));
        list.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
        list.add(Arrays.asList("Hanzo","Ethan4@m.co","Hanzo1@m.co","Hanzo0@m.co"));
        list.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        createAdjacent(list, adj, emailToName);

        Set<Set<String>> result = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, String> entry : emailToName.entrySet()) {
            Set<String> group = new HashSet<>();
            if (!visited.contains(entry.getKey())) {
                groupThem(adj, emailToName, group, visited, entry.getKey());
                if (!group.isEmpty()) {
                    result.add(group);
                }
            }
        }
        System.out.println(result);
    }

    private static void groupThem(Map<String, List<String>> adj, Map<String, String> emailToName, Set<String> group, Set<String> visited, String email) {
        if (emailToName.containsKey(email)) {
            group.add(emailToName.get(email));
        }
        visited.add(email);
        if (adj.containsKey(email)) {
            for (String emailNext : adj.get(email)) {
                if (!visited.contains(emailNext)) {
                    groupThem(adj, emailToName, group, visited, emailNext);
                }
            }
        }
    }

    private static void createAdjacent(List<List<String>> list, Map<String, List<String>> adj, Map<String, String> emailToName) {
        for (List<String> input : list) {
            String name = input.get(0);
            String firstEmail = input.get(1);
            emailToName.put(firstEmail, name);
            adj.putIfAbsent(firstEmail, new ArrayList<>());
            for (int index = 2; index < input.size(); ++index) {
                String secondEmail = input.get(index);
                adj.putIfAbsent(secondEmail, new ArrayList<>());
                adj.get(firstEmail).add(secondEmail);
                adj.get(secondEmail).add(firstEmail);
            }
        }
    }


}
