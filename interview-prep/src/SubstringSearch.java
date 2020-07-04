import java.util.ArrayList;

public class SubstringSearch {

    public static ArrayList<String> findMostRepeatedSubstring(String fullString) {
        char[] characterList = fullString.toCharArray();
        // Let's say the string looks like this:
        // aabbaa ababab

        ArrayList<String> substringList = new ArrayList<>();

        for (int j = 0; j < characterList.length; j++) {
            for (int i = 0; i < characterList.length; i++) {
                String substring = fullString.substring(i, j);
                substringList.add(substring);
            }
        }

        System.out.println(substringList);

        return substringList;
    }

    public ListNode findMiddleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        if (head != null) {

            if (slow.next != null && fast.next.next != null) {

                fast = fast.next.next;
                slow = slow.next;

                findMiddleNode(slow);
            }
        }

        return slow;

    }
}
