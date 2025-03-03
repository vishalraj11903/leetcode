package practice;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String... args) {
        cd("/a/b/c/", "../"); // /a/b
        cd("/a/b/", "."); // a/b
    }

    static String cd(String directory, String path) {
        StringBuilder output = new StringBuilder("/");
        Stack<String> stack = new Stack<>();
        String totalPath = directory + path;
        String[] tokens = totalPath.split("/");//a,b,c
        for (String token : tokens) {
            if ("".equals(token) || ".".equals(token)) {
                continue;
            }

            if (!stack.isEmpty() && "..".equals(token)) {
                stack.pop();
            } else if (!"..".equals(token)) {
                stack.push(token);
            }
        }

        for (String val : stack) {
            output.append(val).append("/");
        }

        if (output.length() > 1) {
            output.deleteCharAt(output.length() - 1);
        }
        System.out.println(output);
        return output.toString();
    }
}
