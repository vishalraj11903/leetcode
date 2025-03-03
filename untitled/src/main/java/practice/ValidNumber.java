package practice;

public class ValidNumber {
    public static void main(String... args) {
        String input = "2.4";
        boolean dot = false, digit = false, exp = false;
        for (int i = 0; i < input.length(); ++i) {
           char ch = input.charAt(i);
           if (Character.isDigit(ch)) {
               digit = true;
           } else if (ch == '+' || ch == '-') {
               if (i > 0) {
                   System.out.println("Invalid number");
               }
           } else if (ch == '.') {
               if (dot) {
                   System.out.println("Invalid number");
               }
               dot = true;
           } else {
               System.out.println("Invalid number");
           }

        }

        System.out.println("Valid number");
    }
}
