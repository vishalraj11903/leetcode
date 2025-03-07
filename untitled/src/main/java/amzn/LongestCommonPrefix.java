package amzn;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int max = Integer.MIN_VALUE;
        for (String current : strs) {
            max = Math.max(max, current.length());
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < max; ++i) {
            char ch1 = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                char ch2 = strs[j].charAt(j);
                if (ch1 != ch2) {
                    return output.toString();
                }
            }
            output.append(ch1);
        }

        return output.toString();
    }
}
