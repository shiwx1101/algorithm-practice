package algorithm.leetcode.problem.list;


import java.util.List;

/**
 * Sort a linked list using insertion sort.
 * <p>
 * <p>
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 * <p>
 * <p>
 * Algorithm of Insertion Sort:
 * <p>
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode point = head;

        while (null != point.next) {
            if (point.next.val >= point.val) {
                point = point.next;
            } else {
                ListNode tmp = point.next.next;
                head = findPosition(head, point.next);
                point.next = tmp;
            }
        }
        return head;
    }

    private ListNode findPosition(ListNode head, ListNode node) {
        if (node.val <= head.val) {
            node.next = head;
            head = node;
            return head;
        }
        ListNode fetch = head;
        ListNode pre = new ListNode(0, fetch);
        while (node.val > fetch.val) {
            pre = fetch;
            fetch = fetch.next;
        }
        pre.next = node;
        node.next = fetch;
        return head;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
