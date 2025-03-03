package practice;

import java.util.*;

//This is leetcode hard.
public class InsertBigO {
    private List<String> list;
    private Map<String, List<Integer>> map;
    InsertBigO() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    void insert(String input) {
        list.add(input);
        map.putIfAbsent(input, new ArrayList<>());
        map.get(input).add(list.size());
    }

    String remove(String input) {
        if (!map.containsKey(input)) {
            return null;
        }

        //get
        String last = list.getLast();
        List<Integer> places = map.get(last);
        int lastIndex = places.getLast();
        //put
        map.get(input).add(lastIndex);
        list.set(lastIndex, last);

        //remove
        places.remove(places.size() - 1);
        if (places.isEmpty()) {
            map.remove(input);
        }
        list.remove(list.size() - 1);
        places.remove(0);

        return input;
    }

    public static void main(String... args) {
        InsertBigO obj = new InsertBigO();
        obj.insert("foo");
        obj.insert("bar");
        obj.insert("foo");
        obj.remove("foo");
    }
}
