package practice;

import java.util.HashMap;
import java.util.Map;

public class Balanceparanthesis2 {
    public static void main(String... args) {
        System.out.println(minRemoveToMakeValidMulti("[ lee(t(c)o)))]d[[e)(({{}}}")); // Expected: lee(t(c)o)de{{}}
        System.out.println(minRemoveToMakeValidMulti("(()))))minmer((((()([][[{{}"));  // Expected: (())minmer()[]{}
        System.out.println(minRemoveToMakeValidMulti("([]{})"));                      // Expected: ([]{})
        System.out.println(minRemoveToMakeValidMulti("[{({([}"));                    // Expected: {}
        System.out.println(minRemoveToMakeValidMulti(")))"));                        // Expected: ""
        System.out.println(minRemoveToMakeValidMulti("(((("));
    }

    static String minRemoveToMakeValidMulti(String s) {
        StringBuilder output = new StringBuilder();
        Map<Character, Character> closingMap = Map.of(')', '(', '}', '{', ']', '[');
        Map<Character, Character> openingMap = Map.of('(', ')', '{', '}', '[', ']');
        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (openingMap.containsKey(ch)) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            } else if (closingMap.containsKey(ch)) {
                if (countMap.getOrDefault(closingMap.get(ch), 0) == 0) {
                    continue;
                }
                countMap.put(closingMap.get(ch), countMap.get(closingMap.get(ch)) - 1);
            }
            output.append(ch);
        }

        s = output.toString();
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (closingMap.containsKey(ch)) {
                countMap.put(ch, countMap.getOrDefault(ch, 0 ) + 1);
            } else if (openingMap.containsKey(ch)) {
                if (countMap.getOrDefault(openingMap.get(ch), 0) == 0) {
                    continue;
                }
                countMap.put(openingMap.get(ch), countMap.get(openingMap.get(ch)) - 1);
            }
            result.append(ch);
        }

        return result.reverse().toString();
    }


    static String minRemoveToMakeValid(String s) {
        StringBuilder output = new StringBuilder();
        int open = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }

            output.append(ch);
        }

        int close = 0;
        StringBuilder result = new StringBuilder();
        s = output.toString();
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch == ')') {
                close++;
            } else if (ch == '(') {
                if (close == 0) {
                    continue;
                }
                close--;
            }
            result.append(ch);
        }

        return result.reverse().toString();
    }
}
