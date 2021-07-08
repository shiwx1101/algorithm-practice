/**
 * Copyright (c) 2018-2020 XianChengKeJi.Co.Ltd. All Rights Reserved.
 */
package algorithm.problem.list;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 * @author shiwenxiang
 * @version 1: ReverseLinkedListII.java, v0.1 2020/8/5 shiwenxiang Exp $$
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n < m || n <= 0 || m <= 0) {
            throw new RuntimeException();
        }
        if (head == null || head.next == null || m == n) {
            return head;
        }
        int index = 1;
        boolean flag = false;
        ListNode o_tail = null;
        ListNode o_head = null;
        ListNode pre = new ListNode(0,head);
        ListNode f = pre;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            if (index >= m && index <= n) {
                if (index == m) {
                    flag = true;
                    o_tail = cur;
                    o_head = pre;
                }
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            } else {
                if (flag) {
                    o_tail.next = cur;
                    o_head.next = pre;
                    flag = false;
                }
                next = cur.next;
                pre = cur;
                cur = next;
            }
            index++;
        }
        if (flag) {
            o_tail.next = null;
            o_head.next = pre;
        }
        return f.next;
    }

    public void show(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public void test() {
        ListNode c = getInitC();
        show(reverseBetween(c, 1, 5));
    }

    ListNode getInitC() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        return a;
    }

    public static void main(String[] args) {
        new ReverseLinkedListII().test();
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
