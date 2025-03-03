package org.example;

public class AddTwoStrings {
    public static void main(String... args) {
        String input = "2.03";
        String input2 = "12.3111";
        String[] first = input.split("\\.");
        String[] second = input2.split("\\.");
        String firstNum = first[0];
        String secondNum = second[0];
        String firstFraction = first.length > 0 ? first[1] : "0";
        String secondFraction = second.length > 0 ? second[1] : "0";
        if (firstFraction.length() > secondFraction.length()) {
            int diff = firstFraction.length() - secondFraction.length();
            while (diff-- >0) {
                secondFraction += "0";
            }
        } else {
            int diff = secondFraction.length() - firstFraction.length();
            while (diff-- >0) {
                firstFraction += "0";
            }
        }

        String[] afterDot = add(firstFraction, secondFraction, 0);
        String output = finalResult(firstNum, secondNum, afterDot);
        System.out.println(output + "." + afterDot[1]);
    }

    static String finalResult(String first, String second, String[] fractions) {
        int carry = Integer.valueOf(fractions[0]);
        return add(first, second, carry)[1];
    }
    static String[] add(String first, String second, int carry) {
        int firstPointer = first.length() - 1;
        int secondPointer = second.length() - 1;
        StringBuilder output = new StringBuilder();
        while (firstPointer >= 0 && secondPointer >= 0) {
            int val1 = first.charAt(firstPointer) - '0';
            int val2 = second.charAt(secondPointer) - '0';
            int sum = val1 + val2 + carry;
            output.append(sum % 10);
            carry = sum / 10;
            firstPointer--;
            secondPointer--;
        }

        while (firstPointer >= 0) {
            int val1 = first.charAt(firstPointer) - '0';
            int sum = val1 + carry;
            output.append(sum % 10);
            carry = sum / 10;
            firstPointer--;
        }

        while (secondPointer >= 0) {
            int val1 = second.charAt(secondPointer) - '0';
            int sum = val1 + carry;
            output.append(sum % 10);
            carry = sum / 10;
            secondPointer--;
        }

        output.reverse();
        return new String[] { carry + "", output.toString()};
    }
}
