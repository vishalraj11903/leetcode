package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveFolder {
    static class Trie {
        Map<String, Trie> node;
        boolean isWord;
        Trie() {
            node = new HashMap<>();
        }
    }

    public static void main(String... args) {
        Trie root = new Trie();
        String[] input = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        for (String node : input) {
            Trie current = root;
            for (String val : node.split("/")) {
                if ("".equals(val)) {
                    continue;
                }
                current.node.putIfAbsent(val, new Trie());
                current = current.node.get(val);
            }
            current.isWord = true;
        }

        List<String> result = new ArrayList<>();
        process(root, result, "");
        System.out.println(result);
    }


    static void process(Trie root, List<String> result, String s) {
        if (root.isWord) {
            result.add(s);
            return;
        }

        for (Map.Entry<String, Trie> entry : root.node.entrySet()) {
            process(entry.getValue(), result, s + "/" +entry.getKey());
        }
    }












  /*  public static void main(String... args) {
        Trie root = new Trie();
        String[] input = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        for (String current : input) {
            String[] arr = current.split("/");
            Trie currTrie = root;
            for (String val : arr) {
                if ("".equals(val)) {
                    continue;
                }
                currTrie.node.putIfAbsent(val, new Trie());
                currTrie = currTrie.node.get(val);
            }
            currTrie.isWord = true;
        }

        List<String> result = new ArrayList<>();
        calc(root, new ArrayList<>(), result);

        System.out.println(result);
    }

    private static void calc(Trie root, ArrayList<String> objects, List<String> result) {
        if (root.isWord) {
            StringBuilder output = new StringBuilder("/");
            for (String val : objects) {
                output.append(val).append("/");
            }
            result.add(output.toString());
            return;
        }

        for (Map.Entry<String, Trie> current : root.node.entrySet()) {
            objects.add(current.getKey());
            calc(current.getValue(), objects, result);
            objects.remove(objects.size() - 1);
        }
    }*/
}
