package practice;

public class LinkedListComparitor {
    static class ListNode {
        public String Val;
        public ListNode Next;

        public ListNode(String val) {
            Val = val;
            Next = null;
        }
    }

    static boolean compare(ListNode first, ListNode second) {
        int i = 0, j = 0;
        while (first != null && second != null) {
            String val1 = first.Val;
            String val2 = second.Val;
            while (i < val1.length() && j < val2.length()) {
                if (val1.charAt(i) != val2.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }

            if (i == val1.length()) {
                first = first.Next;
                i = 0;
            }

            if (j == val2.length()) {
                second = second.Next;
                j=0;
            }
        }

        return first == null && second == null;
    }

    public static void main(String... args) {
        ListNode head1 = new ListNode("He");
        head1.Next = new ListNode(" llo");
        head1.Next.Next = new ListNode("wor");
        head1.Next.Next.Next = new ListNode("ld");

        // Create List 2
        ListNode head2 = new ListNode("H");
        head2.Next = new ListNode("e");
        head2.Next.Next = new ListNode("ll");
        head2.Next.Next.Next = new ListNode("owo");
        head2.Next.Next.Next.Next = new ListNode("r");
        head2.Next.Next.Next.Next.Next = new ListNode("ld");

        System.out.println(compare(head1, head2));
        System.out.println(compare1(head1, head2));
    }

    static boolean compare1(ListNode first, ListNode second) {
        int firstStringPtr = 0, secondStringPtr = 0;
        while (first != null && second != null) {
            String firstString = first.Val.trim();
            String secondString = second.Val.trim();


            while (firstStringPtr < firstString.length() && secondStringPtr < secondString.length()) {
                if (firstString.charAt(firstStringPtr) != secondString.charAt(secondStringPtr)) {
                    return false;
                }
                firstStringPtr++;
                secondStringPtr++;
            }

            if (firstStringPtr == firstString.length()) {
                first = first.Next;
                firstStringPtr = 0;
            }

            if (secondStringPtr == secondString.length()) {
                second = second.Next;
                secondStringPtr = 0;
            }
        }

        return first == null && second == null;
    }

}
