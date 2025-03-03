package practice;

import java.util.Map;
import java.util.Stack;
//Valid paranthesis
public class BalanceParanthesis {
    public static void main(String... args) {
        String input = "[}]";
        minParanthesis(input);
    }




    static void minParanthesis(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> open = Map.of('{', '}', '[', ']', '(' ,')');
        Map<Character, Character> close = Map.of('}', '{', ']', '[', ')' ,'(');
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); ++i) {
           char ch = input.charAt(i);
           if (open.containsKey(ch)) {
               output.append(ch);
               stack.push(ch);
           } else {
               /**
                * 1. Matching found
                * 2. No matching found
                * 3. Only closing
                */

               if (!stack.isEmpty() && ch == open.get(stack.peek())) {
                   stack.pop();
                   output.append(ch);
               } else if (!stack.isEmpty() && ch != open.get(stack.peek())) {
                   i--;
                   output.append(open.get(stack.pop()));
               } else {
                   output.insert(0, close.get(ch)).append(ch);
               }
           }
        }

        System.out.println(output);

    }
}
