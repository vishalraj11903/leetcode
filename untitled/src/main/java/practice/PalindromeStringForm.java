package practice;

public class PalindromeStringForm
{
    public static void main(String... args) {
        String input = "aabbkkk";
        int[] ch = new int[26];
        for (int i = 0; i < input.length(); ++i) {
            ch[input.charAt(i) - 'a']++;
        }
        StringBuilder output = new StringBuilder();
        char odd = '#';
        for (int i = 0; i < ch.length; ++i) {
            int freq = ch[i];
            if (freq % 2 != 0) {
                odd = (char) (i + 'a');
            }

            int count = freq / 2;
            while (count-- > 0) {
                output.append((char) (i + 'a'));
            }
        }

        String rev = output.reverse().toString();
        if (odd != '#') {
            output.reverse().append(odd);
        }

        output.append(rev);
        System.out.println(output);
    }
}
