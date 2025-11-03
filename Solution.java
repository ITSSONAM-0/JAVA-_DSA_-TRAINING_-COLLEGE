// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // Main function to sort the linked list
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head; // Base case: empty or single node

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // break the list

        // Step 2: Sort each half recursively
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle of the list
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // for even nodes, slow will be at first mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes
        if (l1 != null)
            current.next = l1;
        if (l2 != null)
            current.next = l2;

        return dummy.next;
    }
}
