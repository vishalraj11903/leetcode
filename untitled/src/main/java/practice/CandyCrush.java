package practice;

public class CandyCrush {
    public static void main(String... args) {
        String input = "abbacaa";
        System.out.println(crush(input));
        System.out.println(rremove(input));
    }

    // Time: O(N)
    // Space: O(N)
    static String rremove(String s) {
        // Use a StringBuilder as a stack
        StringBuilder stack = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);

            // If the stack is not empty and the top of the stack matches
            // the current character, remove duplicates
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == current) {
                // Remove the top of the stack
                stack.deleteCharAt(stack.length() - 1);

                // Skip over all consecutive duplicates
                while (i + 1 < n && s.charAt(i + 1) == current) {
                    i++;
                }
            } else {
                // Otherwise, push the current character to the stack
                stack.append(current);
            }
        }

        return stack.toString();
    }

    // Time: O(N ^ 2)
    // Space: O(N)
    static String crush(String input) {
        StringBuilder output = new StringBuilder(input);

        for (int i = 0; i < output.length(); ++i) {
            int start = i;
            while (start < output.length() - 1 && output.charAt(start) == output.charAt(start + 1)) {
                start++;
            }

            if (start != i) {
                output.delete(i, start + 1);
            }
        }

        if (input.length() == output.toString().length()) {
            return input;
        }

        return crush(output.toString());
    }
}
