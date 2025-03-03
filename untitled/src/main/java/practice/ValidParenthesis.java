package practice;

import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String... args) {
        String input = "{(){}[]}";
        Map<Character, Character> map = Map.of('}', '{', ']', '[', ')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == map.get(ch)) {
                   // stack.pop();
                    System.out.println("Invalid");
                    break;
                } else {
                    stack.push(ch);
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
