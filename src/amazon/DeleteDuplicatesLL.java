package amazon;

import java.util.*;

public class DeleteDuplicatesLL {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public void removeDuplicates(ListNode head) {

        ListNode current = head;

        if (head == null) {
            return;
        }

        Set<Integer> set = new HashSet<>();

        ListNode previous = null;

        while (current != null) {
            if (set.contains(current.val)) {
                previous.next = current.next;
            } else {
                set.add(current.val);
                previous = current;

            }

            current = current.next;
        }

    }

    public boolean deleteNode(ListNode n) {

        if (n == null || n.next == null) {
            return false;
        }

        ListNode next = n.next;
        n.val = next.val;
        n.next = next.next;
        return true;

    }

}