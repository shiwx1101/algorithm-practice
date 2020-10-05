package algorithm.leetcode.problem.list;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers.
 * <p>
 * The digits are stored in reverse order and each of their nodes contain a
 * single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * <p>
 * <p>
 * <p>
 * public class ListNode { int val; ListNode next; ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);

        ListNode rNode = result;
        //0标
        ListNode markZero = new ListNode(0);
        //余数
        int res;
        //进位
        int remain = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = markZero;
            }
            if (l2 == null) {
                l2 = markZero;
            }
            res = (l1.val + l2.val + remain) % 10;
            result.next = new ListNode(res);
            result = result.next;
            remain = (l1.val + l2.val + remain) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        //两数相加完成最后还有进位  比如5+5
        if (remain == 1) {
            result.next = new ListNode(1);
        }
        return rNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        // l2.next.next = new ListNode(4);

        ListNode result = new AddTwoNumber().addTwoNumbers(l1, l2);
        showListNodeVal(result);

    }

    public static void showListNodeVal(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "    ");
            l = l.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}

