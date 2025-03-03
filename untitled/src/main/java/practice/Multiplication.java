package practice;

public class Multiplication {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Count the decimal places and remove decimals
        int decimalPlaces1 = num1.contains(".") ? num1.length() - 1 - num1.indexOf(".") : 0;
        int decimalPlaces2 = num2.contains(".") ? num2.length() - 1 - num2.indexOf(".") : 0;
        int totalDecimalPlaces = decimalPlaces1 + decimalPlaces2;

        // Remove decimal points for multiplication
        num1 = num1.replace(".", "");
        num2 = num2.replace(".", "");

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        // Multiply digits
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = pos[i + j + 1] + mul;
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        // Add decimal point if needed
        if (totalDecimalPlaces > 0) {
            sb.insert(sb.length() - totalDecimalPlaces, ".");
        }

        // Remove leading or trailing zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // Handle case where result is just a decimal point
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Multiplication().multiply("12.3", "4.56")); // Expected output: 56.088
        System.out.println(new Multiplication().multiply("0.1", "0.1"));   // Expected output: 0.01
        System.out.println(new Multiplication().multiply("123", "456"));   // Expected output: 56088
    }

}
