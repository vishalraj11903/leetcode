package practice;

public class AddTwoStrings {
    public static void main(String... args) {
        String input = "0.9";
        String input2 = "0.94";

        String[] firstTokens = input.split("\\.");
        String[] secondTokens = input2.split("\\.");

        String firstBeforeDecimal = firstTokens[0];
        String secondBeforeDecimal = secondTokens[0];

        String firstAfterDecimal = firstTokens.length > 1 ? firstTokens[1] : firstTokens[0];
        String secondAfterDecimal = secondTokens.length > 1 ? secondTokens[1] : secondTokens[0];

        String sumOfAfterDecimal = sumAfterDecimal(firstAfterDecimal, secondAfterDecimal);

        int carry = (sumOfAfterDecimal.length() > Math.max(firstAfterDecimal.length(), secondAfterDecimal.length()) ? 1 : 0);


        String sumOfBeforeDecimal = add(firstBeforeDecimal, secondBeforeDecimal, carry);

        if (carry > 0) {
            sumOfAfterDecimal = sumOfAfterDecimal.substring(1);
        }
        System.out.println(sumOfBeforeDecimal + "." + sumOfAfterDecimal);
    }

    static String sumAfterDecimal(String decimal1, String decimal2) {
        int diff = Math.abs(decimal1.length() - decimal2.length());
        if (diff > 0) {
            if (decimal1.length() < decimal2.length()) {
                decimal1 = rightPad(decimal1, diff);
            } else {
                decimal2 = rightPad(decimal2, diff);
            }
        }

        return add(decimal1, decimal2, 0);
    }

    static String add(String input1, String input2, int carry) {
        int first = input1.length() - 1;
        int second = input2.length() - 1;
        StringBuilder output = new StringBuilder();
        while (first >= 0 && second >= 0) {
            int sum = (input1.charAt(first) - '0') + (input2.charAt(second) - '0') + carry;
            output.append(sum % 10);
            carry = sum / 10;
            first--;
            second--;
        }
        if (carry > 0) {
            output.append(carry);
        }
        output.reverse();
        return output.toString();
    }

    private static String rightPad(String decimal, int diff) {
        StringBuilder output = new StringBuilder(decimal);
        while (diff-- > 0) {
            output.append("0");
        }

        return output.toString();
    }

}
